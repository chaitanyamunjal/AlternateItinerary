
<main>
	<div class="col-md-6 offset-md-3" style="padding-top: 30px">
				
		<div class="card">
		    <div class="card-block">
		
		        <!--Header-->
		        <div class="color-amadeus form-header ">
		            <h3>Alternate Itinerary Calculator</h3>
		        </div>
		        <!--Body-->
		        <form id="MainForm">
			        
			        <div class="md-form">
			        
			       		<input type="text" id="from" class="form-control mdb-autocomplete" name="from" value="" required/>
						<label>From</label>
					</div>
					
					<div class="md-form">
			       		<input type="text" id="to" class="form-control mdb-autocomplete" name="to" value="" required/>
						<label>To</label>
					</div>
					 
					<div class="md-form">
			       		<input type="text" id="airline" class="form-control" name="airline" value="" required/>
						<label>Airline</label>
					</div>
					
					<div class="md-form">
			       		<input type="text" id="flightnumber" class="form-control" name="flightnumber" value="" required/>
						<label>Flight Number</label>
					</div>
					
					<div class="md-form">
    					<input placeholder="Selected date" type="date" min="2017-04-10" name="date" id="date" class="form-control datepicker"  >
    					<label for="date-picker-example">Date</label>
					</div>
					
					<div class="text-center">
					    <button class="btn blue darken-3" type="button" id="details" data-toggle="modal" data-target="#basicExample">Details</button> 
			            <button class="btn blue darken-3" type="button" id="mainSubmit">Search</button>
			        
			        </div> 
					
			        <!-- Displaying the nearest Tier 1 city to the destination -->
				    <input type="hidden" name="action" id="action" value="main"/>   
				</form>
		    </div>
		</div>
	</div>
      
      
     <!-- Modal to display Details -->
     <!-- Modal -->
<div class="modal fade" id="basicExample" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title w-100" id="myModalLabel">Factors Settings</h4>
            </div>
            <!--Body-->
            <div class="modal-body" id="modalBody">
                
            </div>
            <!--Footer-->
            <div class="modal-footer">
                <button type="button" class="btn blue darken-3" data-dismiss="modal">Close</button>
            </div>
        </div>
        <!--/.Content-->
    </div>
</div>
<!-- Modal -->


      
     <br>
     <div class="progress primary-color-dark" id="progressBar">
    		<div class="indeterminate"></div>
	</div>
	 
	 <div class="gauge2 demo2"></div>
	      
     <div class="row" style="padding-top: 20px">
	    <div class="col-md-9 offset-md-3" id="bar">
	     	
	    </div>
	    <div class="col-md-9 offset-md-3" id="barValues">
	     	
	    </div>  
	</div>
	
	<div class="row " style="padding-top: 20px">
		<div class="col-md-5 offset-md-1" id="results1" style="padding: 30px">
		
		</div>
		<div class="col-md-5" id="results2" style="padding: 30px">
		
		</div>
	</div>
	
	<div class="row" style="padding-top: 20px" id="cardHolder">	
	
	</div>
		
</main>
				