
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
		<h4>${product.name}</h4>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
					<th>Ingredient Name</th>
					<th>Type Of Ingredient</th>
					<th>Mark</th>
					<th>Description</th>
					<th></th>
				</tr>
				<c:forEach items="${ingredientDetails}" var="ingredient">
					<tr>
 						<td>${ingredient.ingredient.name}</td>
						<td>
						<c:if test = "${ingredient.ingredient.critical}">
							CRITICAL
						</c:if>
						<c:if test = "${not ingredient.ingredient.critical}">
							SAFE
						</c:if>						
						</td> 
						<td>
						<c:if test = "${ingredient.mark}">
							HARAM
						</c:if>
						<c:if test = "${not ingredient.mark}">
							HALAL
						</c:if>							
						</td>
						<td>${ingredient.markDescription}</td>
						<td>
							<a href="${contextRoot}/supplier/product/${product.id}/ingredients/${ingredient.id}/delete" data-confirm="Are you sure you want to delete?">Delete</a>
							                        
						</td>
					</tr>
				</c:forEach>
			
			</table>
			<a href="${contextRoot}/supplier/products" class="btn btn-lg btn-primary">Back</a>
			<button type="button"  class="btn btn-lg btn-primary" data-toggle="modal" data-target="#modalIngredientDetailId">Add</button>

		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="modalIngredientDetailId" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Ingredient Detail</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
																										
			<sf:form class="form-horizontal" modelAttribute="ingredientDetail"  action="${contextRoot}/supplier/product/${product.id}/ingredients/ingredient" method="POST"
			enctype="multipart/form-data">
				<div class="modal-body">
				
				<div class="form-group">
					<label class="control-label col-md-4">Ingredient Name</label>
					<div class="col-md-8 validate">
						<sf:select path="ingredientId" items="${ingredients}" itemLabel="name" itemValue="id" class="form-control"/>
					</div>
				</div>
				

				<div class="form-group">
					<label class="control-label col-md-4">Mark</label>
					<div class="col-md-8 validate">
						<sf:radiobutton path="mark" value="false"  checked="checked" /> Halal
						<sf:radiobutton path="mark" value="true"/> Haram
					</div>
				</div>
  				
 				<div class="form-group">
					<label class="control-label col-md-4">Description</label>
					<div class="col-md-8 validate">
						<sf:input type="textarea" path="markDescription" class="form-control" placeholder="Mark Description" /> 
					</div>
				</div>
				 				
				<sf:hidden path="productId" value="${productId}"/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					 <button type="Submit" class="btn btn-primary">Save</button>
				</div>
			</sf:form>
		</div>
	</div>
</div>