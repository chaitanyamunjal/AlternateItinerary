package com.alternateItinerary.Model.FlightsLowFareApi;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//private String terminal;
public class Destination {

@SerializedName("airport")
@Expose
private String airport;
@SerializedName("terminal")
@Expose 
private String terminal;
public String getAirport() {
return airport;
}

public void setAirport(String airport) {
this.airport = airport;
}

public String getTerminal() {
return terminal;
}

public void setTerminal(String terminal) {
this.terminal = terminal;
}

}
