package com.alternateItinerary.API;
import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONObject;

import com.alternateItinerary.Model.Distance24Api.DistanceMain;
import com.alternateItinerary.Model.FlightStatusApi.FlightStatusMain;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class DistanceApi {

public int findDistance(String origin, String destination) {
		
		// Consuming the Distance 24 API to get the distance between 2 cities 
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://www.distance24.org/route.json");
		
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("stops",origin+"|"+destination );

		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
        JSONObject json = new JSONObject(output2);
        DistanceMain obj = new Gson().fromJson(output2,DistanceMain.class);
        int distance = obj.getDistance();
        
        return distance;
	}

}
