package com.alternateItinerary.API;

import com.alternateItinerary.RequestResponse.MainServletResponse;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DebugDataFetcher {
	
	
			public MainServletResponse getData() {
			// Consuming the Airport Autocomplete API to get the Airport Code
	
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8081/response.json");
			// fire the request
			ClientResponse apiResponse = webResource.accept("application/json").get(ClientResponse.class);
			String output2 = apiResponse.getEntity(String.class);
			
	        return new Gson().fromJson(output2, MainServletResponse.class);
			}
}
