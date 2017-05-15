package com.alternateItinerary.RequestResponse;

public class UserCustomResponse {
	private String[] similarityFactorsValue;
	private String[] similarityFactorsChecked;
	private String[] riskFactorsValue;
	private String[] riskFactorsChecked;
	
	public String[] getSimilarityFactorsValue() {
		return similarityFactorsValue;
	}
	public void setSimilarityFactorsValue(String[] similarityFactorsValue) {
		this.similarityFactorsValue = similarityFactorsValue;
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
