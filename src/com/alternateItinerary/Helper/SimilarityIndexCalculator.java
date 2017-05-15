package com.alternateItinerary.Helper;

import java.net.UnknownHostException;

import com.alternateItinerary.Model.SimilarityIndexDb.SimilarityIndexMain;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class SimilarityIndexCalculator {

//	public double calclulateSimilarityIndex1(String city1,String city2) throws UnknownHostException{
//	
//		// get the data from db object and put into java object
//		SimilarityIndexMain[] city = dbConnection(city1,city2);
//		SimilarityIndexMain cityA = city[0];
//		SimilarityIndexMain cityB = city[1];
//		
//		double index = 0;
//		
//		for(int i=0;i<11;i++){
//			if(checkFactor(i,cityA,cityB)){
//				index++;
//			}
//		}
//		
//		double finalIndex = (index/11)*10;
//		// Round off the SIMILARITY iNDEX to 2 Decimal Places 
//		finalIndex = (double) Math.round(finalIndex * 100) / 100;
//		return finalIndex;
//	}
	
	public double calclulateSimilarityIndex2(String city1,String city2,String factorValue[],String checkedFactors[]) throws UnknownHostException{
		
		// get the data from db object and put into java object
		SimilarityIndexMain[] city = dbConnection(city1,city2);
		SimilarityIndexMain cityA = city[0];
		SimilarityIndexMain cityB = city[1];
				
		double index = 0;
		double count = 0;
		
//		System.out.println(city1+" $ "+city2+" $ "+factorValue[2]+" $ "+checkedFactors[2]);
		
		for(int i=0;i<11;i++){
			
			if(checkedFactors[i].equals("1")){ // Checked the Factor
				
				if(checkFactor(i,cityA,cityB)){ // Factor checked and Matched
					
					if(factorValue[i].equals("High")){
						index = index + 3;
						count = count + 3;
					}
					else if(factorValue[i].equals("Medium")){
						index = index + 2;
						count = count + 2;
					}
					else{
						index = index + 1;
						count = count + 1;
					}
				}
				else{ // Factor Checked and Did NOT - Match
					if(factorValue[i].equals("High")){
						count = count + 3;
					}
					else if(factorValue[i].equals("Medium")){
						count = count + 2;
					}
					else{
						count = count + 1;
					}
				}
			}
		}
		double finalIndex = (index/count)*10; 
		// Round off the SIMILARITY iNDEX to 2 Decimal Places 
		finalIndex = (double) Math.round(finalIndex * 100) / 100;
		return finalIndex;	
	}	
	
	public boolean checkFactor(int i,SimilarityIndexMain cityA,SimilarityIndexMain cityB){
		
		if(i == 0){
			if(cityA.getTouristAttractionIndex().equals(cityB.getTouristAttractionIndex()))
			{
				return true;
			}

			return false;
		}
		else if(i==1){
			if(Math.abs(cityA.getFlightDuration() - cityB.getFlightDuration()) < 1.5)		
			{
				return true;
			}
			return false;
		}
		else if(i==2){
			if(cityA.getVISA().equals(cityB.getVISA())){

				return true;
			}
			return false;
		}
		else if(i==3){
			if(Math.abs(cityA.getPollutionLevel() - cityB.getPollutionLevel()) < 35 )
			{
				return true;
			}
			
			return false;
		}
		else if(i==4){
			if(cityA.getPeakSeasons().equals(cityB.getPeakSeasons()))
			{
				return true;
			}
			return false;
		}
		else if(i==5){
			if(Math.abs(cityA.getFlightPrice() - cityB.getFlightPrice()) < 3000)
			{
				return true;
			}
			return false;
		}
		else if(i==6){
			if(Math.abs(cityA.getTravelDistance() - cityB.getTravelDistance()) < 800 )
			{
				return true;
			}
			return false;
		}
		else if(i==7){
			int twiA = cityA.getTravelWarningIndex();
			int twiB = cityB.getTravelWarningIndex();
			
			if(( twiA <= 2.5 &&  twiB <= 2.5) || ( twiA > 2.5 && twiA <= 3.5 && twiB > 2.5 && twiB <= 3.5 ) || ( twiA > 3.5 && twiA <= 4.5 && twiB > 3.5 && twiB <= 4.5 ) || ( twiA > 4.5 && twiA <= 5 && twiB > 4.5 && twiB <= 5 ))
			{
				return true;
			}
			return false;
		}
		else if(i==8){
			int cityCategoryA[] ={cityA.getCultural(),cityA.getSightseeing(),cityA.getNightlife(),cityA.getSports(),cityA.getBeaches(),cityA.getActivity()};
			int cityCategoryB[] = {cityB.getCultural(),cityB.getSightseeing(),cityB.getNightlife(),cityB.getSports(),cityB.getBeaches(),cityB.getActivity()};
			int count = 6;
			
			for(int k=0;k<2;k++){
			if((cityCategoryA[k] > 4 && cityCategoryB[k] < 4) ||(cityCategoryA[k] < 4 && cityCategoryB[k] > 4) ){
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
			if(count>=4){
				return true;
			}
		
			return false;
		}
		else if(i==9){
			if( cityA.getTransportationIndex().equals(cityB.getTransportationIndex()))
			{
				return true;
			}
			return false;
		}
		else{
			if(cityA.getConnectivityIndex().equals(cityB.getConnectivityIndex()))
			{
				return true;
			}
			return false;
		}

	}
	
	public SimilarityIndexMain[] dbConnection(String city1,String city2) throws UnknownHostException{
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
		SimilarityIndexMain city[] = new SimilarityIndexMain[2];
		city[0] = cityA;
		city[1] = cityB;
		return city;
	}

}
