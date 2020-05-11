<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/">Dashboard</a></li>
	<li class="breadcrumb-item active">Supplier</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Supplier
	</div>
	
	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="supplier"
			action="${contextRoot}/supplier/supplier" method="POST" enctype="multipart/form-data">
			<div class="modal-body">
				<table>
					<tr>
						<td><sf:label path="nameOfEstablishment" class="control-label">Name</sf:label></td>
						<td><sf:input path="nameOfEstablishment" class="form-control" placeholder="Product Name" /></td>
					</tr>

					
					<tr>
						<td><sf:label path="telNo" class="control-label">Contact No.</sf:label></td>
						<td><sf:input path="telNo" class="form-control" placeholder="Contact No." /></td>

					</tr>
 
					<tr>
						<td><sf:label path="fax" class="control-label">Fax</sf:label></td>
						<td><sf:input path="fax" class="form-control" placeholder="Fax" /></td>
					</tr>

					<tr>
						<td><sf:label path="personInvolved" class="control-label">Authorized Person</sf:label></td>
						<td><sf:input path="personInvolved" class="form-control" placeholder="Authorized Person" /></td>
					</tr>
					<tr>
						<td><sf:label path="position" class="control-label">Position</sf:label></td>
						<td><sf:input path="position" class="form-control" placeholder="Position" /></td>
					</tr>
					<tr>
						<td><sf:label path="email" class="control-label">Email</sf:label></td>
						<td><sf:input path="email" class="form-control" placeholder="Email" /></td>
					</tr>
					<tr>
						<td><sf:label path="website" class="control-label">Website</sf:label></td>
						<td><sf:input path="website" type="url" class="form-control" placeholder="Website" /></td>
					</tr>

					<tr>
						<td><sf:label path="owner" class="control-label">Owner</sf:label></td>
						<td><sf:input path="owner" type="textarea" class="form-control" placeholder="Owner" /></td>
					</tr>

					<tr>
						<td><sf:label path="reason" class="control-label">Reason for Application</sf:label></td>
						<td><sf:input path="reason" type="textarea" class="form-control" placeholder="Please explain why you need the certification?" /></td>
					</tr>

					<tr>
						<td><sf:label path="numOfEmployees" class="control-label">Number of Employees</sf:label></td>
						<td><sf:input path="numOfEmployees" class="form-control" placeholder="Number of Employees" /></td>
					</tr>
					
					<tr>
						<td><sf:label path="productionAreaSize" class="control-label">Production Area Size</sf:label></td>
						<td><sf:input path="productionAreaSize" class="form-control" placeholder="productionAreaSize" /></td>
					</tr>
	
					<tr>
						<td><sf:label path="indoorArea" class="control-label">Indoor Area</sf:label></td>
						<td><sf:input path="indoorArea" class="form-control" placeholder="Indoor Area (m2)" /></td>
					</tr>
										
					<tr>
						<td><sf:label path="openArea" class="control-label">Open Area</sf:label></td>
						<td><sf:input path="openArea" class="form-control" placeholder="Open Area (m2)" /></td>
					</tr>
																			
					<tr>
						<td><sf:label path="numOfRawMaterial" class="control-label">Number of Raw Materials</sf:label></td>
						<td><sf:input path="numOfRawMaterial" class="form-control" /></td>
					</tr>
					<tr>
						<td><sf:label path="productionLines" class="control-label">Production Lines</sf:label></td>
						<td><sf:input path="productionLines" class="form-control" /></td>
					</tr>
					<tr>
						<td><sf:label path="productNotHalal" class="control-label">None Halal Products? (If any)</sf:label></td>
						<td><sf:input path="productNotHalal" type="textarea" class="form-control" placeholder="State products that will not be halal certified? (If any)" /></td>
					</tr>					
					<tr>
						<td><sf:label path="additionalActivities" class="control-label">Additional Activities</sf:label></td>
						<td><sf:input path="additionalActivities" type="textarea"  class="form-control" /></td>
					</tr>	
															 
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<sf:input type="hidden" path="updatedOn" />
						<sf:input type="hidden" path="createdOn" />
						<sf:input type="hidden" path="enable" />
						<sf:input type="hidden" path="active" />
						<td><a href="${contextRoot}/supplier/suppliers"
							class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
