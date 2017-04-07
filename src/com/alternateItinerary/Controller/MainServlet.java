package com.alternateItinerary.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.alternateItinerary.API.AirportAutocomplete;
import com.alternateItinerary.API.AirportDelayIndex;
import com.alternateItinerary.API.AlternateOriginCalculator;
import com.alternateItinerary.API.DestinationImageApi;
import com.alternateItinerary.API.DistanceApi;
import com.alternateItinerary.API.FlightRating;
import com.alternateItinerary.API.FlightStatus;
import com.alternateItinerary.API.FlightsLowFare;
import com.alternateItinerary.API.LocationCoordinates;
import com.alternateItinerary.API.PeekSeasonRisk;
import com.alternateItinerary.API.ReverseGeocodingApi;
import com.alternateItinerary.API.TouristInflowDb;
import com.alternateItinerary.API.TravelWarningIndex;
import com.alternateItinerary.API.WeatherForecastApi;
import com.alternateItinerary.Helper.FinalRiskFactorCalculator;
import com.alternateItinerary.Helper.RiskFactorCalculator;
import com.alternateItinerary.Helper.SimilarityIndexCalculator;
import com.alternateItinerary.Helper.SimilarityIndexHelper;
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
		
		/* ======================  HELPER API'S ======================= */
		
		// Find the coordinates of the Origin & Destination using the google maps geocoding API
		LocationCoordinates obj = new LocationCoordinates();
		String fromCoordinates = obj.findCoordinates(from);
		String toCoordinates = obj.findCoordinates(to);
		
		// Find the Airport Code of the Origin and Destination using Airport Autocomplete API
		AirportAutocomplete object = new AirportAutocomplete();
		String fromAirportCode = object.findAirportCode(from);
		String toAirportCode = object.findAirportCode(to);
		
		// Weather Time Machine API
		WeatherForecastApi obj1 = new WeatherForecastApi();
		String fromWeatherParameters = obj1.findParameters(fromCoordinates, date);
	    String toWeatherParameters = obj1.findParameters(toCoordinates, date);
				
	    // API to get the Country Code by country name -> https://restcountries.eu/rest/v2/name/india?fullText=true
	    // Google API to get the Country code from Coordinates
	    ReverseGeocodingApi rga = new ReverseGeocodingApi();
	    String fromCountry[] = rga.findCountryCode(fromCoordinates);
	    String fromCountryCode = fromCountry[0];
	    String fromCountryName = fromCountry[1];
	    String toCountry[] = rga.findCountryCode(toCoordinates);
	    String toCountryCode = toCountry[0];
	    String toCountryName = toCountry[1];
	    System.out.println("Origin country code = "+fromCountryCode + "  & "+fromCountryName);
	    System.out.println("destination country code = "+toCountryCode+ "  & "+toCountryName);
	    
	    /*  ===================     PHASE - 1  ( Finding Risk ) =======================  */
	    
	    
	    // 1. Calculate the Weather Risk Factor for Weather Risk Parameters
	    RiskFactorCalculator rfc = new RiskFactorCalculator();
	    double fromWeatherRiskFactor = rfc.calclulateRiskFactor(fromWeatherParameters);
    	double toWeatherRiskFactor = rfc.calclulateRiskFactor(toWeatherParameters);
    	System.out.println("FROM Weather risk factor value = "+fromWeatherRiskFactor);
    	System.out.println("TO Weather risk factor value = "+toWeatherRiskFactor);
    	
    	
		// 2. Calculate the Airport Delay Index for Origin and Destination
    	AirportDelayIndex obj2 = new AirportDelayIndex();
    	double fromDelayIndexRiskFactor = obj2.findDelayIndex(fromAirportCode);
    	double toDelayIndexRiskFactor = obj2.findDelayIndex(toAirportCode);
    	System.out.println("FROM Airport delay index value = "+fromDelayIndexRiskFactor);
    	System.out.println("TO Airport delay index value = "+toDelayIndexRiskFactor);
    	
   		// 3. Calculate the Flight Risk Factor for the Flight ( on the basis of flight status )
    	FlightStatus obj3 = new FlightStatus();
    	double flightStatusRiskFactor = obj3.findFlightStatus(airline, flightnumber, date1,fromAirportCode);
    	System.out.println(" Flight Status Risk Factor =  "+flightStatusRiskFactor);
    	 
    	// 4. Calculate Risk Factor due to Cancellation of Flights ( Historical Data ) - flight history status API
    	double flightStatusRiskFactor1 = obj3.findFlightStatus(airline, flightnumber, previousDate1, fromAirportCode);
    	double flightStatusRiskFactor2 = obj3.findFlightStatus(airline, flightnumber, previousDate2, fromAirportCode);
   		System.out.println(flightStatusRiskFactor1 + " ------ "+flightStatusRiskFactor2);
    	
   		// 5. Calculate the Current Affairs Risk Factor
    	
    	// 6. Calculate Risk Factor due to Tourist In-flow
   		TouristInflowDb obj6 = new TouristInflowDb();
   		double touristInflowRiskFactor = obj6.findTouristInflow(fromCountryName, x);
   		System.out.println("Tourist Inflow Risk = "+touristInflowRiskFactor);
   		
   		// 7. Calculate Risk Factor Due to Peek Season / Off Season
   		PeekSeasonRisk obj7 = new PeekSeasonRisk();
   		double peekSeasonRiskFactor = obj7.findPeekSeasonRisk(to, x+1);
   		System.out.println("Peek season Risk = "+peekSeasonRiskFactor);
   		
    	// 8. Calculate the Risk Factor due to Flight Rating
    	FlightRating obj8 = new FlightRating();
    	double flightRatingRiskFactor = obj8.findFlightRating(airline, flightnumber);
    	System.out.println("flight rating risk factor = "+flightRatingRiskFactor);
    	
    	// 9. Travel Warning Index of Origin and Destination
    	TravelWarningIndex obj9 = new TravelWarningIndex();
    	double fromTravelWarningIndexRiskFactor = obj9.findTravelWarningIndex(fromCountryCode);
    	double toTravelWarningIndexRiskFactor = obj9.findTravelWarningIndex(toCountryCode);
    	System.out.println("Travel warning index of origin and destination are = "+fromTravelWarningIndexRiskFactor+" and "+toTravelWarningIndexRiskFactor);
    	
    	// 10. Final Risk Factor Calculation using the above Individual Risk Factors
    	FinalRiskFactorCalculator obj10 = new FinalRiskFactorCalculator();
    	double fromRiskFactor = obj10.calclulateOriginRiskFactor(fromWeatherRiskFactor, fromDelayIndexRiskFactor, flightStatusRiskFactor,flightStatusRiskFactor1,flightStatusRiskFactor2,fromTravelWarningIndexRiskFactor,flightRatingRiskFactor);
    	double toRiskFactor = obj10.calclulateDestinationRiskFactor(toWeatherRiskFactor, toDelayIndexRiskFactor, flightStatusRiskFactor,flightStatusRiskFactor1,flightStatusRiskFactor2,touristInflowRiskFactor,peekSeasonRiskFactor,flightRatingRiskFactor,toTravelWarningIndexRiskFactor);
    	System.out.println("FINAL risk factors for ORIGIN = "+fromRiskFactor + " and DESTINATION = " + toRiskFactor);
    	
    	
    	
    	/*  ===================     PHASE - 2 ( GIVING SUGGESTION / RECOMMENDATION ) =======================  */
	    
    	
    	// 1. Find the Nearest Relevant Airport if RISK At " ORIGIN "
    	// NOTE -> Also check if there is a flight from alternate origin to the Actual Destination
    	String alternateOrigin = from;
    	if(fromRiskFactor > 1){
    		// we pass the coordinates which we got from google maps geocoding api to this class which will return the Nearest Relevant Airport/City
    		AlternateOriginCalculator obj5 = new AlternateOriginCalculator();
    		alternateOrigin = obj5.findAlternateOrigin(fromCoordinates,date); 
    		System.out.println("alternate origin found in the main servlet is = "+alternateOrigin);
    	    
    	}
    	
    	
    	
    	/*
    	 Alternate City Finding Technique - 2
    	
    	// 2. if RISK At " Destination " -->> Check for Different Dates Risk at Destination 
    	
    	// 3. If No other Date Found without Risk then -->>  Find an Alternate Destination if RISK At " Destination "
    	
    	// 3.1 Distance between origin and destination
    		DistanceApi object31 = new DistanceApi();
    		int distance = object31.findDistance(from, to);
    		System.out.println("Distance between "+from+" and "+to+" is "+distance);
    		
    	// 3.2 Rating of Destination
    	// 3.3 Local Average Expense
    	// 3.4 Flight Budget
    		FlightsLowFare object34 = new FlightsLowFare();
    		String budget = object34.findFlight(fromAirportCode, toAirportCode, date);

    	// 3.5 Tourist Inflow
    	// 3.6 VISA
    	// 3.7 Type of City
    	
    	// 4. Check for Flights from alternate Origin to Alternate destination --> " SAME AS 3.4 " -->> Flights Low Fare API 
    			
    	 */
        

    		
        // 5. Search for Alternate Destination if Risk at Destination and then find the Risk Factor at all the possible Destinations and then Give the Best Result
        if(toRiskFactor > 4){
        	SimilarityIndexHelper object6 = new SimilarityIndexHelper();
         // get the top 3 alternate destinations and find the Risk Factor at these Alternate Destinations and check if there are flights from alternate Origin to these locations and give the Alternate Itinerary Results on the front end
        }
        
        // 6. Destination Image API to get the Image of Alternate Destination 
    	DestinationImageApi object5 = new DestinationImageApi();
    	String url = object5.findImage(toAirportCode);
    
    	// 7. Send Alternate Itinerary Results to Front-End
    	String json_city = "{ \"data\" : \"" + " Origin Risk Factor  =  "+ fromRiskFactor + " Destination Risk Factor  =  "+ toRiskFactor + " Alternate Origin  =  "+ alternateOrigin +"\" }";
    	
