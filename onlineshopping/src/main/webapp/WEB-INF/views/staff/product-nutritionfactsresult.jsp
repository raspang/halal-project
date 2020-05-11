
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/staff/">Dashboard</a></li>
	<li class="breadcrumb-item"><a
		href="${contextRoot}/staff/products">Product</a></li>
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
									
								</tr>
								<c:forEach items="${nutritionFactsResult.nutritionFactsParameters}" var="nutritionFactsParameter">
									<tr>
										<td>${nutritionFactsParameter.name}</td>
										<td>${nutritionFactsParameter.value}</td>
										<td>${nutritionFactsParameter.value2}</td>

									</tr>
								</c:forEach> 
									
												
										
							</table>
		
						</td>
						<td>${nutritionFactsResult.analyst.name }
						</td>
						<td>${nutritionFactsResult.updatedBy.completeName }
						</td>

					</tr>
				</c:forEach>
			</table>

			<a href="${contextRoot}/staff/products"
				class="btn btn-lg btn-primary">Back</a>


		</div>
	</div>
</div>
