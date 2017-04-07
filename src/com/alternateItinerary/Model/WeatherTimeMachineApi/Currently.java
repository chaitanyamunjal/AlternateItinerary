package com.alternateItinerary.Model.WeatherTimeMachineApi;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currently {

@SerializedName("time")
@Expose
private Integer time;
@SerializedName("summary")
@Expose
private String summary;
@SerializedName("icon")
@Expose
private String icon;
@SerializedName("precipIntensity")
@Expose
private Double precipIntensity;
@SerializedName("precipType")
@Expose
private String precipType;
@SerializedName("temperature")
@Expose
private Double temperature;
@SerializedName("temperatureError")
@Expose
private Double temperatureError;
@SerializedName("apparentTemperature")
@Expose
private Double apparentTemperature;
@SerializedName("dewPoint")
@Expose
private Double dewPoint;
@SerializedName("dewPointError")
@Expose
private Double dewPointError;
@SerializedName("humidity")
@Expose
private Double humidity;
@SerializedName("humidityError")
@Expose
private Double humidityError;
@SerializedName("windSpeed")
@Expose
private Double windSpeed;
@SerializedName("windSpeedError")
@Expose
private Double windSpeedError;
@SerializedName("windBearing")
@Expose
private Integer windBearing;
@SerializedName("windBearingError")
@Expose
private Double windBearingError;
@SerializedName("visibility")
@Expose
private Double visibility;
@SerializedName("visibilityError")
@Expose
private Double visibilityError;
@SerializedName("cloudCover")
@Expose
private Double cloudCover;
@SerializedName("cloudCoverError")
@Expose
private Double cloudCoverError;
@SerializedName("pressure")
@Expose
private Double pressure;
@SerializedName("pressureError")
@Expose
private Double pressureError;

public Integer getTime() {
return time;
}

public void setTime(Integer time) {
this.time = time;
}

public String getSummary() {
return summary;
}

public void setSummary(String summary) {
this.summary = summary;
}

public String getIcon() {
return icon;
}

public void setIcon(String icon) {
this.icon = icon;
}

public Double getPrecipIntensity() {
return precipIntensity;
}

public void setPrecipIntensity(Double precipIntensity) {
this.precipIntensity = precipIntensity;
}

public String getPrecipType() {
return precipType;
}

public void setPrecipType(String precipType) {
this.precipType = precipType;
}

public Double getTemperature() {
return temperature;
}

public void setTemperature(Double temperature) {
this.temperature = temperature;
}

public Double getTemperatureError() {
return temperatureError;
}

public void setTemperatureError(Double temperatureError) {
this.temperatureError = temperatureError;
}

public Double getApparentTemperature() {
return apparentTemperature;
}

public void setApparentTemperature(Double apparentTemperature) {
this.apparentTemperature = apparentTemperature;
}

public Double getDewPoint() {
return dewPoint;
}

public void setDewPoint(Double dewPoint) {
this.dewPoint = dewPoint;
}

public Double getDewPointError() {
return dewPointError;
}

public void setDewPointError(Double dewPointError) {
this.dewPointError = dewPointError;
}

public Double getHumidity() {
return humidity;
}

public void setHumidity(Double humidity) {
this.humidity = humidity;
}

public Double getHumidityError() {
return humidityError;
}

public void setHumidityError(Double humidityError) {
this.humidityError = humidityError;
}

public Double getWindSpeed() {
return windSpeed;
}

public void setWindSpeed(Double windSpeed) {
this.windSpeed = windSpeed;
}

public Double getWindSpeedError() {
return windSpeedError;
}

public void setWindSpeedError(Double windSpeedError) {
this.windSpeedError = windSpeedError;
}

public Integer getWindBearing() {
return windBearing;
}

public void setWindBearing(Integer windBearing) {
this.windBearing = windBearing;
}

public Double getWindBearingError() {
return windBearingError;
}

public void setWindBearingError(Double windBearingError) {
this.windBearingError = windBearingError;
}

public Double getVisibility() {
return visibility;
}

public void setVisibility(Double visibility) {
this.visibility = visibility;
}

public Double getVisibilityError() {
return visibilityError;
}

public void setVisibilityError(Double visibilityError) {
this.visibilityError = visibilityError;
}

public Double getCloudCover() {
return cloudCover;
}

public void setCloudCover(Double cloudCover) {
this.cloudCover = cloudCover;
}

public Double getCloudCoverError() {
return cloudCoverError;
}

public void setCloudCoverError(Double cloudCoverError) {
this.cloudCoverError = cloudCoverError;
}

public Double getPressure() {
return pressure;
}

public void setPressure(Double pressure) {
this.pressure = pressure;
}

public Double getPressureError() {
return pressureError;
}

public void setPressureError(Double pressureError) {
this.pressureError = pressureError;
}

}