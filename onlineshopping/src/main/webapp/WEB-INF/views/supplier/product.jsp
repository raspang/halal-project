<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/">Dashboard</a></li>
	<li class="breadcrumb-item active">Product</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Product
	</div>

	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="product"
			action="${contextRoot}/supplier/product" method="POST"
			enctype="multipart/form-data">
			<div class="modal-body">
				<table>
					<tr>
						<td><sf:label path="code" class="control-label">Code</sf:label></td>
						<td>
							<c:if test="${edit}">
								<sf:input path="code" class="form-control" placeholder="Product Code" required="required" readonly="true" />
							</c:if>
							<c:if test="${not edit}">
								<sf:input path="code" class="form-control" placeholder="Product Code" required="required" />
							</c:if></td>

					</tr>
					<tr>
						<td><sf:label path="name" class="control-label">Name</sf:label></td>
						<td><sf:input path="name" class="form-control" placeholder="Product Name" /></td>
					</tr>
					<tr>
						<td><sf:label path="categoryId" class="control-label">Category</sf:label></td>
						<td><sf:select path="categoryId" items="${categories}" itemLabel="name" itemValue="id" class="form-control" /></td>
					</tr>
					<tr>
						<td><sf:label path="description" class="control-label">Description</sf:label></td>
						<td><sf:input path="description" class="form-control" placeholder="Description" /></td>
					</tr>
					<tr>
						<td><sf:label path="brand" class="control-label">Brand</sf:label></td>
						<td><sf:input path="brand" class="form-control" placeholder="Brand" /></td>
					</tr>
					<tr>
						<td><sf:label path="quantity" class="control-label">Quantity</sf:label></td>
						<td><sf:input path="quantity" type="number" class="form-control" placeholder="Quantity" /></td>
					</tr>
					<tr>
						<td><sf:label path="unitPrice" class="control-label">Price</sf:label></td>
						<td><sf:input path="unitPrice" type="number" class="form-control" placeholder="Price" /></td>
					</tr>
					<tr>
						<td><sf:label path="weight" class="control-label">Weight</sf:label></td>
						<td><sf:input path="weight" class="form-control" placeholder="Weight" /></td>
					</tr>

					<tr>
						<td><sf:label path="file" class="control-label">File upload</sf:label></td>
						<td><sf:input path="file" type="file" class="form-control" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>

					<td>
						<sf:input type="hidden" path="supplierId" value="${supplier.id}" />
						<sf:input type="hidden" path="id" />
						<sf:input type="hidden" path="displayed" />
						<sf:input type="hidden" path="createdOn" />
						
						<a href="${contextRoot}/supplier/products" class="btn btn-secondary">Cancel</a>	
						<input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
