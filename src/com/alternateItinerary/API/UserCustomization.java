package com.alternateItinerary.API;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.alternateItinerary.RequestResponse.UserCustomResponse;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class UserCustomization {

	public UserCustomResponse getUserCustom(String username) {	

				// connection
				DB db = null;
				try {
					db = (new MongoClient("localhost",27017)).getDB("AlternateItinerary");
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				DBCollection dbc = db.getCollection("account");
						
				// make the query
				BasicDBObject query = new BasicDBObject();
				query.put("username",username);
				DBCursor cursor = dbc.find(query);
				BasicDBObject object = null;
				
				int flag = 0;
				try {
				   while(cursor.hasNext()) {
				     object = (BasicDBObject) cursor.next();
				     flag = 1;
				   }
				} finally {
				   cursor.close();
				}
				
				List<String> similarityFactorsValue = new ArrayList<>();
				List<String> riskFactorsValue = new ArrayList<>();
				List<String> similarityFactorsChecked = new ArrayList<>();
				List<String> riskFactorsChecked = new ArrayList<>();
				
				if(flag == 1){
					BasicDBList list1 = (BasicDBList) object.get("similarityFactorsValue");
					BasicDBList list2 = (BasicDBList) object.get("riskFactorsValue");
					BasicDBList list3 = (BasicDBList) object.get("similarityFactorsChecked");
					BasicDBList list4 = (BasicDBList) object.get("riskFactorsChecked");
					System.out.println("list1 ============== "+list1);
					if(list1 != null){
						for(Object el: list1) {
							similarityFactorsValue.add((String) el);
						}
					}
					if(list2 != null){
						for(Object el: list2) {
							riskFactorsValue.add((String) el);
						}
					}

					if(list3 != null){
						for(Object el: list3) {
							similarityFactorsChecked.add((String) el);
						}
					}	
					if(list4 != null){
						for(Object el: list4) {
							riskFactorsChecked.add((String) el);
						}
					}	
				}
				
				String[] similarityFactorsValue1 = similarityFactorsValue.toArray(new String[0]);
				String[] riskFactorsValue1 = riskFactorsValue.toArray(new String[0]);
				String[] similarityFactorsChecked1 = similarityFactorsChecked.toArray(new String[0]);
				String[] riskFactorsChecked1 = riskFactorsChecked.toArray(new String[0]);
				
				
				UserCustomResponse ucr = new UserCustomResponse();
				
				ucr.setRiskFactorsChecked(riskFactorsChecked1);
				ucr.setRiskFactorsValue(riskFactorsValue1);
				ucr.setSimilarityFactorsChecked(similarityFactorsChecked1);
				ucr.setSimilarityFactorsValue(similarityFactorsValue1);
			
				return ucr;
	}

}
