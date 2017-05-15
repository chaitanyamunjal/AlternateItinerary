package com.alternateItinerary.Helper;

import org.json.JSONObject;



import com.alternateItinerary.Model.WeatherTimeMachineApi.*;
import com.google.gson.Gson;

public class RiskFactorCalculator {

	public double calclulateRiskFactor(String WeatherParameters){
		
		/* ==========  WEATHER RISK FACTOR CALCULATOR ===========   */
		
		JSONObject json = new JSONObject(WeatherParameters);
        WeatherParams forecast = new Gson().fromJson(WeatherParameters,WeatherParams.class);
		
		// Getting the Weather Risk Parameters
		
        double windSpeed = 5;
		if(forecast.getCurrently().getWindSpeed() != null){
			windSpeed = forecast.getCurrently().getWindSpeed();
		}
	
		double temperature = 70;
		if(forecast.getCurrently().getTemperature() != null){
			temperature = forecast.getCurrently().getTemperature();
		}
		
		double visibility = 6;
		if(forecast.getCurrently().getVisibility() != null){
			visibility = forecast.getCurrently().getVisibility();
		}
		
		double precipIntensity = 0;
		if(forecast.getCurrently().getPrecipIntensity() != null) {
			precipIntensity = forecast.getCurrently().getPrecipIntensity();
		}
		
		String precipType = forecast.getCurrently().getPrecipType();
	
		// RISK FACTOR CALCULATION
		double riskFactor = 0;
		riskFactor = 0.0025*windSpeed + 0.0025*temperature + 0.025*visibility + 2.5*precipIntensity;
		
		if(windSpeed > 30 || temperature < 20 || visibility < 4 || precipType == "snow" || precipIntensity > 0.05 ){
			riskFactor = 1;
		}
		
		if(riskFactor == 1){
			System.out.println("Weather params causing High Risk = "+windSpeed+" % "+temperature+" % "+visibility+" % "+precipType+" % "+precipIntensity);
		}
		
        
		return riskFactor;
		
        
        
        /*
		 
		// RISK FACTOR CALCULATION USING ACCU-WEATHER PARAMETERS
		 
		JSONObject json = new JSONObject(WeatherParameters);
        Weather forecast = new Gson().fromJson(WeatherParameters,Weather.class);
        
        // DAY 
        Day day;
        double[] windGust = new double[5];
        double rain[] = new double[5];
        double snow[] =new double[5];
        double ice[] = new double[5];
        double thunderstorm[] =new double[5];
        for(int i = 0; i<5 ; i++){
        	day = forecast.getDailyForecasts().get(i).getDay();
        	windGust[i] = day.getWindGust().getSpeed().getValue();
        	rain[i] = day.getRain().getValue();
        	snow[i] = day.getSnow().getValue();
        	ice[i] = day.getIce().getValue();
        	thunderstorm[i] = day.getThunderstormProbability();
        }
        
        // NIGHT
        Night night;
        double windGust1[] = new double[5];
        double rain1[] = new double[5];
        double snow1[] = new double[5];
        double ice1[] = new double[5];
        double thunderstorm1[] = new double[5];
        
        for(int i = 0; i<5 ; i++){
        	
        	night = forecast.getDailyForecasts().get(i).getNight();
            
        	windGust1[i] = night.getWindGust().getSpeed().getValue();
        	rain1[i] = night.getRain().getValue();
        	snow1[i] = night.getSnow().getValue();
        	ice1[i] = night.getIce().getValue();
        	thunderstorm1[i] = night.getThunderstormProbability();
        }
        
        
        double riskFactor = 0;
		
    for(int i =0 ;i<5 ;i++){
    if(windGust[i]> 40 || rain[i]> 0.5 || snow[i]> 1 || ice[i]> 0.1 || thunderstorm[i] > 75 || windGust1[i]> 40 || rain1[i]> 0.5 || snow1[i] > 1 || ice1[i]> 0.1 || thunderstorm1[i] > 75 )
        {
      		riskFactor = 1;
      		break;
        }
     }
     
        return riskFactor;
    	*/
		

	}
}
