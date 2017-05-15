//----------------------- Home Page ----------------------------------//
$(document).ready(function(){

	$("#homeSubmit").click(function(){
	
		console.log($("#city1").val());
		var data = {
				city1 :$("#city1").val(),
				city2 :$("#city2").val(),
				action:"home"
		};
		
		$.post("home",data,
				 function(response, status){                  // callback function which runs on receiving a response from the Home Servlet

				console.log(response);
				results.innerHTML = "";
			
				var td1 = document.createElement("td");
				td1.innerHTML = $("#city1").val();
				
				var td2 = document.createElement("td");
				td2.innerHTML = $("#city2").val() ;
				
				var td3 = document.createElement("td");
				td3.innerHTML = response.similarityIndex;
				
				var td4 = document.createElement("td");
				td4.innerHTML = response.value;
				
				var tr =document.createElement("tr");
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				
				var tbody =document.createElement("tbody");
				tbody.appendChild(tr);
			
				var th1 =document.createElement("th");
				th1.innerHTML = "First City";
				
				var th2 =document.createElement("th");
				th2.innerHTML = "Second City";
				
				var th3 =document.createElement("th");
				th3.innerHTML = "Similarity Index";
				
				var th4 =document.createElement("th");
				th4.innerHTML = "Similarity Value";
				
				var tr1 =document.createElement("tr");
				tr1.appendChild(th1);
				tr1.appendChild(th2);
				tr1.appendChild(th3);
				tr1.appendChild(th4);
				
				var thead =document.createElement("thead");
				thead.setAttribute("class","thead-inverse");
				thead.appendChild(tr1);
			
				var outer =document.createElement("table");
				outer.setAttribute("class","table");
				outer.appendChild(thead);
				outer.appendChild(tbody);
	
				results.appendChild(outer);

			});

		
	});
});
