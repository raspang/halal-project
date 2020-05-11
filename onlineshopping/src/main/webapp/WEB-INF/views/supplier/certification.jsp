<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/">Dashboard</a></li>
	<li class="breadcrumb-item active">Certification</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Certification
	</div>
	
	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="certification"
			action="${contextRoot}/supplier/certificate" method="POST" enctype="multipart/form-data">
			<div class="modal-body">
				<table>
					<tr>
						<td><sf:label path="halalCertificateNo" class="control-label">Halal Certificate No.</sf:label></td>
						<td><sf:input path="halalCertificateNo" class="form-control" placeholder="Certificate No." /></td>
					</tr>

					<tr>
						<td><sf:label path="title" class="control-label">Title</sf:label></td>
						<td><sf:input path="title" class="form-control" placeholder="Title" required="required"/></td>
					</tr>	
					
					<tr>
						<td><sf:label path="description" class="control-label">Description</sf:label></td>
						<td><sf:input path="description" class="form-control" placeholder="Description" /></td>
					</tr>
										

 
 					<tr>
						<td><sf:label path="address" class="control-label">Address</sf:label></td>
						<td><sf:input path="address" type="textarea" class="form-control" placeholder="Address" /></td>
					</tr>
					<tr>
						<td><sf:label path="local" class="control-label"></sf:label></td>
						<td><sf:radiobutton path="local" value="true" checked="checked"/> Local
							<sf:radiobutton path="local" value="false"/> International
						</td>
					</tr>														 
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td><a href="${contextRoot}/supplier/certificates"
							class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
