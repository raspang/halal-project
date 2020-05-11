
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier">Dashboard</a></li>
	<li class="breadcrumb-item active">Supplier</li>
</ol>
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Supplier
	</div>

	<div class="card-body">
		<h4>${supplier.nameOfEstablishment}</h4>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
					<th></th>
					<th>Product Code</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Weight</th>
					<th></th>
				</tr>
				<c:forEach items="${products}" var="product">
					<tr>
						<td><img src="${contextRoot}/resources/images/${product.code}.png" class="dataTableImg"/></td>	
						<td>${product.code}</td>
 						<td>${product.name}</td>
						<td>${product.description}</td> 
						<td>${product.weight}</td>
						<td>
							<a href="${contextRoot}/supplier/product?id=${product.id}&supplierId=${supplier.id}"><i class="fas fa-edit"></i></a> | 
							<a href="${contextRoot}/supplier/product/${product.id}/delete?supplierId=${supplier.id}" data-confirm="Are you sure you want to delete the product?"><i class="fas fa-trash-alt"></i></a>													                        
						</td>
					</tr>
				</c:forEach>
			
			</table>
			<a href="${contextRoot}/supplier/suppliers" class="btn btn-lg btn-primary">Back</a>
			<a href="${contextRoot}/supplier/product?supplierId=${supplier.id}" class="btn btn-lg btn-primary">Add</a>
		

		</div>
	</div>
</div>
