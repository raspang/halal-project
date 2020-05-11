<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/staff/">Dashboard</a></li>
	<li class="breadcrumb-item"><a href="${contextRoot}/staff/products">Product</a></li>
	<li class="breadcrumb-item active">Halal Analysis</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Product Halal Analysis
	</div>

	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="halalAnalysisReport"
			action="${contextRoot}/staff/product/${product.id}/halalanalysis" method="POST" enctype="multipart/form-data">
			<div class="modal-body">
				<table>
					<c:if test="${halalParameter == null}">
					<tr>
						<td><sf:label path="halalParameterId" class="control-label">Halal Parameter</sf:label></td>
						<td>
							<sf:select path="halalParameterId" items="${halalParameters}" itemLabel="name" itemValue="id" class="form-control"/>
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
						<td><sf:label path="mark" class="control-label">Mark</sf:label></td>
						<td>
							<sf:radiobutton path="mark" value="0"  checked="checked" /> No Found
							<sf:radiobutton path="mark" value="1"/> Found
						</td>
					</tr>					
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td>
							<a href="${contextRoot}/staff/product/${product.id}/halalanalysis" class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
