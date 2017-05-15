package com.alternateItinerary.API;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONObject;

import com.alternateItinerary.Config;
import com.alternateItinerary.Helper.FinalRiskFactorCalculator;
import com.alternateItinerary.Helper.RiskFactorCalculator;
import com.alternateItinerary.Model.NearestRelevantAirport.*;
import com.alternateItinerary.Model.GeoCodingApi.*;
import com.alternateItinerary.RequestResponse.AdminCustomResponse;
import com.alternateItinerary.RequestResponse.AlternateOriginCalculatorResponse;
import com.alternateItinerary.RequestResponse.FlightsLowFareResponse;
import com.alternateItinerary.RequestResponse.UserCustomResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class AlternateOriginCalculator {

	public AlternateOriginCalculatorResponse findAlternateOrigin(String riskFactorsValue[],String riskFactorsChecked[],String coordinates,String date,String date1,String previousDate1,String previousDate2,double fromRiskFactor,String toAirportCode){
		
		
		
		/*  1. Find the Latitude and Longitude of Origin */
		// we have taken the coordinates as argument of this function
		// find the latitude and longitude values from this coordinates JSON response which we got from 
		// the LcationCoordinates Class ( GoogleMaps Geocoding API)
		JSONObject json = new JSONObject(coordinates);
		Coordinates obj = new Gson().fromJson(coordinates,Coordinates.class);
		Double latitude = obj.getResults().get(0).getGeometry().getLocation().getLat();
		Double longitude = obj.getResults().get(0).getGeometry().getLocation().getLng();
		
		
		/*  2.  Consume the nearest relevant airport api using the above lat and long values */ 
		Client client = Client.create();
		WebResource webResource = client.resource("https://api.sandbox.amadeus.com/v1.2/airports/nearest-relevant");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("apikey", Config.sandboxKey);
		queryParams.add("latitude", latitude.toString());    // type casting double to String bcoz the latitude and longitude values are of type " Double " 
		queryParams.add("longitude", longitude.toString());
				
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
		TypeToken<List<AlternateOrigin>> token = new TypeToken<List<AlternateOrigin>>(){};
        List<AlternateOrigin> airportList = new Gson().fromJson(output2, token.getType());
        
        int size = airportList.size();
		
        /*  3. Check if there is a flight from the Nearest Airports found to the Destination -> Flights Low Fare api -> Uses date */
        /*  4. calculate the risk factor for all the cities found nearest to the ORIGIN which have a flight to the Destination */
		
        FlightsLowFare flf = new FlightsLowFare();
        FlightsLowFareResponse flfr;
        
        WeatherForecastApi obj2 = new WeatherForecastApi();
		RiskFactorCalculator rfc = new RiskFactorCalculator();
		LocationCoordinates obj3 = new LocationCoordinates();
		AirportAutocomplete obj4 = new AirportAutocomplete();
		AirportDelayIndex obj5 = new AirportDelayIndex();
		ReverseGeocodingApi rga = new ReverseGeocodingApi();
        TravelWarningIndex twi = new TravelWarningIndex();
		FlightRating fr = new FlightRating();
		FlightStatus fs = new FlightStatus();
		
		FinalRiskFactorCalculator final_rfc = new FinalRiskFactorCalculator();
    	
		int j = 0;
		
		// flight details 
		String[] airline = new String[size];
		String[] flightNumber = new String[size];
		
		// weather risk factor
		String[] originWeatherParameters = new String[size];
		String[] coordinate = new String[size]; 
		double[] WeatherRiskFactor = new double[size];
		
		// delay index
		String[] airportCode = new String[size];
		double[] delayIndex = new double[size];
		
		// travel warning risk factor
		double[] travelWarningRiskFactor = new double[size];
		
		// flight Rating Risk Factor
		double[] flightRatingRiskFactor = new double[size];
		
		// flight status risk factor
		double[] flightRiskFactor = new double[size];
		double[] flightStatusRiskFactor1 = new double[size];
		double[] flightStatusRiskFactor2 = new double[size];
		
		// Final Risk Factor
		double[] RiskFactor = new double[size];
		
		/* Important Note - CALCULATE THE FINAL RISK FACTOR FOR ALL THE CITIES NOT THE WEATHER RISK FACTOR FOR ALL THE CITIES */
		double min = fromRiskFactor;
		for(int i=0; i<size ;i++)
		{
			double[] originRiskFactors = new double[8];
		
			flfr = flf.findFlight(airportList.get(i).getAirport(),toAirportCode, date);
			if(!flfr.getBudget().equals("Unknown")){
		    
			// 1. Get the Flight Details -> Airline and Flight Number
			airline[i] = flfr.getAirline();
			flightNumber[i] = flfr.getFlight_number();
			
			
			// 2. Find Weather Risk Factor -> " Uses date "
			if(riskFactorsChecked[0].equals("1")){
			coordinate[i] = obj3.findCoordinates(airportList.get(i).getCityName());
			originWeatherParameters[i] = obj2.findParameters(coordinate[i],date);
			WeatherRiskFactor[i]= rfc.calclulateRiskFactor(originWeatherParameters[i]);
			originRiskFactors[0] = WeatherRiskFactor[i];
			}
			
			// 3. Find Airport Delay Index Risk Factor
			if(riskFactorsChecked[1].equals("1")){
			airportCode[i] = obj4.findAirportCode(airportList.get(i).getCityName());
			delayIndex[i] = obj5.findDelayIndex(airportCode[i]);
			originRiskFactors[1] = delayIndex[i];
			}
			
			// 4. Find Travel Warning Risk Factor
			if(riskFactorsChecked[7].equals("1")){
			String Country[] = rga.findCountryCode(coordinate[i]);
			String CountryCode = Country[0];
			travelWarningRiskFactor[i] = twi.findTravelWarningIndex(CountryCode);
			originRiskFactors[7] = travelWarningRiskFactor[i];
			}
			
			// 5. Find Flight Rating Risk Factor
			if(riskFactorsChecked[6].equals("1")){
			flightRatingRiskFactor[i] = fr.findFlightRating(airline[i], flightNumber[i]);
			originRiskFactors[6] = flightRatingRiskFactor[i];
			}
			
			// 6. Flight Status Risk Factor ( for Date of departure i.e date1 )
			if(riskFactorsChecked[2].equals("1")){
			flightRiskFactor[i] = fs.findFlightStatus(airline[i], flightNumber[i],date1,airportList.get(i).getAirport());
			originRiskFactors[2] = flightRiskFactor[i];
			}
			
			// 7. Flight Status Risk Factor ( for previousDate1 & previousDate2  )
			if(riskFactorsChecked[3].equals("1")){
			flightStatusRiskFactor1[i] = fs.findFlightStatus(airline[i], flightNumber[i],previousDate1,airportList.get(i).getAirport());
			flightStatusRiskFactor2[i] = fs.findFlightStatus(airline[i], flightNumber[i],previousDate2,airportList.get(i).getAirport());
			originRiskFactors[3] = (flightStatusRiskFactor1[i] + flightStatusRiskFactor2[i])/2;
			}
			
			// 8. Calculate Final Risk Factor
			RiskFactor[i] = final_rfc.calclulateOriginRiskFactor(riskFactorsChecked,riskFactorsValue,originRiskFactors);  
			
			System.out.println(" risk factor of "+ airportList.get(i).getCityName() + " is "+RiskFactor[i] );
			
			// risk factor not zero is put to avoid cities for which delay index and weather risk factor both are zero
			if(RiskFactor[i] < min && RiskFactor[i] != 0) 
			{
				min = RiskFactor[i];
				j = i;
			}
		}
		}
		
		double alternateOriginRiskFactor = min;
		
		// Put the Results into the Response Object
		AlternateOriginCalculatorResponse aocr = new AlternateOriginCalculatorResponse();
		aocr.setAlternateOrigin(airportList.get(j).getCityName());
		aocr.setAlternateOriginRiskFactor(alternateOriginRiskFactor);
		
		return aocr;
	}
}