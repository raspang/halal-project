<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/">Dashboard</a></li>
	<li class="breadcrumb-item active">Nutrition Fact</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Nutrition Fact
	</div>
	
	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="nutritionfactsparameter"
			action="${contextRoot}/supplier/nutritionfactsparameter" method="POST">
			<div class="modal-body">
				<table>
					<tr>
						<td><sf:label path="name" class="control-label">Name</sf:label></td>
						<td><sf:input path="name" class="form-control" placeholder="Name" /></td>
					</tr>

					<tr>
						<td><sf:label path="description" class="control-label">Description</sf:label></td>
						<td><sf:input path="description" type="textarea" class="form-control" placeholder="Description" /></td>
					</tr>	
															 
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td><a href="${contextRoot}/supplier/nutritionfacts"
							class="btn btn-lg btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Save" class="btn btn-lg  btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
