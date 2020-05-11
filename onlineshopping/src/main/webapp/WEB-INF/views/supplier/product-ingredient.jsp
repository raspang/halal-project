<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/">Dashboard</a></li>
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
		<h4>Product : <strong>${product.name}</strong></h4>
		<h4>Ingredients : </h4>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
					<th>Name</th>
					<th>Description</th>
				</tr>
				<c:forEach items="${ingredientDetails}" var="ingredient">
					<tr>
						<td>${ingredient.ingredient.name}</td>
						<td>${ingredient.ingredient.description}</td>					
					</tr>
				</c:forEach>

			</table>
			<a href="${contextRoot}/supplier/products"
				class="btn btn-lg btn-primary">Back</a> <a
				href="${contextRoot}/supplier/product/${product.id}/ingredients/add"
				class="btn btn-lg btn-primary">Add</a>

		</div>
	</div>
</div>
