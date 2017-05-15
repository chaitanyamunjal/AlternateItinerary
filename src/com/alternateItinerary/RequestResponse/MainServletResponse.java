package com.alternateItinerary.RequestResponse;

public class MainServletResponse {

	private double fromRiskFactor;
	private double toRiskFactor;
	private String alternateOrigin;
	private double alternateOriginRiskFactor;
	
	private String alternateDestination[];
	private String alternateDestinationUrl[];
	private double alternateDestinationRiskFactor[];
	private double alternateDestinationSimilarityIndex[];
	private double size;
	private String urlDestination;
	private String urlOrigin;
	private double riskThreshold1;
	private double riskThreshold2;
	
	private String riskFactorsValue[];
	private	String riskFactorsChecked[];
	private	String similarityFactorsValue[];
	private	String similarityFactorsChecked[];
	
	
	public double getFromRiskFactor() {
		return fromRiskFactor;
	}
	public void setFromRiskFactor(double fromRiskFactor) {
		this.fromRiskFactor = fromRiskFactor;
	}
	public double getToRiskFactor() {
		return toRiskFactor;
	}
	public void setToRiskFactor(double toRiskFactor) {
		this.toRiskFactor = toRiskFactor;
	}
	public String getAlternateOrigin() {
		return alternateOrigin;
	}
	public void setAlternateOrigin(String alternateOrigin) {
		this.alternateOrigin = alternateOrigin;
	}
	public double[] getAlternateDestinationSimilarityIndex() {
		return alternateDestinationSimilarityIndex;
	}
	public void setAlternateDestinationSimilarityIndex(
			double alternateDestinationSimilarityIndex[]) {
		this.alternateDestinationSimilarityIndex = alternateDestinationSimilarityIndex;
	}
	public double[] getAlternateDestinationRiskFactor() {
		return alternateDestinationRiskFactor;
	}
	public void setAlternateDestinationRiskFactor(
			double alternateDestinationRiskFactor[]) {
		this.alternateDestinationRiskFactor = alternateDestinationRiskFactor;
	}
	public String[] getAlternateDestinationUrl() {
		return alternateDestinationUrl;
	}
	public void setAlternateDestinationUrl(String alternateDestinationUrl[]) {
		this.alternateDestinationUrl = alternateDestinationUrl;
	}
	public String[] getAlternateDestination() {
		return alternateDestination;
	}
	public void setAlternateDestination(String alternateDestination[]) {
		this.alternateDestination = alternateDestination;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getAlternateOriginRiskFactor() {
		return alternateOriginRiskFactor;
	}
	public void setAlternateOriginRiskFactor(double alternateOriginRiskFactor) {
		this.alternateOriginRiskFactor = alternateOriginRiskFactor;
	}
	public String getUrlDestination() {
		return urlDestination;
	}
	public void setUrlDestination(String urlDestination) {
		this.urlDestination = urlDestination;
	}
	public String getUrlOrigin() {
		return urlOrigin;
	}
	public void setUrlOrigin(String urlOrigin) {
		this.urlOrigin = urlOrigin;
	}
	public double getRiskThreshold1() {
		return riskThreshold1;
	}
	public void setRiskThreshold1(double riskThreshold1) {
		this.riskThreshold1 = riskThreshold1;
	}
	public double getRiskThreshold2() {
		return riskThreshold2;
	}
	public void setRiskThreshold2(double riskThreshold2) {
		this.riskThreshold2 = riskThreshold2;
	}
	public String[] getRiskFactorsValue() {
		return riskFactorsValue;
	}
	public void setRiskFactorsValue(String riskFactorsValue[]) {
		this.riskFactorsValue = riskFactorsValue;
	}
	public String[] getRiskFactorsChecked() {
		return riskFactorsChecked;
	}
	public void setRiskFactorsChecked(String riskFactorsChecked[]) {
		this.riskFactorsChecked = riskFactorsChecked;
	}
	public String[] getSimilarityFactorsValue() {
		return similarityFactorsValue;
	}
	public void setSimilarityFactorsValue(String similarityFactorsValue[]) {
		this.similarityFactorsValue = similarityFactorsValue;
	}
	public String[] getSimilarityFactorsChecked() {
		return similarityFactorsChecked;
	}
	public void setSimilarityFactorsChecked(String similarityFactorsChecked[]) {
		this.similarityFactorsChecked = similarityFactorsChecked;
	}
}
