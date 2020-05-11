<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item active">Product</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Product
	</div>
	
	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="onsiteAssessment"
			action="${contextRoot}/laboratory/onsiteassessment" method="POST">
			<div class="modal-body">
				<table>
		
					<c:if test="${supplier == null}" >
						<tr>
							<td><sf:label path="supplierId" class="control-label">Company</sf:label></td>
							<td><sf:select path="supplierId" items="${suppliers}" itemLabel="nameOfEstablishment" itemValue="id" multiple="true" class="form-control"/></td>						
						</tr>
					</c:if>
					<c:if test="${supplier != null}" >
						<tr>
							<td><label>Company</label></td>
							<td><b>${supplier.nameOfEstablishment}</b></td>						
						</tr>
						<sf:input type="hidden" path="supplierId" value="${supplier.id }"/>
					</c:if>
					
					<c:if test="${certification == null}" >
					<tr>
						<td><sf:label path="certificationId" class="control-label">Certification</sf:label></td>
						<td><sf:select path="certificationId" items="${certifications}" itemLabel="display" itemValue="id" multiple="true"  class="form-control"/></td>						
					</tr>
					</c:if>
					
					<c:if test="${certification != null}" >
					<tr>
						<td><label>Certification</label></td>
						<td><b>${certification.halalCertificateNo} - ${certification.title}</b></td>
						<sf:input type="hidden" path="certificationId" value="${certification.id}"/>
					</tr>
					</c:if>
										
					<tr>
						<td><sf:label path="status" class="control-label">Status</sf:label></td>
						<td>
							<sf:radiobutton path="status" value="1" checked="checked"/>No Status
							<sf:radiobutton path="status" value="2"/> In Progress
							<sf:radiobutton path="status" value="3"/> Done
						</td>
					</tr>
					<tr>
						<td><sf:label path="statusDescription" class="control-label">Comment</sf:label></td>
						<td><sf:input path="statusDescription" class="form-control" placeholder="Comment" required="required"/></td>
					</tr>
					<tr>
						<td><sf:label path="validStr" class="control-label">Validity</sf:label></td>
						<td><sf:input path="validStr" type="date" class="form-control" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td><a href="${contextRoot}/laboratory/onsiteassessments" class="btn btn-secondary">Cancel</a>
							<input type="submit" value="Save" class="btn btn-primary" />
						</td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
