<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Main layout-->
   
<main>
	 <div class="col-md-6 offset-md-3" style="padding-top: 30px">
				
		<div class="card">
		    <div class="card-block">
		
		        <!--Header-->
		        <div class="color-amadeus form-header ">
		            <h3>Similar City Finder</h3>
		        </div>
		        <p style="color:#2097d3; text-align:center;font-weight:bolder;">Get the list of similar cities and their similarity index.</p>
		        <!--Body-->
		        <form id="cityForm">
			        
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
						<label>City</label>
					 </div>
										
					<div class="text-center">
			            <button class="btn blue darken-3" type="button" id="citySubmit">Find</button>
			            <hr>
			        </div> 
			            <input type="hidden" name="action" id="action" value="city"/>   
				
				</form>
		    </div>
		</div>
		<br/><hr>
	</div>
	
	 <div class="col-md-6 offset-md-3" style="padding-top: 30px" id="results">
		
	</div>
	
</main>