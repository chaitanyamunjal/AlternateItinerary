package com.alternateItinerary.Controller;

import java.util.List;

public class ResponseObject {

	private String[] similarCties;
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

	public String[] getSimilarCties() {
		return similarCties;
	}

	public void setSimilarCties(String[] similarCities) {
		this.similarCties = similarCities;
	}
}
