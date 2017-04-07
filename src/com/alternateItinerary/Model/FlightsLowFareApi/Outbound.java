package com.alternateItinerary.Model.FlightsLowFareApi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Outbound {

@SerializedName("flights")
@Expose
private List<Flight> flights = null;

public List<Flight> getFlights() {
return flights;
}

public void setFlights(List<Flight> flights) {
this.flights = flights;
}

}