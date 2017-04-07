package com.alternateItinerary.Model.WeatherTimeMachineApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherParams {

@SerializedName("latitude")
@Expose
private Double latitude;
@SerializedName("longitude")
@Expose
private Double longitude;
@SerializedName("timezone")
@Expose
private String timezone;
@SerializedName("offset")
@Expose
private Double offset;
public Double getOffset() {
	return offset;
}

public void setOffset(Double offset) {
	this.offset = offset;
}

@SerializedName("currently")
@Expose
private Currently currently;

public Double getLatitude() {
return latitude;
}

public void setLatitude(Double latitude) {
this.latitude = latitude;
}

public Double getLongitude() {
return longitude;
}

public void setLongitude(Double longitude) {
this.longitude = longitude;
}

public String getTimezone() {
return timezone;
}

public void setTimezone(String timezone) {
this.timezone = timezone;
}



public Currently getCurrently() {
return currently;
}

public void setCurrently(Currently currently) {
this.currently = currently;
}

}