<%@include file="../lab-flows-shared/header.jsp"%>


			<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="${contextRoot}/laboratory/">Dashboard</a></li>
				<li class="breadcrumb-item active">Product</li>
			</ol>

			<!-- DataTables -->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-table"></i> Product
				</div>

				<div class="card-body">
				
										
					<sf:form class="form-horizontal" modelAttribute="product"
						method="POST">
				<%-- 		enctype="multipart/form-data" --%>
						
						<div class="modal-body">
							<table>
								<tr>
									<td><sf:label path="name" class="control-label">Name</sf:label></td>
									<td><sf:input path="name" class="form-control" placeholder="Product Name" /></td>
								</tr>

								<tr>
									<td><sf:label path="code" class="control-label">Code</sf:label></td>
									<td><sf:input path="code" class="form-control" placeholder="code" /></td>

								</tr>

								<tr>
									<td><sf:label path="brand" class="control-label">Brand</sf:label></td>
									<td><sf:input path="brand" class="form-control" placeholder="Brand" /></td>
								</tr>

								<tr>
									<td><sf:label path="description" class="control-label">Description</sf:label></td>
									<td><sf:input path="description" class="form-control" placeholder="Description" /></td>
								</tr>
								<tr>
									<td><sf:label path="quantity" class="control-label">Quantity</sf:label></td>
									<td><sf:input path="quantity" class="form-control" placeholder="Quantity" /></td>
								</tr>
								<tr>
									<td><sf:label path="unitPrice" class="control-label">Unit Price</sf:label></td>
									<td><sf:input path="unitPrice" class="form-control" placeholder="Unit Price" /></td>
								</tr>
								<tr>
									<td><sf:label path="weight" class="control-label">Weight</sf:label></td>
									<td><sf:input path="weight" class="form-control" placeholder="Weight" /></td>
								</tr>

								<tr>
									<td><sf:label path="nutritionFacts" class="control-label">Nutrition Facts</sf:label></td>
									<td><sf:input path="nutritionFacts" type="textarea"
											class="form-control" placeholder="Nutrition Facts" /></td>
								</tr>
								<tr>
									<td><sf:label path="categoryId" class="control-label">Category</sf:label></td>
									<td><sf:select path="categoryId" items="${categories}"
											itemLabel="name" itemValue="id" class="form-control" /></td>

								</tr>
								<tr>
									<td><sf:label path="supplierId" class="control-label">Supplier</sf:label></td>
									<td><sf:input path="supplierId" class="form-control" /></td>
								</tr>
<%-- 								<tr>
									<td><sf:label path="file" class="control-label">File upload</sf:label></td>
									<td><sf:input path="file" type="file" class="form-control" /></td>
								</tr> --%>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<sf:input type="hidden" path="id" />
									<td>
										<button type="submit" name="_eventId_ingredient"
											class="btn btn-lg btn-primary">
											Next - Ingredients <span class="glyphicon glyphicon-chevron-right"></span>
										</button>
									</td>
								</tr>
							</table>
						</div>
					</sf:form>

				</div>
			</div>




<%@include file="../lab-flows-shared/footer.jsp"%>