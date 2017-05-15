//----------------------- Similar City Page ----------------------------------//
$(document).ready(function(){

	$("#customCitySubmit").click(function(){
		
		
		if ($("#checkbox1").is(':checked')) {
			console.log("C1 -> CHECKED BRO!");
		}
		
		
		var data = {
				city1 :$("#city1").val(),
				f1 : $("#factor1").val(),
				f2 : $("#factor2").val(),
				f3 : $("#factor3").val(),
				f4 : $("#factor4").val(),
				f5 : $("#factor5").val(),
				f6 : $("#factor6").val(),
				f7 : $("#factor7").val(),
				f8 : $("#factor8").val(),
				f9 : $("#factor9").val(),
				f10 : $("#factor10").val(),
				f11: $("#factor11").val(),
				c1: $("#checkbox1").is(':checked') ? "1" : "0",
				c2: $("#checkbox2").is(':checked') ? "1" : "0",
			    c3: $("#checkbox3").is(':checked') ? "1" : "0",
				c4: $("#checkbox4").is(':checked') ? "1" : "0",
				c5: $("#checkbox5").is(':checked') ? "1" : "0",
				c6: $("#checkbox6").is(':checked') ? "1" : "0",
			    c7: $("#checkbox7").is(':checked') ? "1" : "0",
				c8: $("#checkbox8").is(':checked') ? "1" : "0",
			    c9: $("#checkbox9").is(':checked') ? "1" : "0",
				c10: $("#checkbox10").is(':checked') ? "1" : "0",
			    c11: $("#checkbox11").is(':checked') ? "1" : "0",
																						
				action:"customcity"
		};
		
		
		
		$.post("customcity", data, 
				function(response, status){                  // callback function which runs on receiving a response from the city Servlet

				var len = response.similarCities.length;
				results.innerHTML = "";
				
				var tbody =document.createElement("tbody");
				
				for(var i = 0; i < len; i++){
					
					var td1 = document.createElement("td");
					td1.innerHTML = response.similarCities[i];
					
					var td2 = document.createElement("td");
					td2.innerHTML = response.index[i];
					
					var td3 = document.createElement("td");
					td3.innerHTML = response.value[i];
					
					var tr =document.createElement("tr");
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);

					tbody.appendChild(tr);
				}
				
			
				var th1 =document.createElement("th");
				th1.innerHTML = "City";
				
				var th2 =document.createElement("th");
				th2.innerHTML = "Similarity Index";
				
				var th3 =document.createElement("th");
				th3.innerHTML = "Similarity Value";
				
				var tr1 =document.createElement("tr");
				tr1.appendChild(th1);
				tr1.appendChild(th2);
				tr1.appendChild(th3);
				
				var thead =document.createElement("thead");
				thead.setAttribute("class","thead-inverse");
				thead.appendChild(tr1);
			
				var outer =document.createElement("table");
				outer.setAttribute("class","table");
				outer.setAttribute("id","city_table");
				outer.appendChild(thead);
				outer.appendChild(tbody);

				results.appendChild(outer);
			});
			

		// Scroll Down to Display the Results
		window.scroll(0,1400);
	});
});