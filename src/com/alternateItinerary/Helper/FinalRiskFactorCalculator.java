package com.alternateItinerary.Helper;

public class FinalRiskFactorCalculator {

	public double calclulateOriginRiskFactor(double weatherRiskFactor, double delayIndexRiskFactor , double flightRiskFactor,double flightStatusRiskFactor1,double flightStatusRiskFactor2,double fromTravelWarningIndex,double fromFlightRatingRiskFactor){
	
		// double RiskFactor = 0.3*weatherRiskFactor + 0.2*delayIndexRiskFactor + 0.1*flightRiskFactor + 0.1*flightStatusRiskFactor1 + 0.1*flightStatusRiskFactor2 + 0.1*fromTravelWarningIndex + 0.1*fromFlightRatingRiskFactor;
		double sum = 2*weatherRiskFactor + delayIndexRiskFactor + flightRiskFactor + flightStatusRiskFactor1 + flightStatusRiskFactor2 + fromTravelWarningIndex + fromFlightRatingRiskFactor;
		double RiskFactor = (sum*10)/7;
		return RiskFactor;
	}
	
	public double calclulateDestinationRiskFactor(double weatherRiskFactor, double delayIndex , double flightRiskFactor,double flightStatusRiskFactor1,double flightStatusRiskFactor2,double touristInflowRiskFactor,double peekSeasonRiskFactor,double flightRatingRiskFactor,double toTravelWarningIndex){
		
		// double RiskFactor = 0.2*weatherRiskFactor + 0.1*delayIndex + 0.1*flightRiskFactor +0.1*flightStatusRiskFactor1 +0.1*flightStatusRiskFactor2 + 0.1*touristInflowRiskFactor + 0.1*peekSeasonRiskFactor +0.1*flightRatingRiskFactor +0.1*toTravelWarningIndex ;
		double sum = weatherRiskFactor + delayIndex + flightRiskFactor + flightStatusRiskFactor1 + flightStatusRiskFactor2 + touristInflowRiskFactor + peekSeasonRiskFactor + flightRatingRiskFactor + toTravelWarningIndex ;
		double RiskFactor = (sum*10)/9;
		return RiskFactor;
	}
	
	public double calclulateAlternateOriginRiskFactor(double WeatherRiskFactor, double delayIndex){
		double sum = WeatherRiskFactor + delayIndex;
		double RiskFactor = (sum*10)/2;
		return RiskFactor;
	}
}
