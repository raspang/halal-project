<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/products">Product</a></li>
	<li class="breadcrumb-item active">Nutrition Facts Result</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Product Nutrition Facts Result
	</div>

	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="nutritionFactsResult"
			action="${contextRoot}/laboratory/product/${product.id}/nutritionfactsresult" method="POST">
			<div class="modal-body">
				<table>
<%-- 					<c:if test="${ nutritionFactsParameter == null}">
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
					</c:if> --%>
					
					<tr>
						<td><sf:label path="dateReportedStr" class="control-label">Date Reported</sf:label></td>
						<td>
							<sf:input path="dateReportedStr" type="date" class="form-control"/>
						</td>
					</tr>
									
					<tr>
						<td><sf:label path="dateEvaluationStr" class="control-label">Date Evaluation</sf:label></td>
						<td>
							<sf:input path="dateEvaluationStr" type="date" class="form-control"/>
						</td>
					</tr>
						
					<tr>
						<td><sf:label path="referenceNo" class="control-label">Code</sf:label></td>
						<td>
							<sf:input path="referenceNo"  class="form-control"/>
						</td>
					</tr>
					<c:if test="${analyst eq null}">
					<tr>
						<td><sf:label path="analystId" class="control-label">Analyst By</sf:label></td>
						<td>
							<sf:select path="analystId" items="${analysts}" itemLabel="name" multiple="true" itemValue="id" required="required" class="form-control"/>
						</td>
					</tr>
					</c:if>
					<c:if test="${analyst ne null}">
						<td><label>Analyst By</label></td>
						<td>
							<label><b>${analyst.name }</b></label>
							<sf:input type="hidden" path="analystId" value="${analyst.id}"/>
						</td>
					</c:if>					
			
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td>
							<a href="${contextRoot}/laboratory/product/${product.id}/nutritionfactsresult" class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
