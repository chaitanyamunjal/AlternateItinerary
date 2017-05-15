<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Main layout-->
    
<main>

	 <div class="col-md-6 offset-md-3" style="padding-top: 30px">
				
		<div class="card">
		    <div class="card-block">
		
		        <!--Header-->
		        <div class="color-amadeus form-header ">
		            <h3>Similarity Index Calculator</h3>
		        </div>
		        <p style="color:#2097d3; text-align:center;font-weight:bolder;">Check how similar 2 cities of the world are.</p>
		        <!--Body-->
		        <form id="HomeForm">
			        
					<div class="md-form">
			            <select class="mdb-select" id="city1" name="city1">
								<option value="Paris">Paris</option>
								<option value="London">London</option>
								<option value="Rome">Rome</option>
								<option value="Venice">Venice</option>
								<option value="Milan">Milan</option>
								<option value="Singapore">Singapore</option>
								<option value="Dubai">Dubai</option>
								<option value="Barcelona">Barcelona</option>
								<option value="Kuala Lumpur">Kuala Lumpur</option>
								<option value="Amsterdam">Amsterdam</option>
								<option value="Bangkok">Bangkok</option>
								<option value="Beijing">Beijing</option>
								<option value="Shanghai">Shanghai</option>
								<option value="Toronto">Toronto</option>
								<option value="Vancouver">Vancouver</option>
								<option value="New York City">New York City</option>
								<option value="San Francisco">San Francisco</option>
								<option value="Mexico">Mexico</option>
						</select>
						<label>First City</label>
					 </div>
										
					<div class="md-form">
			            <select class="mdb-select" id="city2" name="city2">
								<option value="London">London</option>
								<option value="Paris">Paris</option>
								<option value="Rome">Rome</option>
								<option value="Venice">Venice</option>
								<option value="Milan">Milan</option>
								<option value="Singapore">Singapore</option>
								<option value="Dubai">Dubai</option>
								<option value="Barcelona">Barcelona</option>
								<option value="Kuala Lumpur">Kuala Lumpur</option>
								<option value="Amsterdam">Amsterdam</option>
								<option value="Bangkok">Bangkok</option>
								<option value="Beijing">Beijing</option>
								<option value="Shanghai">Shanghai</option>
								<option value="Toronto">Toronto</option>
								<option value="Vancouver">Vancouver</option>
								<option value="New York City">New York City</option>
								<option value="San Francisco">San Francisco</option>
								<option value="Mexico">Mexico</option>
						</select>
						<label>Second City</label>
					 </div>
					<div class="text-center">
			            <button class="btn blue darken-3" type="button" id="homeSubmit">Find</button>
			        </div> 
			            <input type="hidden" name="action" id="action" value="home"/>   
				</form>
		    </div>
		</div>
	</div>
	
	<div class="col-md-6 offset-md-3" style="padding-top:30px" id="results">
	
	</div>
	
</main>