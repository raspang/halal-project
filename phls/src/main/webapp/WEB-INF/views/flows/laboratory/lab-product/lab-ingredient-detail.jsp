<%@include file="../lab-flows-shared/header.jsp"%>


<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item active">Ingredient</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Ingredient Detail
	</div>

	<div class="card-body">


		<sf:form class="form-horizontal" modelAttribute="ingredientDetail"
			method="POST">
			<%-- 		enctype="multipart/form-data" --%>

			<div class="modal-body">
				<table>

  					<tr>
						<td><sf:label path="ingredientId" class="control-label">Ingredient</sf:label></td>
						<td><sf:select path="ingredientId" items="${ingredients}" itemLabel="name" itemValue="id" class="form-control" /></td>

					</tr> 
					<tr>
						<td><sf:label path="mark" class="control-label">Mark</sf:label></td>
						<td><label class="radio-inline"> 
								<sf:radiobutton path="mark" value="false" checked="checked" />&nbsp;Halal
							</label> 
							<label class="radio-inline"> 
								<sf:radiobutton path="mark" value="true" />&nbsp;Haram
						</label></td>
					</tr>
					<tr>
						<td><sf:label path="markDescription" class="control-label">Description</sf:label></td>
						<td><sf:input path="markDescription" class="form-control" placeholder="Mark Description" /></td>
					</tr>
					<tr>
						<td><sf:label path="productId" class="control-label">Product</sf:label></td>
						<td><sf:select path="productId" items="${products}"
								itemLabel="name" itemValue="id" class="form-control" /></td>

					</tr>					
					<tr>
			
						<td>&nbsp;</td>
					</tr>
					<tr>
	
						<td>

							<button type="submit" name="_eventId_ingredient"
																 
								class="btn btn-lg btn-primary">
								Add<span class="glyphicon glyphicon-chevron-right"></span> 
							</button>
						</td>

					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>




<%@include file="../lab-flows-shared/footer.jsp"%>