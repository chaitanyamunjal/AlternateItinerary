package com.alternateItinerary.Helper;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.alternateItinerary.Model.SimilarityIndexDb.SimilarityIndexMain;
import com.alternateItinerary.Model.TouristInflowDb.Tourist;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class SimilarityIndexCalculator {

	public double calclulateSimilarityIndex(String city1,String city2) throws UnknownHostException{
	
		// connection
		DB db = (new MongoClient("localhost",27017)).getDB("AlternateItinerary"); 
		// get collection
		DBCollection dbc = db.getCollection("myCollection");
				
		// make the query 1
		BasicDBObject query1 = new BasicDBObject();
		query1.put("City",city1);

		// make the query 2
		BasicDBObject query2 = new BasicDBObject();
		query2.put("City",city2);
						
		// execute
		DBObject object1 = dbc.findOne(query1);
		DBObject object2 = dbc.findOne(query2);
				
		// get the data from db object and put into java object
		SimilarityIndexMain cityA = new Gson().fromJson(JSON.serialize(object1), SimilarityIndexMain.class);
		SimilarityIndexMain cityB = new Gson().fromJson(JSON.serialize(object2), SimilarityIndexMain.class);
		
		System.out.println(cityA.getAirport());
		
		double index = 0;
		
		if(cityA.getTouristAttractionIndexFTALAE().equals(cityB.getTouristAttractionIndexFTALAE()))
		{
			index++;
		}
				
		if(Math.abs(cityA.getFlightDurationHrs() - cityB.getFlightDurationHrs()) < 1.5)		
		{
			index++;
		}
		
		if(cityA.getVISA().equals(cityB.getVISA())){
			index++;
		}
		
		if(Math.abs(cityA.getPollutionLevel0To300Scale() - cityB.getPollutionLevel0To300Scale()) < 35 )
		{
			index++;
		}
			
		if(Math.abs(cityA.getFlightPriceINR() - cityB.getFlightPriceINR()) < 3000)
		{
			index++;
		}
		
		if(Math.abs(cityA.getTravelDistanceKm() - cityB.getTravelDistanceKm()) < 800 )
		{
			index++;
		}
		
		System.out.println(cityA.getTravelWarningIndex0To5Scale());
//		int twiA = cityA.getTravelWarningIndex0To5Scale();
//		int twiB = cityB.getTravelWarningIndex0To5Scale();
		
		int twiA = 2;
		int twiB = 2;
		
		if(( twiA <= 2.5 &&  twiB <= 2.5) || ( twiA > 2.5 && twiA <= 3.5 && twiB > 2.5 && twiB <= 3.5 ) || ( twiA > 3.5 && twiA <= 4.5 && twiB > 3.5 && twiB <= 4.5 ) || ( twiA > 4.5 && twiA <= 5 && twiB > 4.5 && twiB <= 5 ))
		{
			index++;
		}
		
		if( cityA.getTransportationIndex().equals(cityB.getTransportationIndex()))
		{
			index++;
		}
		
		if(cityA.getConnectivityIndex().equals(cityB.getConnectivityIndex()))
		{
			index++;
		}
		
		if(cityA.getPeakSeasons().equals(cityB.getPeakSeasons()))
		{
			index++;
		}
		
		int cityCategoryA[] ={cityA.getCulturalOf(),cityA.getSightseeingOf(),cityA.getNightlifeOf(),cityA.getSportsOf(),cityA.getBeachesOf(),cityA.getActivityOf()};
		int cityCategoryB[] = {cityB.getCulturalOf(),cityB.getSightseeingOf(),cityB.getNightlifeOf(),cityB.getSportsOf(),cityB.getBeachesOf(),cityB.getActivityOf()};
		int count = 6;
		
		for(int i=0;i<2;i++){
		if((cityCategoryA[i] > 4 && cityCategoryB[i] < 4) ||(cityCategoryA[i] < 4 && cityCategoryB[i] > 4) ){
				count--;
			}
		}
		
		for(int j=2;j<5;j++){
			if((cityCategoryA[j] >= 1 && cityCategoryB[j] < 1) ||(cityCategoryA[j] < 1 && cityCategoryB[j] >= 1) ){
				count--;
			}
		}
	
		if((cityCategoryA[5] > 3 && cityCategoryB[5] < 3) ||(cityCategoryA[5] < 3 && cityCategoryB[5] > 3) ){
			count--;
		}
		
		System.out.println("COUNT = "+count);
		if(count>=4){
			index++;
		}
		
		String similarityIndex = "";
		
		if(index >= 8 ){
			similarityIndex = "high";
		}
		else if(index >= 6 ){
			similarityIndex = "medium";
		}
		else{
			similarityIndex = "low";
		}
		System.out.println("INDEX = "+index);
		System.out.println("Similarity - Index of "+city1+" and "+city2+" = " +similarityIndex);
		return index;
	}
}
