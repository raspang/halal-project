<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item active">Supplier</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Supplier
	</div>
	
	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="supplier"
			action="${contextRoot}/laboratory/supplier" method="POST" enctype="multipart/form-data">
			<div class="modal-body">
				<table>
					<tr>
						<td><sf:label path="nameOfEstablishment" class="control-label">Company Name</sf:label></td>
						<td><sf:input path="nameOfEstablishment" class="form-control" placeholder="Company Name"  required="required"/></td>
					</tr>

	
						<tr>
						<td><sf:label path="addressOfEstablishment" class="control-label">Company Address</sf:label></td>
						<td><sf:input path="addressOfEstablishment" class="form-control" placeholder="Company Address" required="required"/></td>

					</tr>
									
					<tr>
						<td><sf:label path="telNo" class="control-label">Contact No.</sf:label></td>
						<td><sf:input path="telNo" class="form-control" placeholder="Contact No."  required="required"/></td>

					</tr>
 
					<tr>
						<td><sf:label path="fax" class="control-label">Fax</sf:label></td>
						<td><sf:input path="fax" class="form-control" placeholder="Fax" /></td>
					</tr>

					<tr>
						<td><sf:label path="personInvolved" class="control-label">Authorized Person</sf:label></td>
						<td><sf:input path="personInvolved" class="form-control" placeholder="Authorized Person"  required="required"/></td>
					</tr>
					<tr>
						<td><sf:label path="position" class="control-label">Position</sf:label></td>
						<td><sf:input path="position" class="form-control" placeholder="Position"  required="required"/></td>
					</tr>
					<tr>
						<td><sf:label path="email" class="control-label">Email</sf:label></td>
						<td><sf:input path="email" class="form-control" type="email" placeholder="Email"  required="required"/></td>
					</tr>
					<tr>
						<td><sf:label path="website" class="control-label">Website</sf:label></td>
						<td><sf:input path="website" type="url" class="form-control" placeholder="http://XXXXXX.com" /></td>
					</tr>

					<tr>
						<td><sf:label path="reason" class="control-label">Reason for Application</sf:label></td>
						<td><sf:input path="reason" type="textarea" class="form-control"  required="required" placeholder="Please explain why you need the certification?" /></td>
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
						<td><sf:label path="numOfRawMaterial" class="control-label">Number of Raw Material Warehouses</sf:label></td>
						<td><sf:input path="numOfRawMaterial" class="form-control" /></td>
					</tr>
					<tr>
						<td><sf:label path="numProductsWarehouses" class="control-label">Number of Finished Products Warehouses</sf:label></td>
						<td><sf:input path="numProductsWarehouses" type="number" class="form-control" /></td>
					</tr>	
					<tr>
						<td><sf:label path="productionCapacity" class="control-label">Production Capacity (TON/YEAR)</sf:label></td>
						<td><sf:input path="productionCapacity" class="form-control" /></td>
					</tr>
					<tr>
						<td><sf:label path="productionLines" class="control-label">Production Lines</sf:label></td>
						<td><sf:input path="productionLines" class="form-control"  required="required" /></td>
					</tr>
					<tr>			
						<td><sf:label path="customProduction" class="control-label">Does company do custom production(like private label)</sf:label></td>
						<td><sf:input path="customProduction" class="form-control" /></td>
					</tr>							
					<tr>
					
						<td><sf:label path="productBrands" class="control-label">Brands of Products</sf:label></td>
						<td><sf:input path="productBrands"  class="form-control" /></td>
					</tr>	
					<tr>
						<td><sf:label path="productVarieties" class="control-label">Product Varieties</sf:label></td>
						<td><sf:input path="productVarieties" class="form-control"  required="required"/></td>
					</tr>
										<tr>
						<td><sf:label path="productNotHalal" class="control-label">None Halal Products? (If any)</sf:label></td>
						<td><sf:input path="productNotHalal" type="textarea" class="form-control" placeholder="State products that will not be halal certified? (If any)" /></td>
					</tr>	
						<tr>
						<td><sf:label path="namesOfRawMaterials" class="control-label">Names of Raw Materials</sf:label></td>
						<td><sf:input path="namesOfRawMaterials" class="form-control" /></td>
					</tr>
							<tr>
						<td><sf:label path="namesOfSuppliers" class="control-label">Names of Suppliers</sf:label></td>
						<td><sf:input path="namesOfSuppliers" class="form-control"  required="required"/></td>
					</tr>				
					<tr>
						<td><sf:label path="productsProcess" class="control-label">Process Flow for each Product</sf:label></td>
						<td><sf:input path="productsProcess" class="form-control"  required="required"/></td>
					</tr>
													
															 
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<sf:input type="hidden" path="createdOn" />
						<sf:input type="hidden" path="enable" />
						<sf:input type="hidden" path="active" />
						<sf:input type="hidden" path="code" />
						<sf:input type="hidden" path="user" />
						<sf:input type="hidden" path="createdBy" />
						<td><a href="${contextRoot}/laboratory/suppliers"
							class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
