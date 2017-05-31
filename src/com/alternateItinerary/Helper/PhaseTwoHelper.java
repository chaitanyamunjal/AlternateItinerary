package com.alternateItinerary.Helper;

import java.net.UnknownHostException;

import com.alternateItinerary.API.AdminCustomization;
import com.alternateItinerary.API.AirportAutocomplete;
import com.alternateItinerary.API.AlternateOriginCalculator;
import com.alternateItinerary.API.DestinationImageApi;
import com.alternateItinerary.API.FlightsLowFare;
import com.alternateItinerary.API.UserCustomization;
import com.alternateItinerary.RequestResponse.AdminCustomResponse;
import com.alternateItinerary.RequestResponse.AlternateOriginCalculatorResponse;
import com.alternateItinerary.RequestResponse.FlightsLowFareResponse;
import com.alternateItinerary.RequestResponse.PhaseTwoResponse;
import com.alternateItinerary.RequestResponse.ResponseObject;
import com.alternateItinerary.RequestResponse.UserCustomResponse;

public class PhaseTwoHelper {
	
	public PhaseTwoResponse findPhaseTwoResults(double riskThreshold1,double riskThreshold2,String riskFactorsValue[],String riskFactorsChecked[],String similarityFactorsValue[],String similarityFactorsChecked[],double fromRiskFactor,double toRiskFactor,String from,String fromCoordinates,String date,String date1,String previousDate1,String previousDate2,String fromAirportCode,String toAirportCode,String to,int x) throws UnknownHostException{
		
		/*  ===================     PHASE - 2 ( GIVING SUGGESTION / RECOMMENDATION ) =======================  */
	    
		// 1. Find the Nearest Relevant Airport if RISK At " ORIGIN "
    	String alternateOrigin = from;
    	double alternateOriginRiskFactor = fromRiskFactor;
    	String alternateOriginAirportCode = fromAirportCode;
    	AirportAutocomplete aac = new AirportAutocomplete();
    	if(fromRiskFactor > riskThreshold1){
    		// we pass the coordinates which we got from google maps geocoding api to this class which will return the Nearest Relevant Airport/City
    		AlternateOriginCalculator obj5 = new AlternateOriginCalculator();

    		AlternateOriginCalculatorResponse aocr = obj5.findAlternateOrigin(riskFactorsValue,riskFactorsChecked,fromCoordinates, date,date1,previousDate1,previousDate2,fromRiskFactor,toAirportCode);
    		alternateOrigin = aocr.getAlternateOrigin();
    		alternateOriginRiskFactor = aocr.getAlternateOriginRiskFactor(); 
    		System.out.println("alternate origin found in the main servlet is = "+alternateOrigin);
    		
    		// Get Airport Code of Alternate Origin Found
        	alternateOriginAirportCode = aac.findAirportCode(alternateOrigin);
    	}

    	
    	// 2. Search for Alternate Destination if Risk at Destination and then find the Risk Factor at all the possible Destinations and then Give the Best Result
    	String alternateDestination[] = new String[3];	
    	String url[] = new String[3];
    	double rf[] = new double[3];
    	double similarityIndex[] = new double[3];
    	String urlOrigin = "";
    	String urlDestination = "";
    	// Get the Image URL of origin and destination
    	DestinationImageApi dia = new DestinationImageApi();
    	urlOrigin = dia.findImage(fromAirportCode);
    	urlDestination = dia.findImage(toAirportCode);
		
    	
    	int j = 0,k=0;  // Size
    	
    	if( toRiskFactor > riskThreshold2){  //  > threshold2
    
    		// get the top 3 alternate destinations and find the Risk Factor at these Alternate Destinations and check if there are flights from alternate Origin to these locations and give the Alternate Itinerary Results on the front end
    		SimilarityIndexHelper helper = new SimilarityIndexHelper();
    		
    		ResponseObject ro = helper.findSimilarCity(to,similarityFactorsValue,similarityFactorsChecked);
    		String similarCities[] = ro.getSimilarCities();
    		double index[] = ro.getIndex();
    		
    		System.out.println("similarity index of 1st city"+index[0]+" --- "+index[1]);
    		
    		AlternateDestinationRiskHelper adrh = new AlternateDestinationRiskHelper();
    		double similarCitiesRiskFactor[] = new double[similarCities.length];
    		
    		// Checking the Flights from Alternate Origin to Alternate Destinations 
    		FlightsLowFare flf = new FlightsLowFare();
    		FlightsLowFareResponse flfr;
    		
    		for(int i = 0; i <similarCities.length && j<3; i++){
    			
    			flfr = flf.findFlight(alternateOriginAirportCode,aac.findAirportCode(similarCities[i]), date); 
				if(!flfr.getBudget().equals("Unknown")){   
					similarCitiesRiskFactor[k] = adrh.calculateParams(riskFactorsValue,riskFactorsChecked,similarCities[i], x, date,alternateOriginAirportCode,aac.findAirportCode(similarCities[i]),date1,previousDate1,previousDate2);
					
					if(similarCitiesRiskFactor[k] <= toRiskFactor  && j<3){  // <= threshold2 or toRiskFactor
	    				alternateDestination[j] = similarCities[i];
	    				rf[j] = similarCitiesRiskFactor[k];
	    				similarityIndex[j] = index[i];
	    				j++;
	    			}
					k++;
				}
    		}
    		
    		

            // 3. Destination Image API to get the Images of all the Alternate Destination Cities
        	for(int m=0;m<j && m<3;m++){
    			// Getting the Image URL of the TOP 3 alternate destinations found
    			url[m] = dia.findImage(aac.findAirportCode(alternateDestination[m]));
    		}
    	}
    	
    	
    	// Putting the Results in the Response Object
    	PhaseTwoResponse ptr = new PhaseTwoResponse();
    	ptr.setAlternateOrigin(alternateOrigin);
    	ptr.setAlternateDestination(alternateDestination);
    	ptr.setAlternateDestinationURL(url);
    	ptr.setRiskFactor(rf);
    	ptr.setSimilarityIndex(similarityIndex);
    	ptr.setSize(j);
    	ptr.setAlternateOriginRiskFactor(alternateOriginRiskFactor);
    	ptr.setUrlOrigin(urlOrigin);
    	ptr.setUrlDestination(urlDestination);
    	
    	return ptr;
	}

}

