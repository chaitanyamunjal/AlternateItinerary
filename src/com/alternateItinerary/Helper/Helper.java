package com.alternateItinerary.Helper;

import com.alternateItinerary.API.AirportAutocomplete;

import com.alternateItinerary.API.LocationCoordinates;
import com.alternateItinerary.API.ReverseGeocodingApi;
import com.alternateItinerary.API.WeatherForecastApi;
import com.alternateItinerary.RequestResponse.HelperResponse;

public class Helper {
	
	public HelperResponse findHelperResults( String from,String to,String date){
	
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
	
    // Putting the Results in the Response Object
    HelperResponse hr = new HelperResponse();
    hr.setFromAirportCode(fromAirportCode);
    hr.setFromCoordinates(fromCoordinates);
    hr.setFromCountryCode(fromCountryCode);
    hr.setFromCountryName(fromCountryName);
    hr.setFromWeatherParameters(fromWeatherParameters);
    hr.setToAirportCode(toAirportCode);
    hr.setToCoordinates(toCoordinates);
    hr.setToCountryCode(toCountryCode);
    hr.setToCountryName(toCountryName);
    hr.setToWeatherParameters(toWeatherParameters);
    
    
	return hr;
	}
}
