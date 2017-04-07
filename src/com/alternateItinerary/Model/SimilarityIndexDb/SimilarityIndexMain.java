package com.alternateItinerary.Model.SimilarityIndexDb;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarityIndexMain {

@SerializedName("S.No")
@Expose
private Integer sNo;
@SerializedName("City")
@Expose
private String city;
@SerializedName("Tourist Attraction Index ( FTA/LAE )")
@Expose
private String touristAttractionIndexFTALAE;
@SerializedName("Foreign Tourist Arrival - FTA (#Of)")
@Expose
private Integer foreignTouristArrivalFTAOf;
@SerializedName("Local Average Expense - LAE (USD)")
@Expose
private Integer localAverageExpenseLAEUSD;
@SerializedName("Flight Duration (hrs)")
@Expose
private Double flightDurationHrs;
@SerializedName("VISA")
@Expose
private String vISA;
@SerializedName("Pollution level ( 0 to 300 ) Scale")
@Expose
private Integer pollutionLevel0To300Scale;
@SerializedName("Peak seasons")
@Expose
private String peakSeasons;
@SerializedName("Flight Price(INR)")
@Expose
private Integer flightPriceINR;
@SerializedName("Travel Distance ( km )")
@Expose
private Integer travelDistanceKm;
@SerializedName("Travel Warning Index ( 0 to 5 ) Scale")
@Expose
private Integer travelWarningIndex0To5Scale;
@SerializedName("City Category")
@Expose
private String cityCategory;
@SerializedName("Cultural (#Of)")
@Expose
private Integer culturalOf;
@SerializedName("Sightseeing(#Of)")
@Expose
private Integer sightseeingOf;
@SerializedName("Nightlife(#Of)")
@Expose
private Integer nightlifeOf;
@SerializedName("Activity(#Of)")
@Expose
private Integer activityOf;
@SerializedName("Sports(#Of)")
@Expose
private Integer sportsOf;
@SerializedName("Beaches(#Of)")
@Expose
private Integer beachesOf;
@SerializedName("Transportation Index")
@Expose
private String transportationIndex;
@SerializedName("Uber")
@Expose
private String uber;
@SerializedName("Metro")
@Expose
private String metro;
@SerializedName("Bus")
@Expose
private String bus;
@SerializedName("Trams")
@Expose
private String trams;
@SerializedName("Connectivity Index")
@Expose
private String connectivityIndex;
@SerializedName("Direct Flights per Week (#Of)")
@Expose
private Integer directFlightsPerWeekOf;
@SerializedName("Airport")
@Expose
private String airport;

public Integer getSNo() {
return sNo;
}

public void setSNo(Integer sNo) {
this.sNo = sNo;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getTouristAttractionIndexFTALAE() {
return touristAttractionIndexFTALAE;
}

public void setTouristAttractionIndexFTALAE(String touristAttractionIndexFTALAE) {
this.touristAttractionIndexFTALAE = touristAttractionIndexFTALAE;
}

public Integer getForeignTouristArrivalFTAOf() {
return foreignTouristArrivalFTAOf;
}

public void setForeignTouristArrivalFTAOf(Integer foreignTouristArrivalFTAOf) {
this.foreignTouristArrivalFTAOf = foreignTouristArrivalFTAOf;
}

public Integer getLocalAverageExpenseLAEUSD() {
return localAverageExpenseLAEUSD;
}

public void setLocalAverageExpenseLAEUSD(Integer localAverageExpenseLAEUSD) {
this.localAverageExpenseLAEUSD = localAverageExpenseLAEUSD;
}

public Double getFlightDurationHrs() {
return flightDurationHrs;
}

public void setFlightDurationHrs(Double flightDurationHrs) {
this.flightDurationHrs = flightDurationHrs;
}

public String getVISA() {
return vISA;
}

public void setVISA(String vISA) {
this.vISA = vISA;
}

public Integer getPollutionLevel0To300Scale() {
return pollutionLevel0To300Scale;
}

public void setPollutionLevel0To300Scale(Integer pollutionLevel0To300Scale) {
this.pollutionLevel0To300Scale = pollutionLevel0To300Scale;
}

public String getPeakSeasons() {
return peakSeasons;
}

public void setPeakSeasons(String peakSeasons) {
this.peakSeasons = peakSeasons;
}

public Integer getFlightPriceINR() {
return flightPriceINR;
}

public void setFlightPriceINR(Integer flightPriceINR) {
this.flightPriceINR = flightPriceINR;
}

public Integer getTravelDistanceKm() {
return travelDistanceKm;
}

public void setTravelDistanceKm(Integer travelDistanceKm) {
this.travelDistanceKm = travelDistanceKm;
}

public Integer getTravelWarningIndex0To5Scale() {
return travelWarningIndex0To5Scale;
}

public void setTravelWarningIndex0To5Scale(Integer travelWarningIndex0To5Scale) {
this.travelWarningIndex0To5Scale = travelWarningIndex0To5Scale;
}

public String getCityCategory() {
return cityCategory;
}

public void setCityCategory(String cityCategory) {
this.cityCategory = cityCategory;
}

public Integer getCulturalOf() {
return culturalOf;
}

public void setCulturalOf(Integer culturalOf) {
this.culturalOf = culturalOf;
}

public Integer getSightseeingOf() {
return sightseeingOf;
}

public void setSightseeingOf(Integer sightseeingOf) {
this.sightseeingOf = sightseeingOf;
}

public Integer getNightlifeOf() {
return nightlifeOf;
}

public void setNightlifeOf(Integer nightlifeOf) {
this.nightlifeOf = nightlifeOf;
}

public Integer getActivityOf() {
return activityOf;
}

public void setActivityOf(Integer activityOf) {
this.activityOf = activityOf;
}

public Integer getSportsOf() {
return sportsOf;
}

public void setSportsOf(Integer sportsOf) {
this.sportsOf = sportsOf;
}

public Integer getBeachesOf() {
return beachesOf;
}

public void setBeachesOf(Integer beachesOf) {
this.beachesOf = beachesOf;
}

public String getTransportationIndex() {
return transportationIndex;
}

public void setTransportationIndex(String transportationIndex) {
this.transportationIndex = transportationIndex;
}

public String getUber() {
return uber;
}

public void setUber(String uber) {
this.uber = uber;
}

public String getMetro() {
return metro;
}

public void setMetro(String metro) {
this.metro = metro;
}

public String getBus() {
return bus;
}

public void setBus(String bus) {
this.bus = bus;
}

public String getTrams() {
return trams;
}

public void setTrams(String trams) {
this.trams = trams;
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