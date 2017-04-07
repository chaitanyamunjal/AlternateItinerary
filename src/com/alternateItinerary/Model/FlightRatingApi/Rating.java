package com.alternateItinerary.Model.FlightRatingApi;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

@SerializedName("departureAirportFsCode")
@Expose
private String departureAirportFsCode;
@SerializedName("arrivalAirportFsCode")
@Expose
private String arrivalAirportFsCode;
@SerializedName("airlineFsCode")
@Expose
private String airlineFsCode;
@SerializedName("flightNumber")
@Expose
private String flightNumber;
@SerializedName("codeshares")
@Expose
private double codeshares;
@SerializedName("directs")
@Expose
private double directs;
@SerializedName("observations")
@Expose
private double observations;
@SerializedName("ontime")
@Expose
private double ontime;
@SerializedName("late15")
@Expose
private double late15;
@SerializedName("late30")
@Expose
private double late30;
@SerializedName("late45")
@Expose
private double late45;
@SerializedName("cancelled")
@Expose
private double cancelled;
@SerializedName("diverted")
@Expose
private double diverted;
@SerializedName("ontimePercent")
@Expose
private Double ontimePercent;
@SerializedName("delayObservations")
@Expose
private double delayObservations;
@SerializedName("delayMean")
@Expose
private double delayMean;
@SerializedName("delayStandardDeviation")
@Expose
private Double delayStandardDeviation;
@SerializedName("delayMin")
@Expose
private double delayMin;
@SerializedName("delayMax")
@Expose
private double delayMax;
@SerializedName("allOntimeCumulative")
@Expose
private double allOntimeCumulative;
@SerializedName("allOntimeStars")
@Expose
private double allOntimeStars;
@SerializedName("allDelayCumulative")
@Expose
private double allDelayCumulative;
@SerializedName("allDelayStars")
@Expose
private double allDelayStars;
@SerializedName("allStars")
@Expose
private double allStars;

public String getDepartureAirportFsCode() {
return departureAirportFsCode;
}

public void setDepartureAirportFsCode(String departureAirportFsCode) {
this.departureAirportFsCode = departureAirportFsCode;
}

public String getArrivalAirportFsCode() {
return arrivalAirportFsCode;
}

public void setArrivalAirportFsCode(String arrivalAirportFsCode) {
this.arrivalAirportFsCode = arrivalAirportFsCode;
}

public String getAirlineFsCode() {
return airlineFsCode;
}

public void setAirlineFsCode(String airlineFsCode) {
this.airlineFsCode = airlineFsCode;
}

public String getFlightNumber() {
return flightNumber;
}

public void setFlightNumber(String flightNumber) {
this.flightNumber = flightNumber;
}

public double getCodeshares() {
return codeshares;
}

public void setCodeshares(double codeshares) {
this.codeshares = codeshares;
}

public double getDirects() {
return directs;
}

public void setDirects(double directs) {
this.directs = directs;
}

public double getObservations() {
return observations;
}

public void setObservations(double observations) {
this.observations = observations;
}

public double getOntime() {
return ontime;
}

public void setOntime(double ontime) {
this.ontime = ontime;
}

public double getLate15() {
return late15;
}

public void setLate15(double late15) {
this.late15 = late15;
}

public double getLate30() {
return late30;
}

public void setLate30(double late30) {
this.late30 = late30;
}

public double getLate45() {
return late45;
}

public void setLate45(double late45) {
this.late45 = late45;
}

public double getCancelled() {
return cancelled;
}

public void setCancelled(double cancelled) {
this.cancelled = cancelled;
}

public double getDiverted() {
return diverted;
}

public void setDiverted(double diverted) {
this.diverted = diverted;
}

public double getOntimePercent() {
return ontimePercent;
}

public void setOntimePercent(Double ontimePercent) {
this.ontimePercent = ontimePercent;
}

public double getDelayObservations() {
return delayObservations;
}

public void setDelayObservations(double delayObservations) {
this.delayObservations = delayObservations;
}

public double getDelayMean() {
return delayMean;
}

public void setDelayMean(double delayMean) {
this.delayMean = delayMean;
}

public double getDelayStandardDeviation() {
return delayStandardDeviation;
}

public void setDelayStandardDeviation(Double delayStandardDeviation) {
this.delayStandardDeviation = delayStandardDeviation;
}

public double getDelayMin() {
return delayMin;
}

public void setDelayMin(double delayMin) {
this.delayMin = delayMin;
}

public double getDelayMax() {
return delayMax;
}

public void setDelayMax(double delayMax) {
this.delayMax = delayMax;
}

public double getAllOntimeCumulative() {
return allOntimeCumulative;
}

public void setAllOntimeCumulative(double allOntimeCumulative) {
this.allOntimeCumulative = allOntimeCumulative;
}

public double getAllOntimeStars() {
return allOntimeStars;
}

public void setAllOntimeStars(double allOntimeStars) {
this.allOntimeStars = allOntimeStars;
}

public double getAllDelayCumulative() {
return allDelayCumulative;
}

public void setAllDelayCumulative(double allDelayCumulative) {
this.allDelayCumulative = allDelayCumulative;
}

public double getAllDelayStars() {
return allDelayStars;
}

public void setAllDelayStars(double allDelayStars) {
this.allDelayStars = allDelayStars;
}

public double getAllStars() {
return allStars;
}

public void setAllStars(double allStars) {
this.allStars = allStars;
}

}