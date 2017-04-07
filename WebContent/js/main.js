// alert('loaded');

// setInterval(reloadPage, 5000);


function reloadPage() {
	console.log("ASDASD");
	// window.location.reload();
};


$(document).ready(function() {
    $('.mdb-select').material_select();
  });



$(document).ready(function(){
    
	$("#impedanceSubmit").click(function(){
    
		// Impedance Factors --->>>  creating a JS variable with JSON data to be sent as an AJAX request
		var data = {
    		directFlights :$("#directFlights").val(),
    		distance: $("#distance").val(),
    		costDifference :$("#costDifference").val(),
    		totalTravelTime : $("#totalTravelTime").val(),
    		superFastTrains :$("#superFastTrains").val(),
    		scheduleAlignment : $("#scheduleAlignment").val(),
    		action: "impedance"
    	};
		// sending a POST AJAX request to Home Servlet
    	$.post("home",data,
    		 function(data1, status){                  // callback function which runs on receiving a response from the Home Servlet
        	 $("#rfciImpedance").html(data1.data);
        });
    	
	});
	
	$("#attractionSubmit").click(function(){
    	// Attraction Factors -->> creating a JS variable with JSON data to be sent as an AJAX request
		var data = {
			PerCapitaIncome :$("#PerCapitaIncome").val(),
			Population: $("#Population").val(),
			CityType :$("#CityType").val(),
			CatchmentArea : $("#CatchmentArea").val(),
    		NicheAttributes : $("#NicheAttributes").val(),
    		action: "attraction"
    	};
		
		// sending a POST AJAX request to Home Servlet
    	$.post("home",data,
    		 function(data5, status){                  // callback function which runs on receiving a response from the Home Servlet
        	 $("#rfciAttraction").html(data5.data);
        });
    	
	});
	
	$("#googleSubmit").click(function(){
    	
    	// google maps --> creating a JS variable with JSON data to be sent as an AJAX request
		var data = {
    		from :$("#from1").val(),
    		to :$("#to1").val(),
    		action: "google"
    	};
		
		// sending a POST AJAX request to Home Servlet
    	$.post("home",data,
    		 function(data3, status){                  // callback function which runs on receiving a response from the Home Servlet
        	 $("#via").html(data3.data);
        });
    });
	
});


// Function for Login AJAX Request to Login servlet

$(document).ready(function(){

		$("#login").click(function(){
			var data = {
					username :$("#username").val(),
					password :$("#password").val()
				};
			
			// sending a POST AJAX request to Home Servlet
			$.ajax({
				url : "login",
				data: data, 
				type: "post",
				success: function(data) {
			    	window.location.href="home";
			    },
				error: function(XMLHttpRequest, textStatus, errorThrown) {	
			    	$("#invalid").html("Invalid Username or Password.");
			    }
		
			});

		});
});




//Function for SignUp AJAX Request to SignUp Servlet

$(document).ready(function(){

		$("#signup").click(function(){
			var data = {
					username :$("#username").val(),
					password :$("#password").val(),
					name :$("#name").val(),
					email :$("#email").val()
				};
			
			// sending a POST AJAX request to Home Servlet
			$.ajax({
				url : "signup",
				data: data, 
				type: "post",
				success: function(data) {
					alert('Congrats! Account created Successfully.');
			    	window.location.href="login";
			    },
				error: function(XMLHttpRequest, textStatus, errorThrown) {	
			    	$("#invalid").html("Try Again! Username already exists.");
			    }
		
			});

		});
});




//----------------------- Main Page ----------------------------------//
$(document).ready(function(){

	$('.datepicker').pickadate();
	
	$("#mainSubmit").click(function(){
		
			// getting the date from the Form and then converting it into yyyy-mm-dd format
			 d = new Date($("#date").val()),
		        month = '' + (d.getMonth() + 1),
		        day = '' + d.getDate(),
		        year = d.getFullYear();

		    if (month.length < 2) month = '0' + month;
		    if (day.length < 2) day = '0' + day;

		    var date = [year, month, day].join('-');         //  yyyy-mm-dd
		    var date1 = [year , month , day].join('/');             //  yyyy/mm/dd
		    
		    console.log(d);
		    
		//  creating a JS variable with JSON data to be sent as an AJAX request
		var data = {
			from :$("#from").val(),
			to :$("#to").val(),
			airline :$("#airline").val(),
			flightnumber :$("#flightnumber").val(),
			date : date,
			date1 : date1,
			date2 : d.toISOString(),
			month : d.getMonth(),
			action: "main"
		};
		
		// sending a POST AJAX request to Main Servlet
		$.post("main",data,
			 function(bothJson, status){                  // callback function which runs on receiving a response from the Main Servlet
			$("#response").html(bothJson.data);
			console.log(bothJson.data);
			//			for(i=0;i<10;i++){
//				$("#response"+i).html(bothJson.finalResult[i]);
//			}

		});
	});

});


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
				 function(bothJson, status){                  // callback function which runs on receiving a response from the Home Servlet
				$("#response").html(bothJson.data);

			});

		
	});
});


//----------------------- Similar City Page ----------------------------------//
$(document).ready(function(){

	$("#citySubmit").click(function(){
	
		console.log($("#city1").val());
		var data = {
				city1 :$("#city1").val(),
				action:"city"
		};
		
		$.post("city",data,
				 function(bothJson, status){                  // callback function which runs on receiving a response from the city Servlet
				
				$("#response1").html(bothJson.similarCties[0]+"   "+bothJson.index[0]+"   "+bothJson.value[0]);
				$("#response2").html(bothJson.similarCties[1]+"   "+bothJson.index[1]+"   "+bothJson.value[1]);
				$("#response3").html(bothJson.similarCties[2]+"   "+bothJson.index[2]+"   "+bothJson.value[2]);
				
			});

		
	});
});