<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Main layout-->
   
<main>
	 <div class="col-md-8 offset-md-2" style="padding-top: 30px">
				
		<div class="card">
		    <div class="card-block">
		
		        <!--Header-->
		        <div class="color-amadeus form-header ">
		            <h3>Customize Risk Factors</h3>
		        </div>
				
				<p style="color:#2097d3; text-align:center;font-weight:bolder;">You can set the weightage of risk factors that you want to be used for calculation of risk factor of cities.</p>
		       
		        <!--Body-->
		        <form id="riskCustomizationForm">
			     		
			     	<c:if test="${admin == '1' }">
			     		<input type="hidden" name="adminCheck" id="adminCheck" value="admin"/>
			     	</c:if>
			     		
					<table class="table">
					    <thead>
					        <tr>
							    <th>#</th>
					            <c:if test="${admin == '0' }"><th></th></c:if>
					            <th>Factors</th>
					            <th>Weightage</th>
					            <th style="text-align:center">Current Settings</th>
					        </tr>
					    </thead>
					    <tbody>
					        <tr>
					            <th scope="row">1</th>
					            <c:if test="${admin == '0' }">
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox1">
					                    <label for="checkbox1"></label>
					                </fieldset>
					            </td>
					            </c:if>
					            <td id="1">Weather</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor1" name="factor1">
					                                                <option value="Medium">Medium</option>
					                                                <option value="High">High</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					            <td style="text-align:center">${riskFactorsValue[0]}</td>
					        </tr>
					        <tr>
					            <th scope="row">2</th>
					            <c:if test="${admin == '0' }">
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox2">
					                    <label for="checkbox2"></label>
					                </fieldset>
					            </td>
					            </c:if>
					            <td id="2">Airport Delay</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor2" name="factor2">
					                                                <option value="Medium">Medium</option>
					                                                <option value="High">High</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					            <td style="text-align:center">${riskFactorsValue[1]}</td>
					        </tr>
					        <tr>
					            <th scope="row">3</th>
					            <c:if test="${admin == '0' }">
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox3">
					                    <label for="checkbox3"></label>
					                </fieldset>
					            </td>
					            </c:if>
					            <td id="3">Flight Status</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor3" name="factor3">
					                                                <option value="Medium">Medium</option>
					                                                <option value="High">High</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					            <td style="text-align:center">${riskFactorsValue[2]}</td>
					        </tr>
							<tr>
					            <th scope="row">4</th>
					            <c:if test="${admin == '0' }">
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox4">
					                    <label for="checkbox4"></label>
					                </fieldset>
					            </td>
					            </c:if>
					            <td id="4">Flight Status History</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor4" name="factor4">
					                                                <option value="Medium">Medium</option>
					                                                <option value="High">High</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					            <td style="text-align:center">${riskFactorsValue[3]}</td>
					        </tr>
					        <tr>
					            <th scope="row">5</th>
					            <c:if test="${admin == '0' }">
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox5">
					                    <label for="checkbox5"></label>
					                </fieldset>
					            </td>
					            </c:if>
					            <td id="5">Peek Season</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor5" name="factor5">
					                                                <option value="Medium">Medium</option>
					                                                <option value="High">High</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					            <td style="text-align:center">${riskFactorsValue[4]}</td>
					        </tr>
					        <tr>
					            <th scope="row">6</th>
					            <c:if test="${admin == '0' }">
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox6">
					                    <label for="checkbox6"></label>
					                </fieldset>
					            </td>
					            </c:if>
					            <td id="6">Tourist Inflow</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor6" name="factor6">
					                                                <option value="Medium">Medium</option>
					                                                <option value="High">High</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					            <td style="text-align:center">${riskFactorsValue[5]}</td>
					        </tr>
							<tr>
					            <th scope="row">7</th>
					            <c:if test="${admin == '0' }">
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox7">
					                    <label for="checkbox7"></label>
					                </fieldset>
					            </td>
					            </c:if>
					            <td id="7">Flight Rating</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor7" name="factor7">
					                                                <option value="Medium">Medium</option>
					                                                <option value="High">High</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					            <td style="text-align:center">${riskFactorsValue[6]}</td>
					        </tr>
					        <tr>
					            <th scope="row">8</th>
					            <c:if test="${admin == '0' }">
					            <td>
					                <fieldset class="form-group">
					                    <input type="checkbox" id="checkbox8">
					                    <label for="checkbox8"></label>
					                </fieldset>
					            </td>
					            </c:if>
					            <td id="8">Travel Warning Index</td>
					            <td>
					                <div class="md-form">
					                                        <select class="mdb-select" id="factor8" name="factor8">
					                                                <option value="Medium">Medium</option>
					                                                <option value="High">High</option>
					                                                <option value="Low">Low</option>
					                                        </select>
					                </div>
					            </td>
					            <td style="text-align:center">${riskFactorsValue[7]}</td>
					        </tr>
					     </tbody>
					</table>
						
						
						<br>
					
					<div class="text-center">
			            <button class="btn blue darken-3" type="button" id="riskSubmit" data-toggle="modal" data-target="#basicExample">Submit</button>
			        	<c:if test="${admin == '0' }">
				     		<button class="btn blue darken-3" type="button" id="resetForm">Reset to Default</button>
				     	</c:if>
			        </div> 
			        <input type="hidden" name="action" id="action" value="riskCustomization"/>   
				
				</form>
		    </div>
		</div>
		<br/>
	</div>
	
	
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
                <h4 class="modal-title w-100" id="myModalLabel">Selection Made</h4>
            </div>
            <!--Body-->
            <div class="modal-body" id="modalBody">
                
            </div>
            <!--Footer-->
            <div class="modal-footer">
                <button type="button" id="riskCustomizationSubmit" class="btn blue darken-3">Confirm</button>
            </div>
        </div>
        <!--/.Content-->
    </div>
</div>
<!-- Modal -->
	
	 <div class="col-md-6 offset-md-3" style="padding-top: 30px" id="results">
		
	</div>
	
</main>