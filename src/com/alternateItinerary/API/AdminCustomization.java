package com.alternateItinerary.API;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.alternateItinerary.RequestResponse.AdminCustomResponse;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class AdminCustomization {

	public AdminCustomResponse getAdminCustom() {	

				// connection
				DB db = null;
				try {
					db = (new MongoClient("localhost",27017)).getDB("AlternateItinerary");
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				DBCollection dbc = db.getCollection("adminCustomization");
						
				// make the query
				BasicDBObject query = new BasicDBObject();
				query.put("name","admin");
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
					
					for(Object el: list1) {
						similarityFactorsValue.add((String) el);
					}
					for(Object el: list2) {
						riskFactorsValue.add((String) el);
					}
					for(Object el: list3) {
						similarityFactorsChecked.add((String) el);
					}
					for(Object el: list4) {
						riskFactorsChecked.add((String) el);
					}
				}
				
				String[] similarityFactorsValue1 = similarityFactorsValue.toArray(new String[0]);
				String[] riskFactorsValue1 = riskFactorsValue.toArray(new String[0]);
				String[] similarityFactorsChecked1 = similarityFactorsChecked.toArray(new String[0]);
				String[] riskFactorsChecked1 = riskFactorsChecked.toArray(new String[0]);
				
				
				double drt =  Double.parseDouble((String) object.get("drt"));
				double ort =  Double.parseDouble((String) object.get("ort"));
				double smt =  Double.parseDouble((String) object.get("smt"));
				double sht =  Double.parseDouble((String) object.get("sht"));
				
				System.out.println(" test results ="+drt+" "+ort+" "+smt+" "+sht);
				
				AdminCustomResponse acr = new AdminCustomResponse();
				acr.setDrt(drt);
				acr.setOrt(ort);
				acr.setSht(sht);
				acr.setSmt(smt);
				
				acr.setRiskFactorsChecked(riskFactorsChecked1);
				acr.setRiskFactorsValue(riskFactorsValue1);
				acr.setSimilarityFactorsChecked(similarityFactorsChecked1);
				acr.setSimilarityFactorsValue(similarityFactorsValue1);
			
				return acr;
	}

}
