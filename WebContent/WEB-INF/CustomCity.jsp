<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Main layout-->
   
<main>
	 <div class="col-md-6 offset-md-3" style="padding-top: 30px">
				
		<div class="card">
		    <div class="card-block">
		
		        <!--Header-->
		        <div class="color-amadeus form-header ">
		            <h3>Customized Similar City Finder</h3>
		        </div>
		        <p style="color:#2097d3; text-align:center;font-weight:bolder;">Get the list of similar cities based on similarity factors you want to compare.</p>
		        <!--Body-->
		        <form id="customCityForm">
			        
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
						
					<table class="table">
					    <thead>
					        <tr>
							    <th>#</th>
					            <th></th>
					            <th>Factors</th>
					            <th>Weightage</th>
					        </tr>
					    </thead>
					    <tbody>
					        <tr>
					            <th scope="row">1</th>
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox1">
					                    <label for="checkbox1"></label>
					                </fieldset>
					            </td>
					            
					            <td>Tourist Attraction Index</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor1" name="factor1">
					                                                <option value="High">High</option>
					                                                <option value="Medium">Medium</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					        </tr>
					        <tr>
					            <th scope="row">2</th>
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox2">
					                    <label for="checkbox2"></label>
					                </fieldset>
					            </td>
					            <td>Flight Duration</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor2" name="factor2">
					                                                <option value="High">High</option>
					                                                <option value="Medium">Medium</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					        </tr>
					        <tr>
					            <th scope="row">3</th>
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox3">
					                    <label for="checkbox3"></label>
					                </fieldset>
					            </td>
					            <td>Visa</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor3" name="factor3">
					                                                <option value="High">High</option>
					                                                <option value="Medium">Medium</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					        </tr>
							<tr>
					            <th scope="row">4</th>
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox4">
					                    <label for="checkbox4"></label>
					                </fieldset>
					            </td>
					            <td>Pollution Level</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor4" name="factor4">
					                                                <option value="High">High</option>
					                                                <option value="Medium">Medium</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					        </tr>
					        <tr>
					            <th scope="row">5</th>
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox5">
					                    <label for="checkbox5"></label>
					                </fieldset>
					            </td>
					            <td>Peek Season</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor5" name="factor5">
					                                                <option value="High">High</option>
					                                                <option value="Medium">Medium</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					        </tr>
					        <tr>
					            <th scope="row">6</th>
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox6">
					                    <label for="checkbox6"></label>
					                </fieldset>
					            </td>
					            <td>Flight Price</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor6" name="factor6">
					                                                <option value="High">High</option>
					                                                <option value="Medium">Medium</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					        </tr>
							<tr>
					            <th scope="row">7</th>
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox7">
					                    <label for="checkbox7"></label>
					                </fieldset>
					            </td>
					            <td>Travel Distance</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor7" name="factor7">
					                                                <option value="High">High</option>
					                                                <option value="Medium">Medium</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					        </tr>
					        <tr>
					            <th scope="row">8</th>
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox8">
					                    <label for="checkbox8"></label>
					                </fieldset>
					            </td>
					            <td>Travel Warning Index</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor8" name="factor8">
					                                                <option value="High">High</option>
					                                                <option value="Medium">Medium</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					        </tr>
					        <tr>
					            <th scope="row">9</th>
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox9">
					                    <label for="checkbox9"></label>
					                </fieldset>
					            </td>
					            <td>City Category</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor9" name="factor9">
					                                                <option value="High">High</option>
					                                                <option value="Medium">Medium</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					        </tr>
							<tr>
					            <th scope="row">10</th>
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox10">
					                    <label for="checkbox10"></label>
					                </fieldset>
					            </td>
					            <td>Transportation Index</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor10" name="factor10">
					                                                <option value="High">High</option>
					                                                <option value="Medium">Medium</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					        </tr>
					        <tr>
					            <th scope="row">11</th>
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox11">
					                    <label for="checkbox11"></label>
					                </fieldset>
					            </td>
					            <td>Connectivity Index</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor11" name="factor11">
					                                                <option value="High">High</option>
					                                                <option value="Medium">Medium</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					        </tr>
					
					    </tbody>
					</table>
						
						
						<br>
					
					<div class="text-center">
			            <button class="btn blue darken-3" type="button" id="customCitySubmit">Find</button>
			        </div> 
			        <input type="hidden" name="action" id="action" value="customcity"/>   
				
				</form>
		    </div>
		</div>
		<br/>
	</div>
	
	 <div class="col-md-6 offset-md-3" style="padding-top: 30px" id="results">
		
	</div>
	
</main>