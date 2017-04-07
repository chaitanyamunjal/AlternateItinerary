package com.alternateItinerary.Model.Distance24Api;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistanceMain {


@SerializedName("distance")
@Expose
private Integer distance;
@SerializedName("distances")
@Expose
private List<Integer> distances = null;


public Integer getDistance() {
return distance;
}

public void setDistance(Integer distance) {
this.distance = distance;
}

public List<Integer> getDistances() {
return distances;
}

public void setDistances(List<Integer> distances) {
this.distances = distances;
}

}