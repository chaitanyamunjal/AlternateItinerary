package com.alternateItinerary.Model.FlightRatingApi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightRatingMain {

//@SerializedName("request")
//@Expose
//private Request request;

@SerializedName("ratings")
@Expose
private List<Rating> ratings = null;

//@SerializedName("appendix")
//@Expose
//private Appendix appendix;
//
//public Request getRequest() {
//return request;
//}
//
//public void setRequest(Request request) {
//this.request = request;
//}

public List<Rating> getRatings() {
return ratings;
}

public void setRatings(List<Rating> ratings) {
this.ratings = ratings;
}

//public Appendix getAppendix() {
//return appendix;
//}
//
//public void setAppendix(Appendix appendix) {
//this.appendix = appendix;
//}

}