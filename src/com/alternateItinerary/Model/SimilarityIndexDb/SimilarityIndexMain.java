package com.alternateItinerary.Model.SimilarityIndexDb;


import com.google.gson.annotations.Expose;

import com.google.gson.annotations.SerializedName;


public class SimilarityIndexMain {

@SerializedName("City")
@Expose
private String city;
@SerializedName("Tourist Attraction Index")
@Expose
private String touristAttractionIndex;
@SerializedName("Flight Duration")
@Expose
private double flightDuration;
@SerializedName("VISA")
@Expose
private String vISA;
@SerializedName("Pollution level")
@Expose
private Integer pollutionLevel;
@SerializedName("Peak seasons")
@Expose
private String peakSeasons;
@SerializedName("Flight Price")
@Expose
private Integer flightPrice;
@SerializedName("Travel Distance")
@Expose
private Integer travelDistance;
@SerializedName("Travel Warning Index")
@Expose
private Integer travelWarningIndex;
@SerializedName("Cultural")
@Expose
private Integer cultural;
@SerializedName("Sightseeing")
@Expose
private Integer sightseeing;
@SerializedName("Nightlife")
@Expose
private Integer nightlife;
@SerializedName("Activity")
@Expose
private Integer activity;
@SerializedName("Sports")
@Expose
private Integer sports;
@SerializedName("Beaches")
@Expose
private Integer beaches;
@SerializedName("Transportation Index")
@Expose
private String transportationIndex;
@SerializedName("Connectivity Index")
@Expose
private String connectivityIndex;
@SerializedName("Direct Flights per Week (#Of)")
@Expose
private Integer directFlightsPerWeekOf;
@SerializedName("Airport")
@Expose
private String airport;

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getTouristAttractionIndex() {
return touristAttractionIndex;
}

public void setTouristAttractionIndex(String touristAttractionIndex) {
this.touristAttractionIndex = touristAttractionIndex;
}

public double getFlightDuration() {
return flightDuration;
}

public void setFlightDuration(double flightDuration) {
this.flightDuration = flightDuration;
}

public String getVISA() {
return vISA;
}

public void setVISA(String vISA) {
this.vISA = vISA;
}

public Integer getPollutionLevel() {
return pollutionLevel;
}

public void setPollutionLevel(Integer pollutionLevel) {
this.pollutionLevel = pollutionLevel;
}

public String getPeakSeasons() {
return peakSeasons;
}

public void setPeakSeasons(String peakSeasons) {
this.peakSeasons = peakSeasons;
}

public Integer getFlightPrice() {
return flightPrice;
}

public void setFlightPrice(Integer flightPrice) {
this.flightPrice = flightPrice;
}

public Integer getTravelDistance() {
return travelDistance;
}

public void setTravelDistance(Integer travelDistance) {
this.travelDistance = travelDistance;
}

public Integer getTravelWarningIndex() {
return travelWarningIndex;
}

public void setTravelWarningIndex(Integer travelWarningIndex) {
this.travelWarningIndex = travelWarningIndex;
}

public Integer getCultural() {
return cultural;
}

public void setCultural(Integer cultural) {
this.cultural = cultural;
}

public Integer getSightseeing() {
return sightseeing;
}

public void setSightseeing(Integer sightseeing) {
this.sightseeing = sightseeing;
}

public Integer getNightlife() {
return nightlife;
}

public void setNightlife(Integer nightlife) {
this.nightlife = nightlife;
}

public Integer getActivity() {
return activity;
}

public void setActivity(Integer activity) {
this.activity = activity;
}

public Integer getSports() {
return sports;
}

public void setSports(Integer sports) {
this.sports = sports;
}

public Integer getBeaches() {
return beaches;
}

public void setBeaches(Integer beaches) {
this.beaches = beaches;
}

public String getTransportationIndex() {
return transportationIndex;
}

public void setTransportationIndex(String transportationIndex) {
this.transportationIndex = transportationIndex;
}

public String getConnectivityIndex() {
return connectivityIndex;
}

public void setConnectivityIndex(String connectivityIndex) {
this.connectivityIndex = connectivityIndex;
}

public Integer getDirectFlightsPerWeekOf() {
return directFlightsPerWeekOf;
}

public void setDirectFlightsPerWeekOf(Integer directFlightsPerWeekOf) {
this.directFlightsPerWeekOf = directFlightsPerWeekOf;
}

public String getAirport() {
return airport;
}

public void setAirport(String airport) {
this.airport = airport;
}

}