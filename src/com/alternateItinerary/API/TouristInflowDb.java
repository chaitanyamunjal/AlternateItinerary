package com.alternateItinerary.API;

import java.net.UnknownHostException;

import java.util.ArrayList;
import java.util.List;

import com.alternateItinerary.Model.TouristInflowDb.Tourist;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class TouristInflowDb {


	public double findTouristInflow(String fromCountryName,int x) {	

		// connection
		DB db = null;
		try {
			db = (new MongoClient("localhost",27017)).getDB("AlternateItinerary");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.5;
		} 
		
		// get collection
		DBCollection dbc = db.getCollection("touristInflow");
		
		// make the query
		BasicDBObject query = new BasicDBObject();
		query.put("country",fromCountryName);
		
		// execute
		DBObject object1 = dbc.findOne(query);
		
		// make the list type
		List<Tourist> tourists = new ArrayList<Tourist>();
		java.lang.reflect.Type listType = new TypeToken<List<Tourist>>() {}.getType();
		
		// get the data from db object and put into java object
		tourists = new Gson().fromJson(JSON.serialize(object1.get("tourists")), listType);
		
		int touristInflow = tourists.get(0).getMonthwise().get(x).getCount();
	
		double touristInflowRiskFactor = 0;
		
		if(touristInflow > 4500000 ){
			touristInflowRiskFactor = 1;
		}
		else if(touristInflow > 3500000){
			touristInflowRiskFactor = 0.75;	
		}
		else if(touristInflow > 2000000){
			touristInflowRiskFactor = 0.5;	
		}
		else if(touristInflow > 1000000){
			touristInflowRiskFactor = 0.25;	
		}
			
		return touristInflowRiskFactor;
	}
}
