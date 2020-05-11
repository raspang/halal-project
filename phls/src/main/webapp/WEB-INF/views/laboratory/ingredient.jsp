<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item active">Category</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Product
	</div>

	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="ingredient"
			action="${contextRoot}/laboratory/ingredient" method="POST">
			<div class="modal-body">
				<table>
					<c:if test="${ingredient == null}">
						<tr>
							<td><sf:label path="name" class="control-label">Name</sf:label></td>
							<td><sf:input path="name" class="form-control"
									placeholder="Ingredient Name" /></td>
						</tr>
					</c:if>
					<c:if test="${ingredient != null}">
						<tr>
							<td><label>Name</label></td>
							<td><label>${ingredient.name }</label></td>
						</tr>
					</c:if>
					
					<tr>
						<td><sf:label path="description" class="control-label">Description</sf:label></td>
						<td><sf:input path="description" class="form-control"
								placeholder="Description" /></td>

					</tr>

					<tr>
						<td><sf:label path="critical" class="control-label">Mark</sf:label></td>
						<td><sf:radiobutton path="critical" value="false"
								checked="checked" /> None Critical <sf:radiobutton
								path="critical" value="true" /> Critical</td>
					</tr>

					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td><a href="${contextRoot}/laboratory/ingredients"
							class="btn btn-secondary">Cancel</a>&nbsp;&nbsp; <input
							type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
