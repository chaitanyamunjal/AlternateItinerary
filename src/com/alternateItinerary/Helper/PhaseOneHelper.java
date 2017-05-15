package com.alternateItinerary.Helper;

import java.net.UnknownHostException;

import com.alternateItinerary.API.AdminCustomization;
import com.alternateItinerary.API.AirportDelayIndex;
import com.alternateItinerary.API.FlightRating;
import com.alternateItinerary.API.FlightStatus;
import com.alternateItinerary.API.PeekSeasonRisk;
import com.alternateItinerary.API.TouristInflowDb;
import com.alternateItinerary.API.TravelWarningIndex;
import com.alternateItinerary.API.UserCustomization;
import com.alternateItinerary.RequestResponse.AdminCustomResponse;
import com.alternateItinerary.RequestResponse.PhaseOneResponse;
import com.alternateItinerary.RequestResponse.UserCustomResponse;

public class PhaseOneHelper {

	public PhaseOneResponse findPhaseOneResults(String riskFactorsValue[],String riskFactorsChecked[],String fromCountryName,String fromCountryCode,String toCountryCode,String fromWeatherParameters,String toWeatherParameters,String fromAirportCode,String toAirportCode,String airline,String flightnumber,String date1,String previousDate1,String previousDate2,String from,String to,int x) {

		
		/*  ===================     PHASE - 1  ( Finding Risk ) =======================  */
		
		// Put all the risk factors calculated in these 2 arrays
		double[] originRiskFactors = new double[8];
		double[] destinationRiskFactors = new double[8];
		
		// 1. Calculate the Weather Risk Factor for Weather Risk Parameters
	    
		double fromWeatherRiskFactor = 0; 
		double toWeatherRiskFactor = 0;
		if(riskFactorsChecked[0].equals("1")){
	    RiskFactorCalculator rfc = new RiskFactorCalculator();
	    fromWeatherRiskFactor = rfc.calclulateRiskFactor(fromWeatherParameters);
    	toWeatherRiskFactor = rfc.calclulateRiskFactor(toWeatherParameters);

    	System.out.println("FROM Weather risk factor value = "+fromWeatherRiskFactor);
    	System.out.println("TO Weather risk factor value = "+toWeatherRiskFactor);
		}
		originRiskFactors[0] = fromWeatherRiskFactor;
		destinationRiskFactors[0] = toWeatherRiskFactor;
		
		// 2. Calculate the Airport Delay Index for Origin and Destination
		
		double fromDelayIndexRiskFactor = 0;
		double toDelayIndexRiskFactor = 0; 
		if(riskFactorsChecked[1].equals("1")){
		AirportDelayIndex obj2 = new AirportDelayIndex();
    	fromDelayIndexRiskFactor = obj2.findDelayIndex(fromAirportCode);
    	toDelayIndexRiskFactor = obj2.findDelayIndex(toAirportCode);
//    	System.out.println("FROM Airport delay index value = "+fromDelayIndexRiskFactor);
//    	System.out.println("TO Airport delay index value = "+toDelayIndexRiskFactor);
		}
		originRiskFactors[1] = fromDelayIndexRiskFactor;
		destinationRiskFactors[1] = toDelayIndexRiskFactor;
		
   		// 3. Calculate the Flight Risk Factor for the Flight ( on the basis of flight status )
		
		double flightStatusRiskFactor = 0;
		FlightStatus obj3 = new FlightStatus();
		if(riskFactorsChecked[2].equals("1")){
			flightStatusRiskFactor = obj3.findFlightStatus(airline, flightnumber, date1,fromAirportCode);
			//  System.out.println(" Flight Status Risk Factor =  "+flightStatusRiskFactor);
		}
		originRiskFactors[2] = flightStatusRiskFactor;
		destinationRiskFactors[2] = flightStatusRiskFactor;
		
		// 4. Calculate Risk Factor due to Cancellation of Flights ( Historical Data ) - flight history status API
		
		double flightStatusRiskFactor1 = 0;
		double flightStatusRiskFactor2 = 0;
		if(riskFactorsChecked[3].equals("1")){
		flightStatusRiskFactor1 = obj3.findFlightStatus(airline, flightnumber, previousDate1, fromAirportCode);
		flightStatusRiskFactor2 = obj3.findFlightStatus(airline, flightnumber, previousDate2, fromAirportCode);
		//  System.out.println(flightStatusRiskFactor1 + " ------ "+flightStatusRiskFactor2);
		}			
		originRiskFactors[3] = (flightStatusRiskFactor1 + flightStatusRiskFactor2)/2;
//		originRiskFactors[4] = flightStatusRiskFactor2;
		destinationRiskFactors[3] = (flightStatusRiskFactor1 + flightStatusRiskFactor2)/2;
//		destinationRiskFactors[4] = flightStatusRiskFactor2;
					
		// 5. Calculate Risk Factor Due to Peek Season / Off Season
   		
		double peekSeasonRiskFactor = 0; 
		if(riskFactorsChecked[4].equals("1")){
		PeekSeasonRisk obj7 = new PeekSeasonRisk();
   		peekSeasonRiskFactor = obj7.findPeekSeasonRisk(to, x+1);
//   		System.out.println("Peek season Risk = "+peekSeasonRiskFactor);
		}
		destinationRiskFactors[4] = peekSeasonRiskFactor;
		
		// 6. Calculate Risk Factor due to Tourist In-flow
   		
		double touristInflowRiskFactor = 0; 
		if(riskFactorsChecked[5].equals("1")){
		TouristInflowDb obj6 = new TouristInflowDb();
   		touristInflowRiskFactor = obj6.findTouristInflow(fromCountryName, x);
//   		System.out.println("Tourist Inflow Risk = "+touristInflowRiskFactor);
		}
		destinationRiskFactors[5] = touristInflowRiskFactor;
		
		
		
		// 7. Calculate the Risk Factor due to Flight Rating
    	
		double flightRatingRiskFactor = 0;
		if(riskFactorsChecked[6].equals("1")){
			FlightRating obj8 = new FlightRating();
	    	flightRatingRiskFactor = obj8.findFlightRating(airline, flightnumber);
	    	//   System.out.println("flight rating risk factor = "+flightRatingRiskFactor);
		}
		originRiskFactors[6] = flightRatingRiskFactor;
		destinationRiskFactors[6] = flightRatingRiskFactor;
		
		// 8. Travel Warning Index of Origin and Destination
    	
		double fromTravelWarningIndexRiskFactor = 0;
		double toTravelWarningIndexRiskFactor = 0; 
		if(riskFactorsChecked[7].equals("1")){
			TravelWarningIndex obj9 = new TravelWarningIndex();
	    	fromTravelWarningIndexRiskFactor = obj9.findTravelWarningIndex(fromCountryCode);
	    	toTravelWarningIndexRiskFactor = obj9.findTravelWarningIndex(toCountryCode);
	//    	System.out.println("Travel warning index of origin and destination are = "+fromTravelWarningIndexRiskFactor+" and "+toTravelWarningIndexRiskFactor);
		}
		originRiskFactors[7] = fromTravelWarningIndexRiskFactor;
		destinationRiskFactors[7] = toTravelWarningIndexRiskFactor;
		
		
    	// 9. Final Risk Factor Calculation using the above Individual Risk Factors
		
    	FinalRiskFactorCalculator obj10 = new FinalRiskFactorCalculator();
    	double fromRiskFactor = obj10.calclulateOriginRiskFactor(riskFactorsChecked,riskFactorsValue,originRiskFactors);
    	double toRiskFactor = obj10.calclulateDestinationRiskFactor(riskFactorsChecked,riskFactorsValue,destinationRiskFactors);
    	
    	System.out.println("FINAL risk factors for ORIGIN = "+fromRiskFactor + " and DESTINATION = " + toRiskFactor);
    	
    	// Putting the Results in the Response Object
    	PhaseOneResponse por = new PhaseOneResponse();
    	por.setFromRiskFactor(fromRiskFactor);
    	por.setToRiskFactor(toRiskFactor);
    	
    	return por;
	}
}
