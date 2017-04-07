package com.alternateItinerary.API;
import javax.ws.rs.core.MultivaluedMap;
import org.json.JSONObject;
import com.alternateItinerary.Config;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class GoogleDistanceMatrix {

	public String findDistance(String origin,String destination) {
		
		// Consuming the google maps Distance Matrix API to get the distance between the location's 
		
		Client client = Client.create();
		WebResource webResource = client.resource("https://maps.googleapis.com/maps/api/distancematrix/json");
		
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("origins", origin);
		queryParams.add("destinations", destination);
		queryParams.add("key", Config.googleKey);
		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
        JSONObject json = new JSONObject(output2);
        
        return output2;
	}
}