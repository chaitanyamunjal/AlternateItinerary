package com.alternateItinerary.Model.FactorsCustomization;

import java.util.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FactorsCustomization {

	
@SerializedName("ort")
@Expose
private String ort;

@SerializedName("drt")
@Expose
private String drt;

@SerializedName("smt")
@Expose
private String smt;

@SerializedName("sht")
@Expose
private String sht;
	
@SerializedName("name")
@Expose
private String name;
@SerializedName("username")
@Expose
private String username;
@SerializedName("email")
@Expose
private String email;
@SerializedName("pic")
@Expose
private String pic;
@SerializedName("password")
@Expose
private String password;
@SerializedName("similarityFactorsValue")
@Expose
private String[] similarityFactorsValue = null;
@SerializedName("similarityFactorsChecked")
@Expose
private String[] similarityFactorsChecked = null;
@SerializedName("riskFactorsValue")
@Expose
private String[] riskFactorsValue = null;
@SerializedName("riskFactorsChecked")
@Expose
private String[] riskFactorsChecked = null;


public String getOrt() {
return ort;
}

public void setOrt(String ort) {
this.ort = ort;
}

public String getDrt() {
return drt;
}

public void setDrt(String drt) {
this.drt = drt;
}

public String getSmt() {
return smt;
}

public void setSmt(String smt) {
this.smt = smt;
}

public String getSht() {
return sht;
}

public void setSht(String sht) {
this.sht = sht;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPic() {
return pic;
}

public void setPic(String pic) {
this.pic = pic;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String[] getSimilarityFactorsValue() {
return similarityFactorsValue;
}

public void setSimilarityFactorsValue(String[] factorValue) {
this.similarityFactorsValue = factorValue;
}

public String[] getSimilarityFactorsChecked() {
return similarityFactorsChecked;
}

public void setSimilarityFactorsChecked(String[] checkedFactors) {
this.similarityFactorsChecked = checkedFactors;
}

public String[] getRiskFactorsValue() {
return riskFactorsValue;
}

public void setRiskFactorsValue(String[] factorValue) {
this.riskFactorsValue = factorValue;
}

public String[] getRiskFactorsChecked() {
return riskFactorsChecked;
}

public void setRiskFactorsChecked(String[] checkedFactors) {
this.riskFactorsChecked = checkedFactors;
}

}