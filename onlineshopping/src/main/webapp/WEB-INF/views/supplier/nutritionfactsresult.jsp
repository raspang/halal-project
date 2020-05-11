<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/">Dashboard</a></li>
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/products">Product</a></li>
	<li class="breadcrumb-item active">Nutrition Facts Result</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Product Nutrition Facts Result
	</div>

	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="nutritionFactsResult"
			action="${contextRoot}/supplier/product/${product.id}/nutritionfactsresult" method="POST" enctype="multipart/form-data">
			<div class="modal-body">
				<table>
					<c:if test="${ nutritionFactsParameter == null}">
					<tr>
						<td><sf:label path="nutritionFactsParameterId" class="control-label">Parameter Name</sf:label></td>
						<td>
							<sf:select path="nutritionFactsParameterId" items="${nutritionFactsParameters}" itemLabel="name" itemValue="id" class="form-control"/>
						</td>
					</tr>
					</c:if>
					<c:if test="${ nutritionFactsParameter != null}">
					<tr>
						<td><label>Parameter Name</label></td>
						<td>
							<label> <b>${nutritionFactsParameter.name}</b> </label>
							<sf:input type="hidden" path="nutritionFactsParameterId" value="${nutritionFactsParameter.id}"/>
						</td>
					</tr>
					</c:if>
										
					<tr>
						<td><sf:label path="value" class="control-label">Value</sf:label></td>
						<td>
							<sf:input path="value" class="form-control" required="required"/>
						</td>
					</tr>					
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td>
							<a href="${contextRoot}/supplier/product/${product.id}/nutritionfactsresult" class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
