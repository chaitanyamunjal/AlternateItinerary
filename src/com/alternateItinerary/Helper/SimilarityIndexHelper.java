package com.alternateItinerary.Helper;

import java.net.UnknownHostException;

public class SimilarityIndexHelper {

	public  String findSimilarity(String city1) throws UnknownHostException{
		
		
		String city2[]={"Paris","London","Venice","Rome","Milan","Singapore","Dubai","Barcelona","Kuala Lumpur","Amsterdam","Bangkok","Beijing","Shanghai","Toronto","Vancouver","New York City","San Francisco","Mexico"};
		
		String[] similarCities = new String[18];
		double[] similarCitiesIndex = new double[18];
		String[] similarCitiesValue = new String[18];
		int j = 0;
		
		SimilarityIndexCalculator sic = new SimilarityIndexCalculator();
		
		double similarityIndex[] = new double[18];
		
		for(int i=0;i<18;i++){
			if(city1.equals(city2[i]))continue;
			similarityIndex[i] = sic.calclulateSimilarityIndex(city1, city2[i]);

			
			
			if(similarityIndex[i] >= 6){
				similarCities[j] = city2[i];
				similarCitiesIndex[j] = similarityIndex[i];
				if(similarityIndex[i] >= 8 ){
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
		
		
		for(int i=0;i<j;i++){
			System.out.println(" similar city "+ i +" = "+similarCities[i]+" and Similariy Index = "+similarCitiesIndex[i]);
		}

		return "hello";
	}
}
