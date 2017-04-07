package com.alternateItinerary.Model.TravelWarningApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TravelWarningMain {

@SerializedName("data")
@Expose
private Data data;

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

}