package com.alternateItinerary.API;
import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONObject;

import com.alternateItinerary.Model.Distance24Api.DistanceMain;
import com.alternateItinerary.Model.FlightStatusApi.FlightStatusMain;
import com.alternateItinerary.Model.TravelWarningApi.TravelWarningMain;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class TravelWarningIndex {

public double findTravelWarningIndex(String countrycode) {
		
		Client client = Client.create();
		WebResource webResource = client.resource("https://www.reisewarnung.net/api");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("country", countrycode);

		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
		// System.out.println(output2);
        JSONObject json = new JSONObject(output2);
        
        TravelWarningMain obj = new Gson().fromJson(output2,TravelWarningMain.class);
        
        String travelWarning = obj.getData().getSituation().getRating();
        
        double travelwarningindex = Double.parseDouble(travelWarning);
        
        double travelwarningindexRiskFactor = 0;
        
        if(travelwarningindex >=3.5){
        	travelwarningindexRiskFactor = 1;
        }
        else if(travelwarningindex >= 2.5 ){
        	travelwarningindexRiskFactor = 0.5;
        }
        else if( travelwarningindex >= 2){
        	travelwarningindexRiskFactor = 0.25;
        }
        
        return travelwarningindexRiskFactor;
	}

}
