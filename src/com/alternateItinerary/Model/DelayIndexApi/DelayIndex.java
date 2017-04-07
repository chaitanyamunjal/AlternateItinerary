package com.alternateItinerary.Model.DelayIndexApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DelayIndex {

//@SerializedName("airport")
//@Expose
//private Airport airport;
@SerializedName("rawScore")
@Expose
private Double rawScore;
@SerializedName("normalizedScore")
@Expose
private Double normalizedScore;
@SerializedName("dateStart")
@Expose
private String dateStart;
@SerializedName("dateEnd")
@Expose
private String dateEnd;
@SerializedName("flights")
@Expose
private Integer flights;
@SerializedName("observations")
@Expose
private Integer observations;
@SerializedName("canceled")
@Expose
private Integer canceled;
@SerializedName("onTime")
@Expose
private Integer onTime;
@SerializedName("delayed15")
@Expose
private Integer delayed15;
@SerializedName("delayed30")
@Expose
private Integer delayed30;
@SerializedName("delayed45")
@Expose
private Integer delayed45;
@SerializedName("delta")
@Expose
private Double delta;

//public Airport getAirport() {
//return airport;
//}
//
//public void setAirport(Airport airport) {
//this.airport = airport;
//}

public Double getRawScore() {
return rawScore;
}

public void setRawScore(Double rawScore) {
this.rawScore = rawScore;
}

public Double getNormalizedScore() {
return normalizedScore;
}

public void setNormalizedScore(Double normalizedScore) {
this.normalizedScore = normalizedScore;
}

public String getDateStart() {
return dateStart;
}

public void setDateStart(String dateStart) {
this.dateStart = dateStart;
}

public String getDateEnd() {
return dateEnd;
}

public void setDateEnd(String dateEnd) {
this.dateEnd = dateEnd;
}

public Integer getFlights() {
return flights;
}

public void setFlights(Integer flights) {
this.flights = flights;
}

public Integer getObservations() {
return observations;
}

public void setObservations(Integer observations) {
this.observations = observations;
}

public Integer getCanceled() {
return canceled;
}

public void setCanceled(Integer canceled) {
this.canceled = canceled;
}

public Integer getOnTime() {
return onTime;
}

public void setOnTime(Integer onTime) {
this.onTime = onTime;
}

public Integer getDelayed15() {
return delayed15;
}

public void setDelayed15(Integer delayed15) {
this.delayed15 = delayed15;
}

public Integer getDelayed30() {
return delayed30;
}

public void setDelayed30(Integer delayed30) {
this.delayed30 = delayed30;
}

public Integer getDelayed45() {
return delayed45;
}

public void setDelayed45(Integer delayed45) {
this.delayed45 = delayed45;
}

public Double getDelta() {
return delta;
}

public void setDelta(Double delta) {
this.delta = delta;
}

}
