package com.alternateItinerary.API;
import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONObject;

import com.alternateItinerary.Config;
import com.alternateItinerary.Model.FlightRatingApi.FlightRatingMain;
import com.alternateItinerary.Model.FlightStatusApi.FlightStatusMain;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class FlightRating {

public double findFlightRating(String airline, String flightnumber) {
		
		// Consuming the Flight Status - Rating API to get the Rating of a Flight 
		
		Client client = Client.create();
		WebResource webResource = client.resource("https://api.flightstats.com/flex/ratings/rest/v1/json/flight/"+airline+"/"+flightnumber);
		
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("appId", Config.flightStatsApplicationId);
		queryParams.add("appKey", Config.flightStatsKey);

		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
        JSONObject json = new JSONObject(output2);
        
        FlightRatingMain obj = new Gson().fromJson(output2,FlightRatingMain.class);
        
        double rating;
        // bad request
        if(apiResponse.getStatus() == 400 || obj.getRatings() == null) {
        	rating = 2.5;
        }
        else{  // correct request	
        	rating = obj.getRatings().get(0).getAllStars();
        }
        
        //System.out.println("Rating of the flight is = "+ rating);
    	
		double flightRatingRiskFactor = 0;
        
		if(rating < 2){
			flightRatingRiskFactor = 1;
		}
		else if(rating < 3){
			flightRatingRiskFactor = 0.5;
		}
		else if(rating < 4)
		{
			flightRatingRiskFactor = 0.25;
		}
        return flightRatingRiskFactor;
	}

}
