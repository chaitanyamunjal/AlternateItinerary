
// Function for Login AJAX Request to Login servlet

$(document).ready(function(){

		$("#login").click(function(){
			var data = {
					username :$("#username").val(),
					password :$("#password").val(),
					admin : $('#radio5').is(':checked') ? "1" : "0"
				};
			
			// sending a POST AJAX request to Home Servlet
			$.ajax({
				url : "login",
				data: data, 
				type: "post",
				success: function(data) {
					if($('#radio5').is(':checked')){
						window.location.href="similaritycustomization";
					}
					else{
						window.location.href="main";    
					}
			    },
				error: function(XMLHttpRequest, textStatus, errorThrown) {	
			    	$("#invalid").html("Invalid Username or Password.");
			    }
		
			});

		});
});

