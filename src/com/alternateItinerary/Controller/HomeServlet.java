package com.alternateItinerary.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alternateItinerary.Helper.SimilarityIndexCalculator;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String page = "Home";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String city1 = request.getParameter("city1");
		String city2 = request.getParameter("city2");
		
		SimilarityIndexCalculator sic = new SimilarityIndexCalculator();
		double similarityIndex = sic.calclulateSimilarityIndex(city1, city2);
		String value;
		if(similarityIndex >=8){
			value = "High";
		}
		else if(similarityIndex >=6){
			value = "Medium";
		}
		else {
			value = "Low"; 
		}
        // Sending an AJAX Response to the AJAX request received 
    	String json_city = "{ \"data\" : \"" + "Similarity Index  =  "+similarityIndex + " Value ="+ value + "\" }";
  		response.setContentType("application/json");
  		PrintWriter out = response.getWriter();
  		out.print(json_city);
  		out.flush();
  		return;

	}

}
