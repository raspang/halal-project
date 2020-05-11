<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/">Dashboard</a></li>
	<li class="breadcrumb-item active">Ingredient</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Ingredient
	</div>

	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="ingredientDetail"
			action="${contextRoot}/supplier/product/${product.id}/ingredients/ingredient" method="POST" enctype="multipart/form-data">
			        
			<div class="modal-body">
				<table>

			
					<tr>
						<td><sf:label path="ingredientId" class="control-label">Ingredient</sf:label></td>
						<td><sf:select path="ingredientId" items="${ingredients}" multiple="true" itemLabel="name" itemValue="id" class="form-control" required="required"/>
						</td>
					</tr>
					
						<sf:hidden path="mark" value="false" />
						<sf:hidden path="markDescription" value="" />
			
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td>
							<a href="${contextRoot}/supplier/product/${product.id}/ingredients" class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Add" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
