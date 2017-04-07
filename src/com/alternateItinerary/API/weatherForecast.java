package com.alternateItinerary.API;
import java.util.List;


import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.alternateItinerary.Model.AccuWeatherApi.*;
import com.alternateItinerary.Config;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class weatherForecast {

	public String findParameters(String locationKey) {
		
		
		// ACCU WEATHER API 
		
		Client client = Client.create();
		System.out.println("location key got in api is " + locationKey);
		
		WebResource webResource = client.resource("http://dataservice.accuweather.com/forecasts/v1/daily/5day/"+locationKey);
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();

		// add the API key and the city to the query params
		queryParams.add("apikey", Config.weatherKey);
		queryParams.add("details", "true");
		
		// fire the request
     	ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
     	String output2 = apiResponse.getEntity(String.class);
     	return output2;
}
	
}
