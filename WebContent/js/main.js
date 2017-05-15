

//----------------------- Main Page ----------------------------------//


    $("#details").click(function(){
    	
    	var data = {
    			
    			action: "details"
    		};
    	
    	$.post("main",data).done(
    			function(response, status){
    				
    		modalBody.innerHTML = "";
    		console.log("response test = "+response.similarityFactorsChecked.length);
        	
    		// Risk Table Head
    		var th1 =document.createElement("th");
    		th1.innerHTML = "Risk Factors";
    		
    		var th2 =document.createElement("th");
    		th2.innerHTML = "Weightage";
    		
    		var tr1 =document.createElement("tr");
    		tr1.appendChild(th1);
    		tr1.appendChild(th2);
    		
    		var thead1 =document.createElement("thead");
    		thead1.setAttribute("class","thead-inverse");
    		thead1.appendChild(tr1);
    		
    		// Make the array containing the names of the Risk and similarity factors 
    		var risk = ["Weather","Airport Delay","Flight Status","Flight Status History","Peek Season","Tourist Inflow","Flight Rating","Travel Warning Index"];
    		var similarity = ["Tourist Attraction Index	","Flight Duration","Visa","Pollution Level","Peek Season","Flight Price","Travel Distance","Travel Warning Index","City Category","Transportation Index","Connectivity Index"];
    		
    		// Risk Table Body
    		var tbody1 =document.createElement("tbody");
    		
    		for(var i=0;i<response.riskFactorsChecked.length;i++){
    			
    			if(response.riskFactorsChecked[i] == "1"){
    				
    				var td1 = document.createElement("td");
    				td1.innerHTML = risk[i];
    				
    				var td2 = document.createElement("td");
    				td2.innerHTML = response.riskFactorsValue[i];
    				
    				var tr =document.createElement("tr");
    				tr.appendChild(td1);
    				tr.appendChild(td2);
    		
    				tbody1.appendChild(tr);
    		
    			}
    				
    		}
    		
    		// Add head and body to the Risk Table
    		var outer1 =document.createElement("table");
    		outer1.setAttribute("class","table");
    		outer1.setAttribute("id","riskTable");
    		outer1.appendChild(thead1);
    		outer1.appendChild(tbody1);
    		
    		// Table Head of Similarity Table
    		var th3 =document.createElement("th");
    		th3.innerHTML = "Similarity Factors";
    		
    		var th4 =document.createElement("th");
    		th4.innerHTML = "Weightage";
    		
    		var tr2 =document.createElement("tr");
    		tr2.appendChild(th3);
    		tr2.appendChild(th4);
    		
    		var thead2 =document.createElement("thead");
    		thead2.setAttribute("class","thead-inverse");
    		thead2.appendChild(tr2);
    		
    		// Similarity Table Body
    		var tbody2 =document.createElement("tbody");

    		for(var i=0;i<response.similarityFactorsChecked.length;i++){
    			
    			if(response.similarityFactorsChecked[i] == "1"){
    				
    				var td1 = document.createElement("td");
    				td1.innerHTML =  similarity[i];
    				
    				var td2 = document.createElement("td");
    				td2.innerHTML = response.similarityFactorsValue[i];
    				
    				var tr =document.createElement("tr");
    				tr.appendChild(td1);
    				tr.appendChild(td2);
    		
    				tbody2.appendChild(tr);
    		
    			}
    				
    		}
    		
    		
    		// Add head and body to the Similarity Table
    		var outer2 =document.createElement("table");
    		outer2.setAttribute("class","table");
    		outer2.setAttribute("id","similarityTable");
    		outer2.appendChild(thead2);
    		outer2.appendChild(tbody2);
    		
    		// Add the Threshold values to the top
    		var upper =document.createElement("p");
    		upper.innerHTML = "Origin Risk Threshold = "+response.riskThreshold1 +" <br> Destination Risk Threshold = "+response.riskThreshold2;
    		
    		// ADD Threshold Values and Risk table and Similarity Table to the MODAL-BODY
    		modalBody.appendChild(upper);
    		modalBody.appendChild(outer1);
    		modalBody.appendChild(outer2);

    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    			
    		}).fail(function(response){
			alert('Some unexpected Error has occured. Please try again later !!');
		});
    });




