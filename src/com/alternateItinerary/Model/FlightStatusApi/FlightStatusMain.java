package com.alternateItinerary.Model.FlightStatusApi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightStatusMain {

//@SerializedName("request")
//@Expose
//private Request request;
//@SerializedName("appendix")
//@Expose
//private Appendix appendix;
@SerializedName("flightStatuses")
@Expose
private List<FlightStatus> flightStatuses = null;
//
//public Request getRequest() {
//return request;
//}
//
//public void setRequest(Request request) {
//this.request = request;
//}
//
//public Appendix getAppendix() {
//return appendix;
//}
//
//public void setAppendix(Appendix appendix) {
//this.appendix = appendix;
//}

public List<FlightStatus> getFlightStatuses() {
return flightStatuses;
}

public void setFlightStatuses(List<FlightStatus> flightStatuses) {
this.flightStatuses = flightStatuses;
}

}