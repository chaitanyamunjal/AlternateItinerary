package com.alternateItinerary.RequestResponse;

public class PhaseTwoResponse {

	private String alternateOrigin;
	private String alternateDestination[];
	private String alternateDestinationURL[];
	private double riskFactor[];
	private double similarityIndex[];
	private int size;
	private double alternateOriginRiskFactor;
	private String urlOrigin;
	private String urlDestination;
	
	public String getAlternateOrigin() {
		return alternateOrigin;
	}
	public void setAlternateOrigin(String alternateOrigin) {
		this.alternateOrigin = alternateOrigin;
	}
	public String[] getAlternateDestination() {
		return alternateDestination;
	}
	public void setAlternateDestination(String alternateDestination[]) {
		this.alternateDestination = alternateDestination;
	}
	public String[] getAlternateDestinationURL() {
		return alternateDestinationURL;
	}
	public void setAlternateDestinationURL(String alternateDestinationURL[]) {
		this.alternateDestinationURL = alternateDestinationURL;
	}
	public double[] getRiskFactor() {
		return riskFactor;
	}
	public void setRiskFactor(double riskFactor[]) {
		this.riskFactor = riskFactor;
	}
	public double[] getSimilarityIndex() {
		return similarityIndex;
	}
	public void setSimilarityIndex(double similarityIndex[]) {
		this.similarityIndex = similarityIndex;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public double getAlternateOriginRiskFactor() {
		return alternateOriginRiskFactor;
	}
	public void setAlternateOriginRiskFactor(double alternateOriginRiskFactor) {
		this.alternateOriginRiskFactor = alternateOriginRiskFactor;
	}
	public String getUrlOrigin() {
		return urlOrigin;
	}
	public void setUrlOrigin(String urlOrigin) {
		this.urlOrigin = urlOrigin;
	}
	public String getUrlDestination() {
		return urlDestination;
	}
	public void setUrlDestination(String urlDestination) {
		this.urlDestination = urlDestination;
	}
	
}
