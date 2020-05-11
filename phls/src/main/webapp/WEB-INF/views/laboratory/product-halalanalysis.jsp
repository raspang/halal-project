
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item"><a
		href="${contextRoot}/laboratory/products">Product</a></li>
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
					<th></th>
					<th></th>
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
						<td><a href="${contextRoot}/laboratory/product/${product.id}/halalanalysis/pdf?halalanalysisid=${halalAnalysisReport.id}" target="_blank"><i class="fas fa-file-pdf"></i></a></td>
						<td><a
							href="${contextRoot}/laboratory/product/${product.id}/halalanalysis?halalanalysisId=${halalAnalysisReport.id}"><i
								class="fas fa-edit"></i></a>| <a href="#" data-toggle="modal"
							data-target="#mymodal${halalAnalysisReport.id}"><i
								class="fas fa-trash-alt"></i></a>

							<div id="mymodal${halalAnalysisReport.id}" class="modal fade"
								tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">

										<div class="modal-header">
											<h4 class="modal-title">Delete</h4>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>

										</div>
										<div class="modal-body">
											<p>Are you sure you want to delete?</p>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<a
												href="${contextRoot}/laboratory/product/${product.id}/halalanalysis/${halalAnalysisReport.id}/delete"
												class="btn btn-danger">Delete</a>
										</div>

									</div>
								</div>
							</div></td>
					</tr>
				</c:forEach>

			</table>

			<a href="${contextRoot}/laboratory/products"
				class="btn btn-lg btn-primary">Back</a> <a
				href="${contextRoot}/laboratory/product/${product.id}/halalanalysis/add"
				class="btn btn-lg btn-primary">Add</a>

		</div>
	</div>
</div>
