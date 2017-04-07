package com.alternateItinerary.Model.TravelWarningApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Situation {

@SerializedName("sources")
@Expose
private Integer sources;
@SerializedName("rating")
@Expose
private String rating;
@SerializedName("updated")
@Expose
private String updated;

public Integer getSources() {
return sources;
}

public void setSources(Integer sources) {
this.sources = sources;
}

public String getRating() {
return rating;
}

public void setRating(String rating) {
this.rating = rating;
}

public String getUpdated() {
return updated;
}

public void setUpdated(String updated) {
this.updated = updated;
}

}