<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Main layout-->
   
<main>
	 <div class="col-md-8 offset-md-2" style="padding-top: 30px">
				
		<div class="card">
		    <div class="card-block">
		
		        <!--Header-->
		        <div class="color-amadeus form-header" >
		            <h3 >Customize Threshold Values
					</h3>
			   	     
		        </div>
		        
		       <p style="color:#2097d3; text-align:center;font-weight:bolder;">You can set the threshold values for calculation of risk factor and similarity index of cities.</p>
		        <!--Body-->
		        <form id="thresholdForm" class="range-field">
				
					<table class="table">
					<thead>
					        <tr>
					            <th>Threshold</th>
					            <th>Value</th>
					            <th style="text-align:center">Current Value</th>
					        </tr>
					</thead>
					<tbody>
					        <tr>
					            <td>Origin Risk Threshold </td>
					            <td>
						            <div class="md-form col-md-8">
							       		<input type="range" id="ort" name="ort" value="" min="1" max="9" />
									</div>
					            </td>
					            <td style="text-align:center">${ort}</td>
					        </tr>
					        <tr>
					            <td>Destination Risk Threshold </td>
					            <td>		
									<div class="md-form col-md-8">
							       		<input type="range" id="drt" name="drt" value="" min="1" max="9" />
									</div>
					            </td>
					            <td style="text-align:center">${drt}</td>
					        </tr>
					        <tr>
					            <td>Similarity Medium Threshold </td>
					            <td>		
									<div class="md-form col-md-8">
							       		<input type="range" id="smt" name="smt" value="" min="1" max="9" />
									</div>
					            </td>
					            <td style="text-align:center">${smt}</td>
					        </tr>
					        <tr>
					            <td>Similarity High Threshold </td>
					            <td>		
									<div class="md-form col-md-8">
							       		<input type="range" id="sht" name="sht" value="" min="1" max="9" />
									</div>
					            </td>
					            <td style="text-align:center">${sht}</td>
					        </tr>
					        
					   </tbody>
					</table>	
					<div class="text-center">
			            <button class="btn blue darken-3" type="button" id="thresholdSubmit">Submit</button>
			        </div> 
			        <input type="hidden" name="action" id="action" value="threshold"/>   
				
				</form>
		    </div>
		</div>
		<br/>
	</div>
	
	 <div class="col-md-6 offset-md-3" style="padding-top: 30px" id="results">
		
	</div>
	
</main>