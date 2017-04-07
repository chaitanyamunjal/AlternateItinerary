package com.alternateItinerary.API;

import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONObject;

import com.alternateItinerary.Config;
import com.alternateItinerary.Model.GeoCodingApi.*;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class WeatherForecastApi {

	public String findParameters(String coordinates,String date) {
		
		// we have taken the coordinates as argument of this function
		// now we will find the latitude and longitude values from this coordinates JSON response which we got from 
		// the LcationCoordinates Class ( GoogleMaps Geocoding API)
				
		JSONObject json = new JSONObject(coordinates);
		Coordinates obj = new Gson().fromJson(coordinates,Coordinates.class);
		Double latitude = obj.getResults().get(0).getGeometry().getLocation().getLat();
		Double longitude = obj.getResults().get(0).getGeometry().getLocation().getLng();
				
		// Now consume the Time Machine Weather api using the above lat and long values :-
		Client client = Client.create();
		WebResource webResource = client.resource("https://api.darksky.net/forecast/"+Config.weatherKey1+"/"+latitude+","+longitude+","+date+"T09:09:09");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("exclude", "daily,flags,hourly,minutely");
		
		// fire the request
     	ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
     	String output2 = apiResponse.getEntity(String.class);
     	
     	return output2;
}
	
}