//    	ArrayList<Double> finalResult = new ArrayList<Double>();
//    	finalResult.add(fromRiskFactor);
//    	finalResult.add(toRiskFactor); 
//		String json = new Gson().toJson(finalResult);
    	
    	response.setContentType("application/json");
  		PrintWriter out = response.getWriter();
  		out.print(json_city);
  		out.flush();
  		return;

  		
    		
    		
    		
 
    	/*
		//  ACCU WEATHER API  
		 "  STEP 1  " - TEXT SEARCH API FOR LOCATION KEY   
    	// Get the location key from Text Search API ( ACCU-WEATHER ) for " from " and " to "
		LocationKey obj = new LocationKey();
		String fromKey = obj.findLocationKey(from);
		String toKey = obj.findLocationKey(to);
    	System.out.println(" value in main servlet is  = "+fromKey+" "+toKey);
    	
    	 "  STEP 2 " - WEATHER FORECAST API TO GET THE WEATHER FORECAST FOR 5 DAYS
    	// Get the Weather Risk Parameters ( ACCU-WEATHER Forecast API )
		weatherForecast obj1 = new weatherForecast();
    	String fromWeatherParameters = obj1.findParameters(fromKey);
    	String toWeatherParameters = obj1.findParameters(toKey);
    	System.out.println(" weather params in MAIN SERVLET ARE ====== = "+fromWeatherParameters+" "+toWeatherParameters);
    	
    	" STEP 3 " -> CALCULATE RISK FACTOR FOR WEATHER FORECAST
    	// Calculate the Risk Factor for Weather Risk Parameters
    	RiskFactorCalculator rfc = new RiskFactorCalculator();
    	double fromRiskFactor = rfc.calclulateRiskFactor(fromWeatherParameters);
    	double toRiskFactor = rfc.calclulateRiskFactor(toWeatherParameters);
    	System.out.println("FROM risk factor value = "+fromRiskFactor);
    	System.out.println("TO risk factor value = "+toRiskFactor);
   	*/
		
    	