function makeSpeedo(el, valueOfMeter) {
	
		$(el).gauge({
	        values: {
	            0 : '0',
	            30: '3',
	            60: '6',
	            100: '10'
	        },
	        colors: {
	            0 : '#5CD16E',
				30: '#F4D852',
	            60: '#EA484C'
	        },
	        angles: [
	            180,
	            360
	        ],
	        lineWidth: 3,
	        arrowWidth: 3,
	        arrowColor: '#2DAFE4',
	        inset:true,
	        value : valueOfMeter*10
	       
	    });
		
	};

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
		
		
		// Showing the Progress Bar
		$("#progressBar").show();
		
		// sending a POST AJAX request to Main Servlet
		$.post("main",data).done(
			function(response, status){                  // callback function which runs on receiving a response from the Main Servlet
			
			// Removing the Previous Response when we Reload the Page
			var len = response.size;
			results1.innerHTML = "";
			results2.innerHTML = "";
			cardHolder.innerHTML = "";
			bar.innerHTML= "";
			barValues.innerHTML="";
			
			
			
			// Hiding the Progress Bar
			$("#progressBar").hide();
			
			console.log("length of response is "+len);
			
			// BAR 
			//barDisplay();
			
			// Card-1
			card1(response);
			
			// Card-2
			card2(response);
			
			// Card Holder - Alternate Destination Part
			cardholder(response,len);
			
			
			// Scroll Down to Display the Results
			window.scroll(0,1000);
			
			
		}).fail(function(response){
			console.log("some unexpected error has occured!!!");
			// Hiding the Progress Bar
			$("#progressBar").hide();
			alert('Some unexpected Error has occured. Please try again later !!');
			});
	});

});




// CALLED FUNCTION'S

function barDisplay(){
	
	var div1 = document.createElement("div");
	div1.setAttribute("id","div1");
	div1.setAttribute("class","col-md-2");
	
	var div2 =document.createElement("div");
	div2.setAttribute("id","div2");
	div2.setAttribute("class","col-md-2");
	
	var div3 =document.createElement("div");
	div3.setAttribute("id","div3");
	div3.setAttribute("class","col-md-2");
	
	bar.appendChild(div1);
	bar.appendChild(div2);
	bar.appendChild(div3);
	
	var l = document.createElement("h6");
	l.setAttribute("id","l");
	l.setAttribute("class","col-md-2");
	l.innerHTML = "Low";
	
	var m = document.createElement("h6");
	m.setAttribute("id","m");
	m.setAttribute("class","col-md-2");
	m.innerHTML = "Medium";
	
	var h = document.createElement("h6");
	h.setAttribute("id","h");
	h.setAttribute("class","col-md-2");
	h.innerHTML = "High";
	
	barValues.appendChild(l);
	barValues.appendChild(m);
	barValues.appendChild(h);
	
};


