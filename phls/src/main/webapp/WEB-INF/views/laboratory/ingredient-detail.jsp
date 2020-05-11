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
		<sf:form class="form-horizontal" modelAttribute="ingredientDetail"
			action="${contextRoot}/laboratory/product/${product.id}/ingredients/ingredient" method="POST" enctype="multipart/form-data">
			        
			<div class="modal-body">
				<table>

					<c:if test="${ingredient == null}">
					<tr>
						<td><sf:label path="ingredientId" class="control-label">Ingredient</sf:label></td>
						<td><sf:select path="ingredientId" items="${ingredients}" itemLabel="nameDesc" multiple="true" itemValue="id" class="form-control"/>
						</td>
					</tr>
					</c:if>
					
					<c:if test="${ingredient != null }">
					
					<tr>
						<td><label>Ingredient</label></td>
						<td><label> <b>${ingredient.nameDesc}</b> </label>
							<sf:input type="hidden" path="ingredientId" value="${ingredient.id}"/>
						</td>
					</tr>
					</c:if>
										
					<tr>
						<td><sf:label path="mark" class="control-label">Mark</sf:label></td>
						<td><sf:radiobutton path="mark" value="true"/> None conform to H. Standards<br/>
							<sf:radiobutton path="mark" value="false"/> Conform to H. Standards
							
						</td>
					</tr>
					<tr>
						<td><sf:label path="markDescription" class="control-label">Comment</sf:label></td>
						<td><sf:input path="markDescription" class="form-control" placeholder="Mark Comments" /></td>
					</tr>					
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td>
							<a href="${contextRoot}/laboratory/product/${product.id}/ingredients" class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
