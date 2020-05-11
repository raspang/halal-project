<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item active">Setting</li>
</ol>

<c:if test="${not empty message}">
	<div class="mb-3">
		<div class="alert alert-success">${message}</div>
	</div>
</c:if>

<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Setting
	</div>

	<div class="card-body">
		<!-- Button trigger modal -->

		<h5>Printing Doc Details</h5>
		<c:forEach items="${settings}" var="setting">
			<div class="card-body">
				<div class="form-group">
					<label class="control-label">Name</label> <input type="text"
						value="${setting.name}" class="form-control" />
				</div>
				<div class="form-group">
					<label class="control-label">Title</label> <input type="text"
						value="${setting.title}" class="form-control" />
				</div>
				<div class="form-group">
					<label class="control-label">Position</label> <input type="text"
						value="${setting.position}" class="form-control" />
				</div>
			</div>
		</c:forEach>

	</div>

</div>