function card1(response){
	// Card - 1
	
	var meter1 = document.createElement("div");
	meter1.setAttribute("class", "gauge2 demo2");
	meter1.setAttribute("id", "m1");
	
	
//	var meter1 = document.createElement("meter");
//meter1.setAttribute("value",response.fromRiskFactor );
//	meter1.setAttribute("min",0);
//	meter1.setAttribute("max",10);
//	if(response.fromRiskFactor <= 3){
//		meter1.setAttribute("class","low");
//	}
//	else if(response.fromRiskFactor <=6){
//		meter1.setAttribute("class","medium");					
//	}
//	else{
//		meter1.setAttribute("class","high");
//	}

	
	var meter2 = document.createElement("div");
	meter2.setAttribute("class", "gauge2 demo2");
	meter2.setAttribute("id", "m2");
	
//	
//	var meter2 = document.createElement("meter");
//	meter2.setAttribute("value",response.alternateOriginRiskFactor );
//	meter2.setAttribute("min",0);
//	meter2.setAttribute("max",10);
//	if(response.alternateOriginRiskFactor <= 3){
//		meter2.setAttribute("class","low");
//	}
//	else if(response.alternateOriginRiskFactor <=6){
//		meter2.setAttribute("class","medium");					
//	}
//	else{
//		meter2.setAttribute("class","high");
//	}

	var hr = document.createElement("hr");
	var origin = document.createElement("h3");
	origin.innerHTML = $("#from").val();
	
	var originRiskFactor = document.createElement("p");
	originRiskFactor.innerHTML = " Risk Factor of "+ $("#from").val()+" is "+response.fromRiskFactor+"      ";
	
	var alternateOrigin =document.createElement("p");
	var alternateOriginRiskFactor = document.createElement("p");
	var flag = 0;
	var threshold1 = response.riskThreshold1;
	
	// Check - If alternate Origin is different from Origin or not
	if( response.fromRiskFactor > threshold1 && response.alternateOrigin != $("#from").val()  )
	{
		alternateOrigin.innerHTML = " Alternate origin found : "+ response.alternateOrigin;
		alternateOriginRiskFactor.innerHTML = " Risk Factor of "+ response.alternateOrigin +" is "+ response.alternateOriginRiskFactor+"      ";
		flag = 1;
	}
	else if(response.fromRiskFactor > threshold1){  
		alternateOrigin.innerHTML = " It is Not Safe to travel from "+$("#from").val()+" Airport!";
	}
	else
	{
		alternateOrigin.innerHTML = " It is safe to travel from "+$("#from").val()+" Airport!";
	}
	
	var img1 = document.createElement("img");
	img1.setAttribute("class","img-fluid");
	img1.setAttribute("src",response.urlOrigin);
	
	var imageInner1 = document.createElement("div");
	imageInner1.setAttribute("class","view overlay hm-white-slight");
	imageInner1.appendChild(img1);
	
	var image1 = document.createElement("div");
	image1.setAttribute("class","card-up");
	image1.appendChild(imageInner1);
	
	var hr1 = document.createElement("hr");
	var cardContent1 =document.createElement("div");
	cardContent1.setAttribute("class","card-block");
	cardContent1.appendChild(origin);
	cardContent1.appendChild(hr1);
	cardContent1.appendChild(meter1);
	cardContent1.appendChild(originRiskFactor);
	cardContent1.appendChild(alternateOrigin);
	if(flag==1){
		cardContent1.appendChild(meter2);
	}
	cardContent1.appendChild(alternateOriginRiskFactor);
	
	var inner1 =document.createElement("div");
	inner1.setAttribute("class","face front card");
	inner1.appendChild(image1);
	inner1.appendChild(cardContent1);
	
	var outer1 =document.createElement("div");
	outer1.setAttribute("class","card-wrapper");
	outer1.setAttribute("id","outer1");
	outer1.appendChild(inner1);
	
	results1.appendChild(outer1);
	makeSpeedo(meter1, response.fromRiskFactor );
	makeSpeedo(meter2, response.alternateOriginRiskFactor);
};

