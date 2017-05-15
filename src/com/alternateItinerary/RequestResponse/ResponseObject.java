package com.alternateItinerary.RequestResponse;

public class ResponseObject {

	private String[] similarCities;
	private double[] index;
	private String[] value;
	
	public String[] getValue() {
		return value;
	}

	public void setValue(String[] value) {
		this.value = value;
	}

	public double[] getIndex() {
		return index;
	}

	public void setIndex(double[] index) {
		this.index = index;
	}

	public String[] getSimilarCities() {
		return similarCities;
	}

	public void setSimilarCities(String[] similarCities) {
		this.similarCities = similarCities;
	}
}
