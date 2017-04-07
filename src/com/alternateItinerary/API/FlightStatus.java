package com.alternateItinerary.API;

import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONObject;

import com.alternateItinerary.Config;
import com.alternateItinerary.Model.DelayIndexApi.DelayIndexMain;
import com.alternateItinerary.Model.FlightStatusApi.FlightStatusMain;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class FlightStatus {

public double findFlightStatus(String airline, String flightnumber, String date,String airport) {
		
		// Consuming the Flight Status API to get the Status of a Flight 
		
		Client client = Client.create();
		WebResource webResource = client.resource("https://api.flightstats.com/flex/flightstatus/rest/v2/json/flight/status/"+airline+"/"+flightnumber+"/dep/"+date);
		
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("appId", Config.flightStatsApplicationId);
		queryParams.add("appKey", Config.flightStatsKey);
		queryParams.add("utc", "false");
		queryParams.add("airport", airport);
		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
        JSONObject json = new JSONObject(output2);
        
        FlightStatusMain obj = new Gson().fromJson(output2,FlightStatusMain.class);

        String status ="";
        if(obj.getFlightStatuses().get(0).getStatus() != null){
			status = obj.getFlightStatuses().get(0).getStatus();	
		}
		System.out.println("Status of the flight is = "+ status);
    	
        double flightRiskFactor = 0;
        
        if(status.equals("C") || status.equals("NO") || status.equals("D") || status.equals("R")){
        	flightRiskFactor = 1;
        }
        else if(status.equals("U")){
        	flightRiskFactor = 0.25;
        }
        else if(status.equals("S") || status.equals("L")){
        	flightRiskFactor = 0;
        }
        
        return flightRiskFactor;
	}

}
