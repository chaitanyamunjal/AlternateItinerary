package com.alternateItinerary.Model.TouristInflowDb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Monthwise {

@SerializedName("month")
@Expose
private String month;
@SerializedName("count")
@Expose
private Integer count;

public String getMonth() {
return month;
}

public void setMonth(String month) {
this.month = month;
}

public Integer getCount() {
return count;
}

public void setCount(Integer count) {
this.count = count;
}

}