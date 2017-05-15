package com.alternateItinerary.API;

import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONObject;

import com.alternateItinerary.Config;
import com.alternateItinerary.Model.FlightsLowFareApi.FlightsLowFareMain;
import com.alternateItinerary.RequestResponse.FlightsLowFareResponse;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class FlightsLowFare {


public FlightsLowFareResponse findFlight(String origin,String destination,String date) {
		
		// Consuming the Sandbox Flights Low Fare Search API 
	
		Client client = Client.create();
		WebResource webResource = client.resource("https://api.sandbox.amadeus.com/v1.2/flights/low-fare-search");
		System.out.println("origin ="+origin+" destination ="+destination+" date ="+date);
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("apikey", Config.sandboxKey);
		queryParams.add("origin", origin);
		queryParams.add("destination", destination);
		queryParams.add("departure_date", date);
		queryParams.add("currency", "INR");
		queryParams.add("number_of_results", "1");
		
		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		
		FlightsLowFareResponse flfr = new FlightsLowFareResponse();
	    
		// bad request
		if(apiResponse.getStatus() == 400) {
			flfr.setAirline("Unknown");
			flfr.setBudget("Unknown");
			flfr.setFlight_number("Unknown");
			return flfr;
		}
		
		String output2 = apiResponse.getEntity(String.class);
		JSONObject json = new JSONObject(output2);
        FlightsLowFareMain obj = new Gson().fromJson(output2,FlightsLowFareMain.class);
        
        String budget = "";
        String airline = "";
        String flight_number = "";
        
        if(obj.getResults().size() > 0 ){
        budget = obj.getResults().get(0).getFare().getTotalPrice();
		airline = obj.getResults().get(0).getItineraries().get(0).getOutbound().getFlights().get(0).getOperatingAirline();
		flight_number = obj.getResults().get(0).getItineraries().get(0).getOutbound().getFlights().get(0).getFlightNumber();
	    // System.out.println(" BUDGET = "+ budget + " AIRLINE = "+airline +" Flight Number = " + flight_number);
        }
        
        flfr.setBudget(budget);
        flfr.setAirline(airline);
        flfr.setFlight_number(flight_number);
        
	    return flfr;
	}

}
