package com.alternateItinerary.Controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.alternateItinerary.API.AdminCustomization;
import com.alternateItinerary.API.UserCustomization;
import com.alternateItinerary.Helper.Helper;
import com.alternateItinerary.Helper.PhaseOneHelper;
import com.alternateItinerary.Helper.PhaseTwoHelper;
import com.alternateItinerary.RequestResponse.AdminCustomResponse;
import com.alternateItinerary.RequestResponse.HelperResponse;
import com.alternateItinerary.RequestResponse.MainServletResponse;
import com.alternateItinerary.RequestResponse.PhaseOneResponse;
import com.alternateItinerary.RequestResponse.PhaseTwoResponse;
import com.alternateItinerary.RequestResponse.UserCustomResponse;
import com.google.gson.Gson;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
	    String page = "Main";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
		
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	response.setContentType("application/json");
  		PrintWriter out = response.getWriter();
  		
    	// Admin value
  		String admin = (String) request.getSession().getAttribute("admin");
  		String username = (String) request.getSession().getAttribute("un");
  		
  		int flag = 0;
  		if(request.getSession().getAttribute("admin").equals("1")){
  			flag = 1;
  		}
  		else{
  			UserCustomization uc = new UserCustomization();
  			UserCustomResponse ucr = uc.getUserCustom(username);
  			if(ucr.getRiskFactorsValue().length == 0){
  				flag = 1;
  			}
  		}
  		
  		// Get the Customization Data from the Database 
  			AdminCustomization ac = new AdminCustomization();
  			AdminCustomResponse acr = ac.getAdminCustom();
  			UserCustomization uc = new UserCustomization();
  			UserCustomResponse ucr = uc.getUserCustom(username);
  			double riskThreshold1 = acr.getOrt();
  			double riskThreshold2 = acr.getDrt();
  			
  			// these 4 arrays get the data from the Database
  			String riskFactorsValue[] = null;
  			String riskFactorsChecked[] = null;
  			String similarityFactorsValue[] = null;
  			String similarityFactorsChecked[] = null;
  			
  			// when Admin Risk Factor Customization is to be used
  			if(flag==1){
  			    riskFactorsValue = acr.getRiskFactorsValue();
  			    riskFactorsChecked = acr.getRiskFactorsChecked();
  				similarityFactorsValue = acr.getSimilarityFactorsValue();
  				similarityFactorsChecked = acr.getSimilarityFactorsChecked();

  			}
  			// When the User has Risk Factors Customized
  			else{
  	  			riskFactorsValue = ucr.getRiskFactorsValue();
  	  			riskFactorsChecked = ucr.getRiskFactorsChecked();
  				similarityFactorsValue = ucr.getSimilarityFactorsValue();
  				similarityFactorsChecked = ucr.getSimilarityFactorsChecked();
  			}
  			

    	// Details Of Current factors Settings
    	if(request.getParameter("action").equals("details")){
    		MainServletResponse msr = new MainServletResponse();
    		msr.setRiskThreshold1(riskThreshold1);
        	msr.setRiskThreshold2(riskThreshold2);
        	msr.setRiskFactorsChecked(riskFactorsChecked);
        	msr.setRiskFactorsValue(riskFactorsValue);
        	msr.setSimilarityFactorsChecked(similarityFactorsChecked);
        	msr.setSimilarityFactorsValue(similarityFactorsValue);
        	
        	String json = new Gson().toJson(msr);
        	out.print(json);
      		out.flush();
      		return;
        	
        	
    	}
    	
    	
    	
    	/*
  	    //running from local server for UI - Testing 
    	if(true) {
  			MainServletResponse r1 = new DebugDataFetcher().getData();

  			String json = new Gson().toJson(r1);
  	    	
  	    	
  	  		out.print(json);
  	  		out.flush();
  	  		return;
  		}
    	*/
  		
  		
  		
  		
    	// take from and to value from the Form via AJAX
    	String from = request.getParameter("from");
		String to = request.getParameter("to");
		String airline = request.getParameter("airline");
		String flightnumber = request.getParameter("flightnumber");
		
		// Date in yyyy-mm-dd format
		String date = request.getParameter("date");
		// Date in yyyy/mm/dd format for flight Stats API
		String date1 = request.getParameter("date1");
		// Month of Date
		String month = request.getParameter("month");
		int x = Integer.parseInt(month);
   		
		// Date in ISO format to get the previous 2 dates from it for Flight Status for past 2 days 
		String date2 = request.getParameter("date2");
		DateTime dt = new DateTime(date2);
		DateTimeFormatter fmt = DateTimeFormat.forPattern("y/MM/dd");
		dt = dt.minusDays(1);
		String previousDate1 = dt.toString(fmt);
		dt = dt.minusDays(1);
		String previousDate2 = dt.toString(fmt);
		System.out.println(from+" "+to+" "+airline+" "+flightnumber+" "+date+" "+date1+" "+previousDate1+" "+previousDate2);

		// HELPER API'S
		Helper h = new Helper();
	    HelperResponse hr = h.findHelperResults(from, to, date);
	    String fromCoordinates = hr.getFromCoordinates();
	    String toCoordinates = hr.getToCoordinates();
	    String fromAirportCode = hr.getFromAirportCode();
	    String toAirportCode = hr.getToAirportCode();
	    String fromWeatherParameters = hr.getFromWeatherParameters();
	    String toWeatherParameters = hr.getToWeatherParameters();
	    String fromCountryCode = hr.getFromCountryCode();
	    String fromCountryName = hr.getFromCountryName();
	    String toCountryCode = hr.getToCountryCode();
	    String toCountryName = hr.getToCountryName();
		
	    // PHASE - 1 
	    PhaseOneHelper poh = new PhaseOneHelper();
	    PhaseOneResponse por = poh.findPhaseOneResults(riskFactorsValue,riskFactorsChecked,fromCountryName,fromCountryCode,toCountryCode,fromWeatherParameters, toWeatherParameters, fromAirportCode, toAirportCode, airline, flightnumber, date1, previousDate1, previousDate2, from, to, x);
	    double fromRiskFactor = por.getFromRiskFactor() ;
	    double toRiskFactor = por.getToRiskFactor() ;
	    
	    // PHASE - 2
	    PhaseTwoHelper pth = new PhaseTwoHelper();
	    PhaseTwoResponse ptr = pth.findPhaseTwoResults(riskThreshold1,riskThreshold2,riskFactorsValue,riskFactorsChecked,similarityFactorsValue,similarityFactorsChecked,fromRiskFactor, toRiskFactor, from, fromCoordinates, date,date1,previousDate1,previousDate2,fromAirportCode,toAirportCode,to,x);
	    String alternateOrigin = ptr.getAlternateOrigin();
	    String alternaeDestination[] = ptr.getAlternateDestination();
	    String alternateDestinationUrl[] = ptr.getAlternateDestinationURL();
	    double alternateDestinationRiskFactor[] = ptr.getRiskFactor();
	    double alternateDestinationSimilarityIndex[] = ptr.getSimilarityIndex();
	    double size = ptr.getSize();
	    double alternateOriginRiskFactor = ptr.getAlternateOriginRiskFactor();
	    String urlDestination = ptr.getUrlDestination(); 
	    String urlOrigin =  ptr.getUrlOrigin();
	    
	    
	    // Send Alternate Itinerary Results to Front-End
    	MainServletResponse msr = new MainServletResponse();
    	msr.setFromRiskFactor(fromRiskFactor);
    	msr.setToRiskFactor(toRiskFactor);
    	msr.setAlternateOrigin(alternateOrigin);
    	msr.setAlternateDestination(alternaeDestination);
    	msr.setAlternateDestinationUrl(alternateDestinationUrl);
    	msr.setAlternateDestinationRiskFactor(alternateDestinationRiskFactor);
    	msr.setAlternateDestinationSimilarityIndex(alternateDestinationSimilarityIndex);
    	msr.setSize(size);
    	msr.setAlternateOriginRiskFactor(alternateOriginRiskFactor);
    	msr.setUrlDestination(urlDestination);
    	msr.setUrlOrigin(urlOrigin);
    	msr.setRiskThreshold1(riskThreshold1);
    	msr.setRiskThreshold2(riskThreshold2);
    	

    	String json = new Gson().toJson(msr);
    	out.print(json);
  		out.flush();
  		return;

  		
    		
    		

	}

}
