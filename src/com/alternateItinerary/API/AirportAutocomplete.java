package com.alternateItinerary.API;

import java.util.List;
import javax.ws.rs.core.MultivaluedMap;
import com.alternateItinerary.Config;
import com.alternateItinerary.Model.AirportAutocomplete.AirportCode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class AirportAutocomplete {


public String findAirportCode(String airport) {
		
		// Consuming the Airport Autocomplete API to get the Airport Code
		
		Client client = Client.create();
		WebResource webResource = client.resource("https://api.sandbox.amadeus.com/v1.2/airports/autocomplete");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("apikey", Config.sandboxKey);
		queryParams.add("term", airport);
		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
	
		TypeToken<List<AirportCode>> token = new TypeToken<List<AirportCode>>(){};
        List<AirportCode> airportList = new Gson().fromJson(output2, token.getType());
    	String airportCode = airportList.get(0).getValue();
        
//        System.out.println("airport code of"+ airport +" is "+airportCode);
        return airportCode;
	}

}