function card2(response){
	//Card - 2
	var hr = document.createElement("hr");
	
	var meter3 = document.createElement("div");
	meter3.setAttribute("class", "gauge2 demo2");
	meter3.setAttribute("id", "m3");
	
//	var meter3 = document.createElement("meter");
//	meter3.setAttribute("value",response.toRiskFactor );
//	meter3.setAttribute("min",0);
//	meter3.setAttribute("max",10);
//	if(response.toRiskFactor <= 3){
//		meter3.setAttribute("class","low");
//	}
//	else if(response.toRiskFactor <=6){
//		meter3.setAttribute("class","medium");					
//	}
//	else{
//		meter3.setAttribute("class","high");
//	}

	var destination =document.createElement("h3");
	destination.innerHTML = $("#to").val();
	
	var destinationRiskFactor =document.createElement("p");
	destinationRiskFactor.innerHTML = "Risk Factor to travel to "+ $("#to").val() +" is : " + response.toRiskFactor+"  ";
	destinationRiskFactor.appendChild(meter3);
	
	var alternateDestination =document.createElement("p");
	
	var threshold2 = response.riskThreshold2;
	
	// Check if we got any alternate destinations or not 
	if(response.toRiskFactor > threshold2)
	{
		if(response.size != 0){
			// Risky to tavel to " Destination " and following are the alternate destinations found
			alternateDestination.innerHTML = " It is risky to tavel to " +$("#to").val() +" and following are the alternate destinations found.";
		}
		// Risky to tavel to " Destination " and no alternate destination found with lower risk
		else{
			alternateDestination.innerHTML = " It is risky to tavel to " +$("#to").val() +". Sorry, No alternate destination found with lower risk.";
		}
	}
	else{
		// Safe to travel to the destination
		alternateDestination.innerHTML = " It is Safe to travel to " + $("#to").val() +"!";	
	}
	
	
	var img2 =document.createElement("img");
	img2.setAttribute("class","img-fluid");
	img2.setAttribute("src",response.urlDestination);
	
	var imageInner2 = document.createElement("div");
	imageInner2.setAttribute("class","view overlay hm-white-slight");
	imageInner2.appendChild(img2);
	
	var image2 = document.createElement("div");
	image2.setAttribute("class","card-up");
	image2.appendChild(imageInner2);
	
	var cardContent2 =document.createElement("div");
	cardContent2.setAttribute("class","card-block");
	cardContent2.appendChild(destination);
	cardContent2.appendChild(hr);
	cardContent2.appendChild(meter3);
	cardContent2.appendChild(destinationRiskFactor);
	cardContent2.appendChild(alternateDestination);
	
	var inner2 =document.createElement("div");
	inner2.setAttribute("class","face front card");
	inner2.appendChild(image2);
	inner2.appendChild(cardContent2);
	
	var outer2 =document.createElement("div");
	outer2.setAttribute("class","card-wrapper");
	outer2.setAttribute("id","outer2");
	outer2.appendChild(inner2);

	results2.appendChild(outer2);
	makeSpeedo(meter3, response.toRiskFactor);
};


function cardholder(response,len){
	if(len == 0){
		var alternateDestination =document.createElement("p");
		alternateDestination.setAttribute("class","card-text");
		alternateDestination.innerHTML = " No Alternate Destination found with less Risk than "+ $("#to").val();
		cardContent2.appendChild(alternateDestination);
		inner2.appendChild(cardContent2);
		outer2.appendChild(inner2);
		results2.appendChild(outer2);
		
	}
	else{
		
		for(var i = 0; i < len; i++){
		
		var meter5 = document.createElement("div");
		meter5.setAttribute("class", "gauge2 demo2");
		meter5.setAttribute("id", "m5");	
		
//		var meter = document.createElement("meter");
//		meter.setAttribute("value",response.alternateDestinationRiskFactor[i]);
//		meter.setAttribute("min",0);
//		meter.setAttribute("max",10);
//		if(response.alternateDestinationRiskFactor[i] <= 3){
//			meter.setAttribute("class","low");
//		}
//		else if(response.alternateDestinationRiskFactor[i] <=6){
//			meter.setAttribute("class","medium");					
//		}
//		else{
//			meter.setAttribute("class","high");
//		}

		
//		var meter4 = document.createElement("meter");
//		meter4.setAttribute("value",response.alternateDestinationSimilarityIndex[i]);
//		meter4.setAttribute("min",0);
//		meter4.setAttribute("max",10);
//		if(response.alternateDestinationSimilarityIndex[i] <= 5){
//			meter4.setAttribute("class","low");
//		}
//		else if(response.alternateDestinationSimilarityIndex[i] <=7){
//			meter4.setAttribute("class","medium");					
//		}
//		else{
//			meter4.setAttribute("class","high");
//		}

		
		var city =document.createElement("h4");
		city.setAttribute("class","card-title");
		city.innerHTML = response.alternateDestination[i];
		
		var si =document.createElement("p");
		si.setAttribute("class","card-text");
		si.innerHTML = "Similarity Index is " + response.alternateDestinationSimilarityIndex[i]+"  ";
		
		var rf =document.createElement("p");
		rf.setAttribute("class","card-text");
		rf.innerHTML = "Risk Factor is " +response.alternateDestinationRiskFactor[i] + "  ";
		
		var button =document.createElement("a");
		button.setAttribute("class","btn btn-primary");
		button.innerHTML = "Search Flights"
		
		var image =document.createElement("img");
		image.setAttribute("class","img-fluid");
		image.setAttribute("src",response.alternateDestinationUrl[i]);
		
		var cardContent =document.createElement("div");
		cardContent.setAttribute("class","card-block");
		cardContent.appendChild(city);
		cardContent.appendChild(si);
		cardContent.appendChild(meter5);
		cardContent.appendChild(rf);
		
		
		var cardImage =document.createElement("div");
		cardImage.setAttribute("class","view overlay hm-white-slight");
		cardImage.appendChild(image);
		

		var innerdiv =document.createElement("div");
		innerdiv.setAttribute("class","card card-cascade narrower");
		innerdiv.appendChild(cardImage);
		innerdiv.appendChild(cardContent);
		
		var outerdiv = document.createElement("div");
		outerdiv.setAttribute("class","col-md-3");
		outerdiv.setAttribute("id","outerdiv");
		outerdiv.appendChild(innerdiv);

		var hr2 = document.createElement("div");
		cardHolder.appendChild(hr2);
		cardHolder.appendChild(outerdiv);
		makeSpeedo(meter5, response.alternateDestinationRiskFactor[i]);

	}
}
};


