
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/staff/">Dashboard</a></li>
	<li class="breadcrumb-item active">Ingredient</li>
</ol>

<c:if test="${not empty message}">
	<div class="alert alert-success">${message}</div>
</c:if>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Ingredient
	</div>

	<div class="card-body">
		<h4>Company : <strong>${product.supplier.nameOfEstablishment}</strong></h4>
		<h4>Product : <strong>${product.name}</strong></h4>
		<h4>Ingredient : </h4>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Mark</th>
					<th></th>
					<th>Comment</th>
		
				</tr>
				<c:forEach items="${ingredientDetails}" var="ingredient">
					<tr>
						<td>${ingredient.ingredient.name}</td>
						<td>${ingredient.ingredient.description}</td>
						<td><c:if test="${ingredient.ingredient.critical}">
							Critical
						</c:if> <c:if test="${not ingredient.ingredient.critical}">
							Safe
						</c:if></td>
						<td><c:if test="${ingredient.mark}">
							None conform to H. Standards
						</c:if> <c:if test="${not ingredient.mark}">
							Conform to H. Standards
						</c:if></td>
						<td>${ingredient.markDescription}</td>

					</tr>
				</c:forEach>

			</table>
			<a href="${contextRoot}/staff/products"
				class="btn btn-lg btn-primary">Back</a> 


		</div>
	</div>
</div>

