
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/">Dashboard</a></li>
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/products">Product</a></li>
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
		<h4>${product.name}</h4>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
					<th>Nutrition Fact Name</th>
					<th>Value</th>
					<th></th>
				</tr>
				<c:forEach items="${nutritionFactsResults}" var="nutritionFactsResult">
					<tr>
 						<td>${nutritionFactsResult.nutritionFactsParameter.name}</td>
						<td>
							${nutritionFactsResult.value}
						<td>
							<a href="${contextRoot}/supplier/product/${product.id}/nutritionfactsresult?nutritionfactsId=${nutritionFactsResult.id}"><i class="fas fa-edit"></i></a>|						
							<a href="#" data-toggle="modal"
								data-target="#mymodal${nutritionFactsResult.id}"><i class="fas fa-trash-alt"></i></a>
								
							<div id="mymodal${nutritionFactsResult.id}" class="modal fade"
								tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">

										<div class="modal-header">
											<h4 class="modal-title">Delete</h4>
											<button type="button" class="close" data-dismiss="modal"aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											
										</div>
										<div class="modal-body">
											<p>Are you sure you want to delete?</p>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<a href="${contextRoot}/supplier/product/${product.id}/nutritionfactsresult/${nutritionFactsResult.id}/delete"
												class="btn btn-danger">Delete</a>
										</div>

									</div>
								</div>
							</div>
							
															
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<a href="${contextRoot}/supplier/products" class="btn btn-lg btn-primary">Back</a>
			<a href="${contextRoot}/supplier/product/${product.id}/nutritionfactsresult/add" class="btn btn-lg btn-primary">Add</a>

		</div>
	</div>
</div>
