package com.alternateItinerary.Helper;

import java.net.UnknownHostException;

import com.alternateItinerary.API.AirportAutocomplete;
import com.alternateItinerary.API.AirportDelayIndex;
import com.alternateItinerary.API.FlightRating;
import com.alternateItinerary.API.FlightStatus;
import com.alternateItinerary.API.FlightsLowFare;
import com.alternateItinerary.API.LocationCoordinates;
import com.alternateItinerary.API.PeekSeasonRisk;
import com.alternateItinerary.API.ReverseGeocodingApi;
import com.alternateItinerary.API.TouristInflowDb;
import com.alternateItinerary.API.TravelWarningIndex;
import com.alternateItinerary.API.WeatherForecastApi;
import com.alternateItinerary.RequestResponse.FlightsLowFareResponse;

public class AlternateDestinationRiskHelper {

	public double calculateParams(String riskFactorsValue[],String riskFactorsChecked[],String city,int x,String date,String originAirportCode,String destinationAirportCode,String date1,String previousDate1,String previousDate2) throws UnknownHostException{
		
		// Array that will contain all the Risk Factors of the destination
		double[] destinationRiskFactors= new double[8];
		
		// flight details 
		FlightsLowFare flf = new FlightsLowFare();
		FlightsLowFareResponse flfr = flf.findFlight(originAirportCode, destinationAirportCode, date);
		String airline = flfr.getAirline();
		String flightNumber = flfr.getFlight_number();
		
		// Flight Rating Risk Factor
		double flightRatingRiskFactor = 0; 
		if(riskFactorsChecked[6].equals("1")){
		   	FlightRating fr = new FlightRating();
			flightRatingRiskFactor = fr.findFlightRating(airline, flightNumber);
			
	    }
		destinationRiskFactors[6] = flightRatingRiskFactor;
		
		// Flight Status Risk Factor for -> 1. date1 , 2. previousDate1, 3. previousDate2 
		FlightStatus fs = new FlightStatus();
		double flightRiskFactor =0;
		if(riskFactorsChecked[2].equals("1")){
			flightRiskFactor = fs.findFlightStatus(airline, flightNumber, date1, originAirportCode);
		 }
		destinationRiskFactors[2] = flightRiskFactor;
		double flightStatusRiskFactor1=0; 
		double flightStatusRiskFactor2=0;
		if(riskFactorsChecked[3].equals("1")){
		   	flightStatusRiskFactor1 = fs.findFlightStatus(airline, flightNumber, previousDate1, originAirportCode);
			flightStatusRiskFactor2 = fs.findFlightStatus(airline, flightNumber, previousDate2, originAirportCode);
		}		
		destinationRiskFactors[3] = (flightStatusRiskFactor1 + flightStatusRiskFactor2)/2;
	    
		 // toDelayIndexRiskFactor
		double toDelayIndexRiskFactor= 0;
		if(riskFactorsChecked[1].equals("1")){
		   	AirportAutocomplete object = new AirportAutocomplete();
			String toAirportCode = object.findAirportCode(city);
			AirportDelayIndex obj2 = new AirportDelayIndex();
	    	toDelayIndexRiskFactor = obj2.findDelayIndex(toAirportCode);
	    }
		destinationRiskFactors[1] = toDelayIndexRiskFactor;
	    
    	// peekSeasonRiskFactor
		double peekSeasonRiskFactor=0 ;
    	if(riskFactorsChecked[4].equals("1")){
	       	PeekSeasonRisk psr = new PeekSeasonRisk();
	   		peekSeasonRiskFactor = psr.findPeekSeasonRisk(city, x+1);
	   	}
    	destinationRiskFactors[4] = peekSeasonRiskFactor;
	    
   		// toTravelWarningIndexRiskFactor
   		LocationCoordinates obj = new LocationCoordinates();
   		String toCoordinates = obj.findCoordinates(city);
   		ReverseGeocodingApi rga = new ReverseGeocodingApi();
   		String toCountry[] = rga.findCountryCode(toCoordinates);
   	    String toCountryCode = toCountry[0];
   	    String toCountryName = toCountry[1];
   	    double toTravelWarningIndexRiskFactor=0; 
   	    if(riskFactorsChecked[7].equals("1")){
	    	TravelWarningIndex obj9 = new TravelWarningIndex();
	    	toTravelWarningIndexRiskFactor = obj9.findTravelWarningIndex(toCountryCode);
	    }
   		destinationRiskFactors[7] = toTravelWarningIndexRiskFactor;
   	    
   		// touristInflowRiskFactor
   		double touristInflowRiskFactor=0; 
    	if(riskFactorsChecked[5].equals("1")){
	    	TouristInflowDb obj6 = new TouristInflowDb();
	   		touristInflowRiskFactor = obj6.findTouristInflow(toCountryName, x);
	   	}
    	destinationRiskFactors[5] = touristInflowRiskFactor;
    	
   		// WeatherRiskFactor
    	double toWeatherRiskFactor=0; 
   		if(riskFactorsChecked[0].equals("1")){
	   		WeatherForecastApi obj1 = new WeatherForecastApi();
	   		String toWeatherParameters = obj1.findParameters(toCoordinates, date);
	   		RiskFactorCalculator rfc = new RiskFactorCalculator();
		    toWeatherRiskFactor = rfc.calclulateRiskFactor(toWeatherParameters);
		}
   	    destinationRiskFactors[0] = toWeatherRiskFactor;
		
	    // CALCULATE Final Risk Factor of these Alternate Destinations
   		FinalRiskFactorCalculator frfc = new FinalRiskFactorCalculator();
   		double alternateDestinationRiskFactor = frfc.calclulateDestinationRiskFactor(riskFactorsChecked,riskFactorsValue,destinationRiskFactors);
		System.out.println(" Alternate Destination Risk Calculator  = "+city+" risk = "+alternateDestinationRiskFactor );
   		return alternateDestinationRiskFactor;
	}
 // toWeatherRiskFactor, toDelayIndexRiskFactor, flightRiskFactor,flightStatusRiskFactor1,flightStatusRiskFactor2,touristInflowRiskFactor, peekSeasonRiskFactor,flightRatingRiskFactor, toTravelWarningIndexRiskFactor
	
}
