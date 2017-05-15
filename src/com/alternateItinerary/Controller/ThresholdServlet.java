package com.alternateItinerary.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alternateItinerary.Model.FactorsCustomization.FactorsCustomization;
import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

@WebServlet("/ThresholdServlet")
public class ThresholdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThresholdServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = "Main";
		
		if(request.getSession().getAttribute("admin").equals("1")){
			page = "Threshold";
			
			// connection
			DB db = (new MongoClient("localhost",27017)).getDB("AlternateItinerary"); 
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
			
			if(flag == 1){
				String ort = (String)object.get("ort");
				String drt = (String)object.get("drt");
				String smt = (String)object.get("smt");
				String sht = (String)object.get("sht");
				
//				System.out.println("DB Value = "+ort+" "+drt+" "+smt+" "+sht);
				
				request.getSession().setAttribute("ort",ort);
				request.getSession().setAttribute("drt",drt);
				request.getSession().setAttribute("smt",smt);
				request.getSession().setAttribute("sht",sht);	
			}
			
			
		}
		
		 
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ort= request.getParameter("ort");
		String drt= request.getParameter("drt");
		String smt= request.getParameter("smt");
		String sht= request.getParameter("sht");
		
		System.out.println(ort+" "+drt+" "+smt+" "+sht);
		
		// Put the data in POJO Class and then convert to JSON String
		FactorsCustomization fc = new FactorsCustomization();
		fc.setOrt(ort);
		fc.setDrt(drt);
		fc.setSmt(smt);
		fc.setSht(sht);
		
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

}
