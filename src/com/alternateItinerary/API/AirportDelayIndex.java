package com.alternateItinerary.API;

import javax.ws.rs.core.MultivaluedMap;


import org.json.JSONObject;

import com.alternateItinerary.Config;
import com.alternateItinerary.Model.DelayIndexApi.DelayIndexMain;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class AirportDelayIndex {

public double findDelayIndex(String airport) {
		
		// Consuming the Flight Stats Delay Index API to get the Delay Index of an Airport 
		
		Client client = Client.create();
		WebResource webResource = client.resource("https://api.flightstats.com/flex/delayindex/rest/v1/json/airports/"+airport);
		
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("appId", Config.flightStatsApplicationId);
		queryParams.add("appKey", Config.flightStatsKey);
		queryParams.add("classification", "5");
		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
        JSONObject json = new JSONObject(output2);
        DelayIndexMain obj = new Gson().fromJson(output2,DelayIndexMain.class);
		
        double delayIndexRiskFactor = 0.3;
        
        if (obj.getDelayIndexes().size() > 0){
        	double delayIndex =  obj.getDelayIndexes().get(0).getNormalizedScore();
        	
            if(delayIndex >=3){
            	delayIndexRiskFactor = 1;
            }
            else if(delayIndex >=2){
            	delayIndexRiskFactor = 0.5;
            }
            else{
            	delayIndexRiskFactor = 0.25;
            }
            
        }
        
//        System.out.println("Delay Index Risk Factor of "+airport+" is = "+delayIndexRiskFactor);
        return delayIndexRiskFactor;
	}
	
}
