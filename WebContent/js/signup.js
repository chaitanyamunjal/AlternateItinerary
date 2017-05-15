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


