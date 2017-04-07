package com.alternateItinerary.API;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONObject;

import com.alternateItinerary.Config;
import com.alternateItinerary.Helper.FinalRiskFactorCalculator;
import com.alternateItinerary.Helper.RiskFactorCalculator;
import com.alternateItinerary.Model.NearestRelevantAirport.*;
import com.alternateItinerary.Model.GeoCodingApi.*;
import com.alternateItinerary.Model.AccuWeatherApi.*;
import com.alternateItinerary.Model.LocationKey.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class AlternateOriginCalculator {

	public String findAlternateOrigin(String coordinates,String date){
		
		// we have taken the coordinates as argument of this function
		// now we will find the latitude and longitude values from this coordinates JSON response which we got from 
		// the LcationCoordinates Class ( GoogleMaps Geocoding API)
		
		JSONObject json = new JSONObject(coordinates);
		Coordinates obj = new Gson().fromJson(coordinates,Coordinates.class);
		Double latitude = obj.getResults().get(0).getGeometry().getLocation().getLat();
		Double longitude = obj.getResults().get(0).getGeometry().getLocation().getLng();
		System.out.println("latitude and longitude values of origin city are = "+latitude+" " +longitude);
		
		// Now consume the nearest relevant airport api using the above lat and long values :-
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
        //System.out.println(airportList.get(2).getAirportName());
//		String city = airportList.get(2).getCityName();
//		System.out.println(city);
		
		// calculate the risk factor for all the cities found nearest to the ORIGIN
		
		int size = airportList.size();
		WeatherForecastApi obj2 = new WeatherForecastApi();
		RiskFactorCalculator rfc = new RiskFactorCalculator();
		LocationCoordinates obj3 = new LocationCoordinates();
		AirportAutocomplete obj4 = new AirportAutocomplete();
		AirportDelayIndex obj5 = new AirportDelayIndex();
    	FinalRiskFactorCalculator final_rfc = new FinalRiskFactorCalculator();
		
		int j = 0;
		// weather risk factor
		String[] originWeatherParameters = new String[size];
		String[] coordinate = new String[size]; 
		double[] WeatherRiskFactor = new double[size];
		
		// delay index
		String[] airportCode = new String[size];
		double[] delayIndex = new double[size];
		
		// We do not need flight risk factor calculation for Risk at a City so we assign it a value of zero 
		double flightRiskFactor = 0.5;		
		double[] RiskFactor = new double[size];
		
		/* Important Note - CALCULATE THE FINAL RISK FACTOR FOR ALL THE CITIES NOT THE WEATHER RISK FACTOR FOR ALL THE CITIES */
		double min = 10;
		for(int i=0; i<size ;i++)
		{
			// 1. Find Weather Risk Factor
			coordinate[i] = obj3.findCoordinates(airportList.get(i).getCityName());
			originWeatherParameters[i] = obj2.findParameters(coordinate[i],date);
			WeatherRiskFactor[i]= rfc.calclulateRiskFactor(originWeatherParameters[i]);
			
			// 2. Find Delay Index
			airportCode[i] = obj4.findAirportCode(airportList.get(i).getCityName());
			delayIndex[i] = obj5.findDelayIndex(airportCode[i]);
			
			// 3. Calculate Final Risk Factor
			RiskFactor[i] = final_rfc.calclulateAlternateOriginRiskFactor(WeatherRiskFactor[i], delayIndex[i]);
			
			System.out.println(" risk factor of "+ airportList.get(i).getCityName() + " is "+RiskFactor[i] );
			
			// risk factor not zero is put to avoid cities for which delay index and weather risk factor both are zero
			if(RiskFactor[i] < min && RiskFactor[i] != 0) 
			{
				min = RiskFactor[i];
				j = i;
			}
		}
		
		// String fromCoordinates = obj.findCoordinates(from);
		
		
		
		/*
		// WEATHER RISK FACTOR CALCULATION USING ACCU-WEATHER API PARAMS
		 
		// calculate the risk factor for all the cities found nearest to the ORIGIN
		int size = airportList.size();
		LocationKey obj1 = new LocationKey();
		weatherForecast obj2 = new weatherForecast();
		RiskFactorCalculator rfc = new RiskFactorCalculator();
		int j = 0;
		String[] Key = new String[size];
		String[] originWeatherParameters = new String[size];
		double[] RiskFactor = new double[size];
		
		for(int i=0; i<size ;i++)
		{
			Key[i] = obj1.findLocationKey(airportList.get(i).getCityName());
			originWeatherParameters[i] = obj2.findParameters(Key[i]);
			RiskFactor[i] = rfc.calclulateRiskFactor(originWeatherParameters[i]);
			System.out.println(" risk factor of "+ airportList.get(i).getCityName() + " is "+RiskFactor[i] );
			if(RiskFactor[i] < 0.5)
			{
				j = i;
				break;
			}
		}

		*/
		
		return airportList.get(j).getCityName();
}
}