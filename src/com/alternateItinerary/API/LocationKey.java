package com.alternateItinerary.API;

import java.util.List;


import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONArray;
import org.json.JSONObject;

//import com.alternateItinerary.Config;
import com.alternateItinerary.Model.LocationKey.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class LocationKey {

	public String findLocationKey(String to) {
		
		Client client = Client.create();
		System.out.println("city got in api is " + to);
		WebResource webResource = client.resource("http://dataservice.accuweather.com/locations/v1/search");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();

		// add the API key and the city to the query params
		queryParams.add("apikey", com.alternateItinerary.Config.weatherKey);
		queryParams.add("q", to);
		
		// fire the request
     	ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
     		
     	String output2 = apiResponse.getEntity(String.class);
     
     	
        TypeToken<List<keyConvert>> token = new TypeToken<List<keyConvert>>(){};
        List<keyConvert> personList = new Gson().fromJson(output2, token.getType());
             
        
        System.out.println(personList.get(0).getKey());
        
        String key = personList.get(0).getKey();

        return key;
}
	
}
