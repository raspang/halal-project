<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item active">Onsite Address</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Onsite Address
	</div>
	
	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="onsiteAddress"
			action="${contextRoot}/laboratory/onsiteaddress" method="POST" >
			<div class="modal-body">
				<table>
					<tr>
						<td><sf:label path="firstName" class="control-label">Address Line 1</sf:label></td>
						<td><sf:input path="firstName" class="form-control" placeholder="First Name." required="required"/></td>
					</tr>

					<tr>
						<td><sf:label path="middleName" class="control-label">Address Line 2</sf:label></td>
						<td><sf:input path="middleName" class="form-control" placeholder="Middle Name" /></td>
					</tr>					
					<tr>
						<td><sf:label path="lastName" class="control-label">City</sf:label></td>
						<td><sf:input path="lastName" class="form-control" placeholder="Last Name" required="required"/></td>
					</tr>
								 
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td><a href="${contextRoot}/laboratory/personnels" class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
