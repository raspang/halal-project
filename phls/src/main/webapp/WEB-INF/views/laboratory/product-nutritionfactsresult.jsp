
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item"><a
		href="${contextRoot}/laboratory/products">Product</a></li>
	<li class="breadcrumb-item active">Nutrition Facts</li>
</ol>

<c:if test="${not empty message}">
	<div class="alert alert-success">${message}</div>
</c:if>
<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Nutrition Facts
	</div>

	<div class="card-body">
		<h4>Company : <strong>${product.supplier.nameOfEstablishment}</strong></h4>
		<h4>Product : <strong>${product.name}</strong></h4>
		<h4>Thayyibban Analysis : </h4>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
					<th>Created On</th>
					<th>Updated On</th>
					<th>Nutrition Fact Label</th>
					<th>Analyst By</th>
					<th>Updated By</th>
					<th></th>	
					<th></th>
				</tr>
				<c:forEach items="${nutritionFactsResults}"
					var="nutritionFactsResult">
					<tr>
						<td>${nutritionFactsResult.createdOnStr}</td>
						<td>${nutritionFactsResult.updatedOnStr}</td>
						<td>
							<table class="table table-bordered">
								<tr>
									<th>Nutrition</th>
									<th>Value</th>
									<th>%Daily Value*</th>
									<th></th>
								</tr>
								<c:forEach items="${nutritionFactsResult.nutritionFactsParameters}" var="nutritionFactsParameter">
									<tr>
										<td>${nutritionFactsParameter.name}</td>
										<td>${nutritionFactsParameter.value}</td>
										<td>${nutritionFactsParameter.value2}</td>
										<td>

										<a href="#" data-toggle="modal" data-target="#modalNutritionFactsParam${nutritionFactsParameter.id}"><i class="fas fa-edit"></i></a>
										
										<div id="modalNutritionFactsParam${nutritionFactsParameter.id}" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
												<div class="modal-dialog" role="document">
												<div class="modal-content">

												<div class="modal-header">
													<h4 class="modal-title">Nutrition Label</h4>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
		
												</div>
												
												<sf:form class="form-horizontal" modelAttribute="nutritionfactsparameter"  action="${contextRoot}/laboratory/product/${product.id}/pro-nutritionfactsparameter" method="POST">
												
												<div class="modal-body">
														
														<sf:input type="hidden" path="id" value="${nutritionFactsParameter.id}" />
									 					<div class="form-group">
															<label class="control-label col-md-4">Name</label>
															<div class="col-md-8 validate">
																<sf:input type="text" path="name" class="form-control" value="${nutritionFactsParameter.name}" readonly="true"/> 
															</div>
														</div>
										        			
										       			<div class="form-group">				
															<label class="control-label col-md-4">Value</label>
															<div class="col-md-8 validate">
																<sf:input type="text" path="value" class="form-control" value="${nutritionFactsParameter.value}"  /> 
															</div>
														</div>					
												        <div class="form-group">				
															<label class="control-label col-md-4">Value</label>
															<div class="col-md-8 validate">
																<sf:input type="text" path="value2" class="form-control" value="${nutritionFactsParameter.value2}"   /> 
															</div>
														</div>														
														
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
													<button class="btn btn-default">Save</button>
												</div>
												</sf:form>
											</div>
											</div>
										</div>	
										
										
																			
										
										</td>
									</tr>
								</c:forEach> 
									
												
										
							</table>
		
						</td>
						<td>${nutritionFactsResult.analyst.name }
						</td>
						<td>${nutritionFactsResult.updatedBy.completeName }
						</td>
						<td>
							<a href="${contextRoot}/laboratory/product/${product.id}/nutritionfacts/pdf?nutritionfactsid=${nutritionFactsResult.id}"
							 target="_blank"><i class="fas fa-file-pdf"></i>
							 </a>
						</td>
						<td>
							<a href="${contextRoot}/laboratory/product/${product.id}/nutritionfactsresult?nutritionfactsId=${nutritionFactsResult.id}">
								<i class="fas fa-edit"></i></a>| <a href="#" data-toggle="modal"
									data-target="#mymodal${nutritionFactsResult.id}"><i class="fas fa-trash-alt"></i></a>

							<div id="mymodal${nutritionFactsResult.id}" class="modal fade"
								tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">

										<div class="modal-header">
											<h4 class="modal-title">Delete</h4>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>

										</div>
										<div class="modal-body">
											<p>Are you sure you want to delete?</p>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<a href="${contextRoot}/laboratory/product/${product.id}/nutritionfactsresult/${nutritionFactsResult.id}/delete"
												class="btn btn-danger">Delete</a>
										</div>

									</div>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>

			<a href="${contextRoot}/laboratory/products"
				class="btn btn-lg btn-primary">Back</a> <a
				href="${contextRoot}/laboratory/product/${product.id}/nutritionfactsresult/add"
				class="btn btn-lg btn-primary">Add</a>

		</div>
	</div>
</div>
