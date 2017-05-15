package com.alternateItinerary.Helper;

import java.net.UnknownHostException;

import com.alternateItinerary.RequestResponse.*;
import com.alternateItinerary.API.AdminCustomization;
import com.alternateItinerary.Helper.SimilarityIndexCalculator;

public class SimilarityIndexHelper {

	public ResponseObject findSimilarCity(String city1,String factorValue[],String checkedFactors[]) throws UnknownHostException {
		
		//int flag = 0;
		ResponseObject ro = func(city1,factorValue,checkedFactors);
		return ro;
	}
	
	
//	public ResponseObject findSimilarCity(String city1) throws UnknownHostException {
//		int flag = 1;
//		String factorValue[] = {};
//		String checkedFactors[] = {};
//		ResponseObject ro = func(flag,city1,factorValue,checkedFactors);
//		return ro;
//	}
//	
	
	public ResponseObject func(String city1,String factorValue[],String checkedFactors[]) throws UnknownHostException{
		
		String city2[]={"Paris","London","Venice","Rome","Milan","Singapore","Dubai","Barcelona","Kuala Lumpur","Amsterdam","Bangkok","Beijing","Shanghai","Toronto","Vancouver","New York City","San Francisco","Mexico"};
		
		String[] similarCities = new String[18];
		double[] similarCitiesIndex = new double[18];
		String[] similarCitiesValue = new String[18];
		int j = 0;
		
		SimilarityIndexCalculator sic = new SimilarityIndexCalculator();
		
		double similarityIndex[] = new double[18];
		
		
		// Get the threshold values from Admin Customization DB
		AdminCustomization ac = new AdminCustomization();
		AdminCustomResponse acr = ac.getAdminCustom();
		double mediumThreshold = acr.getSmt();
		double highThreshold = acr.getSht();
		
		for(int i=0;i<18;i++){
			if(city1.equals(city2[i]))continue;
			
			similarityIndex[i] = sic.calclulateSimilarityIndex2(city1, city2[i],factorValue,checkedFactors);
			
//			if(flag == 1){
//				similarityIndex[i] = sic.calclulateSimilarityIndex1(city1, city2[i]);
//			}
//			else{
//				similarityIndex[i] = sic.calclulateSimilarityIndex2(city1, city2[i],factorValue,checkedFactors);
//			}

			if(similarityIndex[i] >= mediumThreshold){
				similarCities[j] = city2[i];
				similarCitiesIndex[j] = similarityIndex[i];
				if(similarityIndex[i] >= highThreshold ){
					similarCitiesValue[j] = "high";
				}
				else{
					similarCitiesValue[j] = "medium";
				}
				j++;
			}
		}
		
		// SORTING THE similarCitiesIndex AND similarCities in Decreasing Order of Similarity Index
		for(int i=0;i<17;i++){
			int max = i;
			for(int k =i+1;k<18;k++){
				if(similarCitiesIndex[k] >  similarCitiesIndex[max]){
					max = k;
				}
			}
			if(max!=i){
				// SWAP 
				double temp1 = similarCitiesIndex[max];
				similarCitiesIndex[max] = similarCitiesIndex[i];
				similarCitiesIndex[i] = temp1;
				
				String temp2 = similarCities[max];
				similarCities[max] = similarCities[i];
				similarCities[i] = temp2;
				

				String temp3 = similarCitiesValue[max];
				similarCitiesValue[max] = similarCitiesValue[i];
				similarCitiesValue[i] = temp3;
			}
		}
		
		

		String[] similarCities2 = new String[j];
		double[] similarCitiesIndex2 = new double[j];
		String[] similarCitiesValue2 = new String[j];
		
		for(int i=0;i<j;i++){
			similarCities2[i] = similarCities[i];
			similarCitiesIndex2[i] = similarCitiesIndex[i];
			similarCitiesValue2[i] = similarCitiesValue[i];
			
			System.out.println(" similar city "+ i +" = "+similarCities[i]+" and Similariy Index = "+similarCitiesIndex[i]);
		}
		

		ResponseObject ro = new ResponseObject();
		ro.setSimilarCities(similarCities2);
		ro.setIndex(similarCitiesIndex2);
		ro.setValue(similarCitiesValue2);
		
		return ro;
	}

}
