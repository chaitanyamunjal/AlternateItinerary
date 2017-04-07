package com.alternateItinerary.Model.TravelWarningApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

@SerializedName("situation")
@Expose
private Situation situation;

public Situation getSituation() {
return situation;
}

public void setSituation(Situation situation) {
this.situation = situation;
}

}