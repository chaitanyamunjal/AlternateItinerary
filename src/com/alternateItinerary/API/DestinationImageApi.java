
package com.alternateItinerary.API;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONObject;

import com.alternateItinerary.Config;
import com.alternateItinerary.Model.AirportAutocomplete.AirportCode;
import com.alternateItinerary.Model.DestinationImageApi.DestinationImageMain;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class DestinationImageApi {


public String findImage(String city) {
		
		// Consuming the Sandbox Destination Image API 
	
		Client client = Client.create();
		WebResource webResource = client.resource("https://api.sandbox.amadeus.com/v1.2/images/search-city");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("apikey", Config.sandboxKey);
		queryParams.add("location", city);
		

		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
		TypeToken<List<DestinationImageMain>> token = new TypeToken<List<DestinationImageMain>>(){};
        List<DestinationImageMain> imageList = new Gson().fromJson(output2, token.getType());
    	
		// DestinationImageMain obj = new Gson().fromJson(output2,DestinationImageMain.class);
        String url = imageList.get(0).getUrl();
		System.out.println(" Image URL = " + url);
        
	    return url;
	}

}
