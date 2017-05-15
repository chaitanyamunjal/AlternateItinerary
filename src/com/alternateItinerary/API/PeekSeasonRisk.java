package com.alternateItinerary.API;

import java.net.UnknownHostException;

import java.util.ArrayList;
import java.util.List;

import com.alternateItinerary.Model.PeekSeasonDb.Datum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class PeekSeasonRisk {


	public double findPeekSeasonRisk(String city,int x) {	
		
		double peekSeasonRiskFactor = 0.25;
		
		DB db = null;
		try {
			db = (new MongoClient("localhost",27017)).getDB("AlternateItinerary");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return peekSeasonRiskFactor;
		} 
		DBCollection dbc = db.getCollection("peekSeason");
		
		DBObject object1 = dbc.findOne();

		List<Datum> data = new ArrayList<Datum>();
		java.lang.reflect.Type listType = new TypeToken<List<Datum>>() {}.getType();
		data = new Gson().fromJson(JSON.serialize(object1.get("data")), listType);
		
		Datum tor = new Datum();
		for(int i=0;i< data.size();i++){
			if(data.get(i).getCity().equals(city)){
				tor = data.get(i);
				break;
			}
		}
		
		int peek_start = tor.getPeekStart();
		int peek_end = tor.getPeekEnd();
	
		System.out.println("start = "+peek_start +" & peek end = "+peek_end +" and x = "+x );
		
		
		if( peek_end >= peek_start )
		{
			if( x >= peek_start && x <= peek_end){
				peekSeasonRiskFactor = 1;
			}
		}
		else{
			if( x >= peek_start || x <= peek_end){
				peekSeasonRiskFactor = 1;
			}
		}
		return peekSeasonRiskFactor;
	}

}
