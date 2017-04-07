package com.alternateItinerary.Model.PeekSeasonDb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

@SerializedName("city")
@Expose
private String city;
@SerializedName("peekStart")
@Expose
private Integer peekStart;
@SerializedName("peekEnd")
@Expose
private Integer peekEnd;

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public Integer getPeekStart() {
return peekStart;
}

public void setPeekStart(Integer peekStart) {
this.peekStart = peekStart;
}

public Integer getPeekEnd() {
return peekEnd;
}

public void setPeekEnd(Integer peekEnd) {
this.peekEnd = peekEnd;
}

}