package com.alternateItinerary.Controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alternateItinerary.API.AdminCustomization;
import com.alternateItinerary.API.UserCustomization;
import com.alternateItinerary.Model.FactorsCustomization.FactorsCustomization;
import com.alternateItinerary.Model.TouristInflowDb.Tourist;
import com.alternateItinerary.RequestResponse.AdminCustomResponse;
import com.alternateItinerary.RequestResponse.UserCustomResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

/**
 * Servlet implementation class RiskCustomizationServlet
 */
@WebServlet("/RiskCustomizationServlet")
public class RiskCustomizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RiskCustomizationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Get the User or Admin Customization from the DB 
		String admin = (String) request.getSession().getAttribute("admin");
  		String username = (String) request.getSession().getAttribute("un");
  		
  		UserCustomization uc = new UserCustomization();
		UserCustomResponse ucr = uc.getUserCustom(username);
		AdminCustomization ac = new AdminCustomization();
		AdminCustomResponse acr = ac.getAdminCustom();
				
  		int flag = 0;
  		if(request.getSession().getAttribute("admin").equals("1")){
  			flag = 1;
  		}
  		else{
  			if(ucr.getRiskFactorsValue().length == 0){
  				flag = 1;
  			}
  		}
  		
  		String riskFactorsValue[];
  		
  		if(flag==1){
  			riskFactorsValue = acr.getRiskFactorsValue();
  		}else{
  			riskFactorsValue = ucr.getRiskFactorsValue();
  		}
  		
		request.getSession().setAttribute("riskFactorsValue",riskFactorsValue);
		
		String page = "RiskFactorsCustomization";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] factorValue = new String[8];
		String[] checkedFactors = new String[8];
		
		
		
		
		// Update the Customization in the Admin Customization DB-Collection
		if(request.getSession().getAttribute("admin").equals("1")){
			
			int j=0;
			for(int i=0;i<8;i++){
				j = i+1;
				factorValue[i] = request.getParameter("f"+j);
				checkedFactors[i] = request.getParameter("c"+j);
			}
			
			// Put the data in POJO Class and then convert to JSON String
			FactorsCustomization fc = new FactorsCustomization();
			fc.setRiskFactorsValue(factorValue);
			Gson gson = new Gson();
			String json = gson.toJson(fc);
			
			DB db = (new MongoClient("localhost",27017)).getDB("AlternateItinerary"); 
			DBCollection dbc = db.getCollection("adminCustomization");

			// UPDATE the DB with new Admin Customization
			BasicDBObject obj = (BasicDBObject) JSON.parse(json);
			
			BasicDBObject updateQuery = new BasicDBObject();
			updateQuery.append("$set",obj);

			BasicDBObject searchQuery3 = new BasicDBObject();
			searchQuery3.append("name","admin");
			
			dbc.updateMulti(searchQuery3, updateQuery);
		}
		// Store the Customization in the User Account - DataBase
		else{
			if(request.getParameter("reset").equals("1")){
				AdminCustomization ac = new AdminCustomization();
				AdminCustomResponse acr = ac.getAdminCustom();
				checkedFactors = acr.getRiskFactorsChecked();
				factorValue = acr.getRiskFactorsValue();
			}
			else{
				int j=0;
				for(int i=0;i<8;i++){
					j = i+1;
					checkedFactors[i] = request.getParameter("c"+j);
					if(checkedFactors[i].equals("1") ){
						factorValue[i] = request.getParameter("f"+j);
					}
					else
					{
						factorValue[i] = " N.A. ";
					}
				}
			}
			
			// Put the data in POJO Class and then convert to JSON String
			FactorsCustomization fc = new FactorsCustomization();
			fc.setRiskFactorsChecked(checkedFactors);
			fc.setRiskFactorsValue(factorValue);
			Gson gson = new Gson();
			String json = gson.toJson(fc);
				
			DB db = (new MongoClient("localhost",27017)).getDB("AlternateItinerary"); 
			DBCollection dbc = db.getCollection("account");
			
			// search for the username and then update the customization for that user 
			String username = (String) request.getSession().getAttribute("un");

			// UPDATE the DB with new Admin Customization
			BasicDBObject obj = (BasicDBObject) JSON.parse(json);
						
			BasicDBObject updateQuery = new BasicDBObject();
			updateQuery.append("$set",obj);

			BasicDBObject searchQuery3 = new BasicDBObject();
			searchQuery3.append("username",username);
						
		    dbc.updateMulti(searchQuery3, updateQuery);
		}

	}

}
