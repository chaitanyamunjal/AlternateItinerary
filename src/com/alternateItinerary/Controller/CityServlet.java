package com.alternateItinerary.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alternateItinerary.API.AdminCustomization;
import com.alternateItinerary.API.FlightRating;
import com.alternateItinerary.API.UserCustomization;
import com.alternateItinerary.Helper.FinalRiskFactorCalculator;
import com.alternateItinerary.Helper.SimilarityIndexHelper;
import com.alternateItinerary.RequestResponse.AdminCustomResponse;
import com.alternateItinerary.RequestResponse.ResponseObject;
import com.alternateItinerary.RequestResponse.UserCustomResponse;
import com.google.gson.Gson;

@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = "City";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String city1 = request.getParameter("city1");
		
		// Get the Checked Factors and their values from Customization
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
		
		
		System.out.println("city got = "+city1);
		SimilarityIndexHelper helper = new SimilarityIndexHelper();
		ResponseObject ro = helper.findSimilarCity(city1,factorValue,checkedFactors);
  		
		String json = new Gson().toJson(ro);
    	response.setContentType("application/json");
  		PrintWriter out = response.getWriter();
  		out.print(json);
  		out.flush();
  		return;
	}

}
