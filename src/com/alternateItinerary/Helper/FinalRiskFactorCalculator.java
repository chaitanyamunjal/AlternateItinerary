package com.alternateItinerary.Helper;

public class FinalRiskFactorCalculator {

	public double calclulateOriginRiskFactor(String riskFactorsChecked[],String riskFactorsValue[],double originRiskFactors[]){
		
		double sum = 0;
		double total = 0;
		System.out.println("Factors used in calculation are :-");
		
		for(int i=0;i<riskFactorsChecked.length;i++){
			if(i!=4 && i!=5 && riskFactorsChecked[i].equals("1")){
				
				
				if(riskFactorsValue[i].equals("High")){
					sum = sum + 3*originRiskFactors[i];
					total = total + 3;

					System.out.println(" Origin value of i = "+i+" and weightage = High // and value of risk Factor = "+originRiskFactors[i]+" *3");
				}
				else if(riskFactorsValue[i].equals("Medium")){
					sum = sum + 2*originRiskFactors[i];
					total = total + 2;
					System.out.println(" Origin value of i = "+i+" and weightage = medium // and value of risk Factor = "+originRiskFactors[i] +" *2");
				}
				else{
					sum = sum + originRiskFactors[i];
					total = total + 1;	
					System.out.println(" Origin value of i = "+i+" and weightage = low // and value of risk Factor = "+originRiskFactors[i]+" *1");
				}
				
				System.out.println(" Origin value of i = "+i);
			}
		}

		System.out.println(" Origin value of sum and total  = "+sum+"  &  "+total);
		
		double RiskFactor = (sum/total)*10;
	
		// Round off the Risk Factors to 2 Decimal Places 
		RiskFactor = (double) Math.round(RiskFactor * 100) / 100;;
				
		return RiskFactor;
	}
	
	public double calclulateDestinationRiskFactor(String riskFactorsChecked[],String riskFactorsValue[],double destinationRiskFactors[]){

				double sum = 0;
				double total = 0;
				for(int i=0;i<riskFactorsChecked.length;i++){
					if(riskFactorsChecked[i].equals("1")){
						
						if(riskFactorsValue[i].equals("High")){
							sum = sum + 3*destinationRiskFactors[i];
							total = total + 3;
							System.out.println(" Destination value of i = "+i+" and weightage = High // and value of risk Factor = "+destinationRiskFactors[i]+" *3");
						}
						else if(riskFactorsValue[i].equals("Medium")){
							sum = sum + 2*destinationRiskFactors[i];
							total = total + 2;
							System.out.println(" Destination value of i = "+i+" and weightage = medium // and value of risk Factor = "+destinationRiskFactors[i] +" *2");
						}
						else{
							sum = sum + destinationRiskFactors[i];
							total = total + 1;	
							System.out.println(" Destination value of i = "+i+" and weightage = low // and value of risk Factor = "+destinationRiskFactors[i]+" *1");
							
						}

					}
				}

				System.out.println(" Destination value of sum and total  = "+sum+"  &  "+total);
				double RiskFactor = (sum/total)*10;
				
				// Round off the Risk Factors to 2 Decimal Places 
				RiskFactor = (double) Math.round(RiskFactor * 100) / 100;
				 
		return RiskFactor;
	}
}
