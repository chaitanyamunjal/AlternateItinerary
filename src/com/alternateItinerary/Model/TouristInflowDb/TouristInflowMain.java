package com.alternateItinerary.Model.TouristInflowDb;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TouristInflowMain {

@SerializedName("country")
@Expose
private String country;
@SerializedName("tourists")
@Expose
private List<Tourist> tourists = null;

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public List<Tourist> getTourists() {
return tourists;
}

public void setTourists(List<Tourist> tourists) {
this.tourists = tourists;
}

}
