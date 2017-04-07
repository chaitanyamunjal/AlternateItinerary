package com.alternateItinerary.Model.TouristInflowDb;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tourist {

@SerializedName("year")
@Expose
private String year;
@SerializedName("monthwise")
@Expose
private List<Monthwise> monthwise = null;
@SerializedName("total")
@Expose
private Integer total;

public String getYear() {
return year;
}

public void setYear(String year) {
this.year = year;
}

public List<Monthwise> getMonthwise() {
return monthwise;
}

public void setMonthwise(List<Monthwise> monthwise) {
this.monthwise = monthwise;
}

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

}