package com.alternateItinerary.API;
import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONObject;
import com.alternateItinerary.Config;
import com.alternateItinerary.Model.GeoCodingApi.Coordinates;
import com.alternateItinerary.Model.ReverseGeocodingApi.ReverseGeocodingMain;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class ReverseGeocodingApi {

	public String[] findCountryCode(String coordinates) {
		
		// we have taken the coordinates as argument of this function
		// now we will find the latitude and longitude values from this coordinates JSON response which we got from 
		// the LcationCoordinates Class ( GoogleMaps Geocoding API)
		JSONObject json = new JSONObject(coordinates);
		Coordinates obj = new Gson().fromJson(coordinates,Coordinates.class);
		Double latitude = obj.getResults().get(0).getGeometry().getLocation().getLat();
		Double longitude = obj.getResults().get(0).getGeometry().getLocation().getLng();
				
		
		// Consuming the google maps Reverse Geocoding API to get the Country Code from Coordinates  
		Client client = Client.create();
		WebResource webResource = client.resource("https://maps.googleapis.com/maps/api/geocode/json");
		
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("latlng", latitude+","+longitude);
		queryParams.add("key", Config.googleKey);
		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
        JSONObject json1 = new JSONObject(output2);
        ReverseGeocodingMain obj1 = new Gson().fromJson(output2,ReverseGeocodingMain.class);
        
        int size = obj1.getResults().get(0).getAddressComponents().size();
        String countrycode = "IN";
        String countryname = "India";
        for(int i=0;i<size;i++){
        	if(obj1.getResults().get(0).getAddressComponents().get(i).getTypes().get(0).equals("country")){
        		countrycode = obj1.getResults().get(0).getAddressComponents().get(i).getShortName();
        		countryname = obj1.getResults().get(0).getAddressComponents().get(i).getLongName();
        	}
        }
        String country[] ={countrycode,countryname};
        return country;
	}
}