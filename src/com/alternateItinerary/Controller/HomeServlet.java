package com.alternateItinerary.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alternateItinerary.API.AdminCustomization;
import com.alternateItinerary.API.UserCustomization;
import com.alternateItinerary.Helper.SimilarityIndexCalculator;
import com.alternateItinerary.Helper.SimilarityIndexHelper;
import com.alternateItinerary.RequestResponse.AdminCustomResponse;
import com.alternateItinerary.RequestResponse.HomeServletResponse;
import com.alternateItinerary.RequestResponse.ResponseObject;
import com.alternateItinerary.RequestResponse.UserCustomResponse;
import com.google.gson.Gson;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String page = "Home";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String city1 = request.getParameter("city1");
		String city2 = request.getParameter("city2");
		
		// Get the Checked Factors and their values from Customization and threshold values from Admin Customization DB
		String admin = (String) request.getSession().getAttribute("admin");
  		String username = (String) request.getSession().getAttribute("un");
  		UserCustomization uc = new UserCustomization();
		UserCustomResponse ucr = uc.getUserCustom(username);
		AdminCustomization ac = new AdminCustomization();
		AdminCustomResponse acr = ac.getAdminCustom();
		double mediumThreshold = acr.getSmt();
		double highThreshold = acr.getSht();
		
		int flag = 0;
  		if(request.getSession().getAttribute("admin").equals("1")){
  			flag = 1;
  		}
  		else{
  			if(ucr.getSimilarityFactorsValue().length == 0){
  				flag = 1;
  			}
  		}
  		
		String factorValue[];
		String checkedFactors[];
		
		if(flag==1){
			factorValue = acr.getSimilarityFactorsValue();
			checkedFactors = acr.getSimilarityFactorsChecked();
  		}else{
  			factorValue = ucr.getSimilarityFactorsValue();
  			checkedFactors = ucr.getSimilarityFactorsChecked();
  		}
		
		
		
		SimilarityIndexCalculator sic = new SimilarityIndexCalculator();
		double similarityIndex = sic.calclulateSimilarityIndex2(city1, city2,factorValue,checkedFactors);
		String value;
		if(similarityIndex >= highThreshold){
			value = "High";
		}
		else if(similarityIndex >= mediumThreshold){
			value = "Medium";
		}
		else {
			value = "Low"; 
		}
        
		// Sending an AJAX Response to the AJAX request received 
    	HomeServletResponse hsr = new HomeServletResponse();
    	hsr.setSimilarityIndex(similarityIndex);
    	hsr.setValue(value);
    	
    	String json = new Gson().toJson(hsr);
  		response.setContentType("application/json");
  		PrintWriter out = response.getWriter();
  		out.print(json);
  		out.flush();
  		return;

	}
}
