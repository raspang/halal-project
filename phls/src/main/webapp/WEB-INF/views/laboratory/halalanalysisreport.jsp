<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/products">Product</a></li>
	<li class="breadcrumb-item active">Halal Analysis</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Product Halal Analysis
	</div>

	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="halalAnalysisReport"
			action="${contextRoot}/laboratory/product/${product.id}/halalanalysis" method="POST" enctype="multipart/form-data">
			<div class="modal-body">
				<table>
				
					<tr>
						<td><sf:label path="dateSubmittedStr" class="control-label">Date Submitted</sf:label></td>
						<td>
							<sf:input path="dateSubmittedStr" type="date" class="form-control" required="required"/>
						</td>
					</tr>
					<tr>
						<td><sf:label path="fromDateAnalyzedStr" class="control-label">Started Date Analyzed </sf:label></td>
						<td>
							<sf:input path="fromDateAnalyzedStr" type="date" class="form-control" required="required"/>
						</td>
					</tr>				
					<tr>
						<td><sf:label path="toDateAnalyzedStr" class="control-label">End Date Analyzed</sf:label></td>
						<td>
							<sf:input path="toDateAnalyzedStr" type="date" class="form-control" required="required"/>
						</td>
					</tr>					
					<tr>
						<td><sf:label path="dateReportedStr" class="control-label">Date Reported</sf:label></td>
						<td>
							<sf:input path="dateReportedStr" type="date" class="form-control" required="required"/>
						</td>
					</tr>	
					<tr>
						<td><sf:label path="code" class="control-label">Code</sf:label></td>
						<td>
							<sf:input path="code" type="code" class="form-control" required="required"/>
						</td>
					</tr>											
					
					<c:if test="${halalParameter == null}">
					<tr>
						<td><sf:label path="halalParameterId" class="control-label">Halal Parameter</sf:label></td>
						<td>
							<sf:select path="halalParameterId" items="${halalParameters}" itemLabel="name" multiple="true" itemValue="id" required="required" class="form-control"/>
						</td>
					</tr>
					</c:if>
					<c:if test="${halalParameter != null}">
					<tr>
						<td><label>Halal Parameter</label></td>
						<td>
							<label><b>${halalParameter.name }</b></label>
							<sf:input type="hidden" path="halalParameterId" value="${halalParameter.id}"/>
						</td>
					</tr>
					</c:if>	
					
					<tr>
						<td><sf:label path="testMethod" class="control-label">Test Method</sf:label></td>
						<td>
							<sf:input path="testMethod" class="form-control" required="required"/>
						</td>
					</tr>
					<tr>
						<td><sf:label path="result" class="control-label">Result</sf:label></td>
						<td>
							<sf:input path="result" class="form-control" required="required"/>
						</td>
					</tr>					
					<tr>
						<td><sf:label path="unit" class="control-label">Unit</sf:label></td>
						<td>
							<sf:input path="unit" class="form-control" required="required"/>
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
						<td><sf:label path="mark" class="control-label">Mark</sf:label></td>
						<td>
							<sf:radiobutton path="mark" value="0"  checked="checked" /> Conform to H. Standards <br/>
							<sf:radiobutton path="mark" value="1"/> None conform to H. Standards
						</td>
					</tr>					
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td>
							<a href="${contextRoot}/laboratory/product/${product.id}/halalanalysis" class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
