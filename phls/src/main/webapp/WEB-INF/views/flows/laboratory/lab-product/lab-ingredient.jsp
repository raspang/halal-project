<%@include file="../lab-flows-shared/header.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item active">Ingredient</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Ingredient
	</div>

	<div class="card-body">



		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
					<th>Ingredient Name</th>
					<th>Type</th>
					<th>Mark</th>
					<th>Description</th>
				</tr>
				<c:forEach items="${ingredientDetails}" var="i">
					<tr>
 						<td>${i.ingredientName}</td>
						<td>${i.ingredientMark}</td> 
<!-- 						<td></td>
						<td></td> -->
						<td>${i.mark}</td>
						<td>${i.markDescription}</td>
					</tr>
				</c:forEach>
			
			</table>
				<a href="${flowExecutionUrl}&_eventId_product"
						class="btn btn-lg btn-primary">Back - Product</a>
				<a href="${flowExecutionUrl}&_eventId_ingredientDetail"
						class="btn btn-lg btn-primary">Add - Ingredient</a>
				<a href="${flowExecutionUrl}&_eventId_confirm"
						class="btn btn-lg btn-primary">Next - Confirm</a>

		</div>

	</div>
</div>




<%@include file="../lab-flows-shared/footer.jsp"%>