// Setting the Range of Dates that can be taken as Input in the HTML Form
$('.datepicker').pickadate({
	// `true` sets it to today. `false` removes any limits.
	min: true,
	// An integer (positive/negative) sets it relative to today.
	max: 30
})

// AUTO-COMPLETE THE FORM
var states =["Delhi","Mumbai","Chennai","Bengaluru","Kolkata","Paris","London","Venice","Rome","Milan","Singapore","Dubai","Barcelona","Kuala Lumpur","Amsterdam","Bangkok","Beijing","Shanghai","Toronto","Vancouver","New York City","San Francisco","Mexico"];
var airline = ["AI","9W","6E","MH","AF","LH","SG","AK"];
$('.mdb-autocomplete').mdb_autocomplete({
    data: states
});
$("#airline").mdb_autocomplete({
    data: airline
});
/* =============================================================================================================  */


//
//function reloadPage() {
//	console.log("ASDASD");
//	// window.location.reload();
//};


$(document).ready(function() {
    $('.mdb-select').material_select();
  });



//$(document).ready(function(){
//    
//	$("#impedanceSubmit").click(function(){
//    
//		// Impedance Factors --->>>  creating a JS variable with JSON data to be sent as an AJAX request
//		var data = {
//    		directFlights :$("#directFlights").val(),
//    		distance: $("#distance").val(),
//    		costDifference :$("#costDifference").val(),
//    		totalTravelTime : $("#totalTravelTime").val(),
//    		superFastTrains :$("#superFastTrains").val(),
//    		scheduleAlignment : $("#scheduleAlignment").val(),
//    		action: "impedance"
//    	};
//		// sending a POST AJAX request to Home Servlet
//    	$.post("home",data,
//    		 function(data1, status){                  // callback function which runs on receiving a response from the Home Servlet
//        	 $("#rfciImpedance").html(data1.data);
//        });
//    	
//	});
//	
//	$("#attractionSubmit").click(function(){
//    	// Attraction Factors -->> creating a JS variable with JSON data to be sent as an AJAX request
//		var data = {
//			PerCapitaIncome :$("#PerCapitaIncome").val(),
//			Population: $("#Population").val(),
//			CityType :$("#CityType").val(),
//			CatchmentArea : $("#CatchmentArea").val(),
//    		NicheAttributes : $("#NicheAttributes").val(),
//    		action: "attraction"
//    	};
//		
//		// sending a POST AJAX request to Home Servlet
//    	$.post("home",data,
//    		 function(data5, status){                  // callback function which runs on receiving a response from the Home Servlet
//        	 $("#rfciAttraction").html(data5.data);
//        });
//    	
//	});
//	
//	$("#googleSubmit").click(function(){
//    	
//    	// google maps --> creating a JS variable with JSON data to be sent as an AJAX request
//		var data = {
//    		from :$("#from1").val(),
//    		to :$("#to1").val(),
//    		action: "google"
//    	};
//		
//		// sending a POST AJAX request to Home Servlet
//    	$.post("home",data,
//    		 function(data3, status){                  // callback function which runs on receiving a response from the Home Servlet
//        	 $("#via").html(data3.data);
//        });
//    });
//	
//});






