package com.alternateItinerary.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alternateItinerary.Helper.SimilarityIndexHelper;
import com.alternateItinerary.RequestResponse.ResponseObject;
import com.google.gson.Gson;
@WebServlet("/CustomRiskServlet")
public class CustomRiskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomRiskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = "CustomRisk";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String city1 = request.getParameter("city1");
		String[] factorValue = new String[11];
		String[] checkedFactors = new String[11];
		
		int j=0;
		for(int i=0;i<11;i++){
			j = i+1;
			factorValue[i] = request.getParameter("f"+j);
			checkedFactors[i] = request.getParameter("c"+j);
			System.out.println(factorValue[i]+"  ====  "+checkedFactors[i]);
		}

		
		System.out.println("city got = "+city1);
		
		SimilarityIndexHelper helper = new SimilarityIndexHelper();
		ResponseObject ro = helper.findSimilarCity(city1,factorValue,checkedFactors);
  		
		String json = new Gson().toJson(ro);
    	response.setContentType("application/json");
  		PrintWriter out = response.getWriter();
  		out.print(json);
  		out.flush();
  		return;

	}

}