//		// creating object of googlemapsservice CLASS and calling its function findNearestCity to find the Tier 1 City
//		GoogleMapsService maps = new GoogleMapsService();
//        String city = maps.findNearestCity(to);
//		String json_city = "{ \"data\" : \"" + city + "\" }";
//        System.out.println(city);
//        
//        // STEP 2 -> FINDING THE AIRPORT CODE OF " FROM " AND " CITY" Found
//        // creating object of AirportCode CLASS and calling its function findAirportCode
//        AirportCode code = new AirportCode();
//        String source = code.findAirportCode(from);               // to get the airport code of from
//        String destination = code.findAirportCode(city);          //  to get the airport code of nearest TIER 1 city found  
//		
//        // STEP 3 -> FINDING ALL THE FLIGHTS FROM SOURCE TO DESTINATION
//        /*---- Pass the " source " and  " destination " -->> which are the airport codes found and pass them as an argument to another function 
//          ---  of another API Class to find the flights  ----- */
//        FlightService obj = new FlightService();
//        String flights = obj.findFlights(source,destination,date);
//        
//        
//        
//        // STEP 4 -> Getting the Railway Staion Code
//        RailwayStations rail = new RailwayStations();
//        String  train_source = rail.findStationsCode(city);
//        String  train_destination = rail.findStationsCode(to);
//        
//        // STEP 5 -> GETTING THE LIST OF TRAINS 
//        RailwayService train = new RailwayService();
//        String trains = train.findStations(train_source,train_destination,date1);
//        
        
        // STEP 6 - COMBINE THE LIST OF FLIGHTS AND LIST OF TRAINS INTO 1 JSON OBJECT
 //       String bothJson = "["+flights+","+trains+"]";
        
        /* send the list of flights & Trains obtained through AJAX
          Sending an AJAX Response to the AJAX request received */
		//response.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
	//	PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
	//	out.print(bothJson);
		//out.flush();

	}

}
