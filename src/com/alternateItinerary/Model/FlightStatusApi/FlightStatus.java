package com.alternateItinerary.Model.FlightStatusApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightStatus {

@SerializedName("flightId")
@Expose
private Integer flightId;
@SerializedName("carrierFsCode")
@Expose
private String carrierFsCode;
@SerializedName("flightNumber")
@Expose
private String flightNumber;
@SerializedName("departureAirportFsCode")
@Expose
private String departureAirportFsCode;
@SerializedName("arrivalAirportFsCode")
@Expose
private String arrivalAirportFsCode;
//@SerializedName("departureDate")
//@Expose
//private DepartureDate departureDate;
//@SerializedName("arrivalDate")
//@Expose
//private ArrivalDate arrivalDate;
@SerializedName("status")
@Expose
private String status;
//@SerializedName("schedule")
//@Expose
//private Schedule schedule;
//@SerializedName("operationalTimes")
//@Expose
//private OperationalTimes operationalTimes;
//@SerializedName("flightDurations")
//@Expose
//private FlightDurations flightDurations;
//@SerializedName("airportResources")
//@Expose
//private AirportResources airportResources;
//@SerializedName("flightEquipment")
//@Expose
//private FlightEquipment flightEquipment;

public Integer getFlightId() {
return flightId;
}

public void setFlightId(Integer flightId) {
this.flightId = flightId;
}

public String getCarrierFsCode() {
return carrierFsCode;
}

public void setCarrierFsCode(String carrierFsCode) {
this.carrierFsCode = carrierFsCode;
}

public String getFlightNumber() {
return flightNumber;
}

public void setFlightNumber(String flightNumber) {
this.flightNumber = flightNumber;
}

public String getDepartureAirportFsCode() {
return departureAirportFsCode;
}

public void setDepartureAirportFsCode(String departureAirportFsCode) {
this.departureAirportFsCode = departureAirportFsCode;
}

public String getArrivalAirportFsCode() {
return arrivalAirportFsCode;
}

public void setArrivalAirportFsCode(String arrivalAirportFsCode) {
this.arrivalAirportFsCode = arrivalAirportFsCode;
}

//public DepartureDate getDepartureDate() {
//return departureDate;
//}
//
//public void setDepartureDate(DepartureDate departureDate) {
//this.departureDate = departureDate;
//}
//
//public ArrivalDate getArrivalDate() {
//return arrivalDate;
//}
//
//public void setArrivalDate(ArrivalDate arrivalDate) {
//this.arrivalDate = arrivalDate;
//}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

//public Schedule getSchedule() {
//return schedule;
//}
//
//public void setSchedule(Schedule schedule) {
//this.schedule = schedule;
//}
//
//public OperationalTimes getOperationalTimes() {
//return operationalTimes;
//}
//
//public void setOperationalTimes(OperationalTimes operationalTimes) {
//this.operationalTimes = operationalTimes;
//}
//
//public FlightDurations getFlightDurations() {
//return flightDurations;
//}
//
//public void setFlightDurations(FlightDurations flightDurations) {
//this.flightDurations = flightDurations;
//}
//
//public AirportResources getAirportResources() {
//return airportResources;
//}
//
//public void setAirportResources(AirportResources airportResources) {
//this.airportResources = airportResources;
//}
//
//public FlightEquipment getFlightEquipment() {
//return flightEquipment;
//}
//
//public void setFlightEquipment(FlightEquipment flightEquipment) {
//this.flightEquipment = flightEquipment;
//}

}