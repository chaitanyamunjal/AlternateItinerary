//----------------------- Similar City Page ----------------------------------//
$(document).ready(function(){

	$("#citySubmit").click(function(){
	
		console.log($("#city1").val());
		var data = {
				city1 :$("#city1").val(),
				action:"city"
		};
		
		$.post("city", data, 
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

		
	});
});