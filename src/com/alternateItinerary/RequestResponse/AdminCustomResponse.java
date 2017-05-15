package com.alternateItinerary.RequestResponse;

public class AdminCustomResponse {

	private double ort;
	private double drt;
	private double smt;
	private double sht;
	private String[] similarityFactorsValue;
	private String[] similarityFactorsChecked;
	private String[] riskFactorsValue;
	private String[] riskFactorsChecked;
	
	public double getOrt() {
		return ort;
	}
	public void setOrt(double ort) {
		this.ort = ort;
	}
	public double getDrt() {
		return drt;
	}
	public void setDrt(double drt) {
		this.drt = drt;
	}
	public double getSmt() {
		return smt;
	}
	public void setSmt(double smt) {
		this.smt = smt;
	}
	public double getSht() {
		return sht;
	}
	public void setSht(double sht) {
		this.sht = sht;
	}
	public String[] getSimilarityFactorsValue() {
		return similarityFactorsValue;
	}
	public void setSimilarityFactorsValue(String[] similarityFactorsValue1) {
		this.similarityFactorsValue = similarityFactorsValue1;
	}
	public String[] getSimilarityFactorsChecked() {
		return similarityFactorsChecked;
	}
	public void setSimilarityFactorsChecked(String[] similarityFactorsChecked) {
		this.similarityFactorsChecked = similarityFactorsChecked;
	}
	public String[] getRiskFactorsValue() {
		return riskFactorsValue;
	}
	public void setRiskFactorsValue(String[] riskFactorsValue) {
		this.riskFactorsValue = riskFactorsValue;
	}
	public String[] getRiskFactorsChecked() {
		return riskFactorsChecked;
	}
	public void setRiskFactorsChecked(String[] riskFactorsChecked) {
		this.riskFactorsChecked = riskFactorsChecked;
	}
	
}
