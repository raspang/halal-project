
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/staff/">Dashboard</a></li>
	<li class="breadcrumb-item"><a
		href="${contextRoot}/staff/products">Product</a></li>
	<li class="breadcrumb-item active">Halal Parameter</li>
</ol>

<c:if test="${not empty message}">
	<div class="alert alert-success">${message}</div>
</c:if>
<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Halal Parameter
	</div>

	<div class="card-body">

			
		<h4>Company : <strong>${product.supplier.nameOfEstablishment}</strong></h4>
		<h4>Product : <strong>${product.name}</strong></h4>
		<h4>Halal Analysis  : </h4>
		
		

		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
					<th>Created On</th>
					<th>Updated On</th>
					<th>Test Method</th>
					<th>Parameter</th>
					<th>Result</th>
					<th>Unit</th>
					<th>Mark</th>
					<th>Analyst By</th>
					<th>Updated By</th>

				</tr>
				<c:forEach items="${halalAnalysisReports}" var="halalAnalysisReport">
					<tr>
						<td>${halalAnalysisReport.createdOnStr}</td>
						<td>${halalAnalysisReport.updatedOnStr}</td>
						<td>${halalAnalysisReport.testMethod}</td>
						<td>${halalAnalysisReport.halalParameter.name}</td>
						<td>${halalAnalysisReport.result}</td>
						<td>${halalAnalysisReport.unit}</td>					
						<td><c:if test="${halalAnalysisReport.mark eq 0}">
								Conform to H. Standards
							</c:if> <c:if test="${halalAnalysisReport.mark eq 1}">
								Found non-conformant to H. Standards
							</c:if>
						</td>
						<td>
						<c:if test="${halalAnalysisReport.analyst ne null}">
							${halalAnalysisReport.analyst.name}
						</c:if>
						</td>
						<td>
						<c:if test="${halalAnalysisReport.updatedBy ne null}">
							${halalAnalysisReport.updatedBy.completeName}
						</c:if>
						</td>						  

					</tr>
				</c:forEach>

			</table>

			<a href="${contextRoot}/staff/products"
				class="btn btn-lg btn-primary">Back</a>
		</div>
	</div>
</div>
