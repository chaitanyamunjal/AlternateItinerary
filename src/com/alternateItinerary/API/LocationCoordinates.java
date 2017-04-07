package com.alternateItinerary.API;

import javax.ws.rs.core.MultivaluedMap;


import org.json.JSONObject;

import com.alternateItinerary.Config;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class LocationCoordinates {

	public String findCoordinates(String location) {
		
		// Consuming the google maps geocoding API to get the coordinates of the location 
		
		Client client = Client.create();
		WebResource webResource = client.resource("https://maps.googleapis.com/maps/api/geocode/json");
		
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("address", location);
		queryParams.add("key", Config.googleKey);
		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
        JSONObject json = new JSONObject(output2);
        
        return output2;
	}
}