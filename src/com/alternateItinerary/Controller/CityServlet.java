package com.alternateItinerary.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alternateItinerary.Helper.SimilarityIndexCalculator;
import com.google.gson.Gson;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = "City";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String city1 = request.getParameter("city1");
		
		// " SIMILARITY INDEX HELPER CLASS OBJECT TO BE CREATED HERE "
		
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

		ResponseObject ro = new ResponseObject();
		ro.setSimilarCties(similarCities);
		ro.setIndex(similarCitiesIndex);
		ro.setValue(similarCitiesValue);
  		
    	String json = new Gson().toJson(ro);
    	response.setContentType("application/json");
  		PrintWriter out = response.getWriter();
  		out.print(json);
  		out.flush();
  		return;
	}

}
