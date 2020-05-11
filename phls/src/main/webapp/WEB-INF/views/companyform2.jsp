<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="vendor" value="/resources/vendor" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Online Shopping Website Using Spring MVC and Hibernate">
<meta name="author" content="DOST XII">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>${title}-PhilippineNationalHalalLaboratoryand Halal
	Science Center</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'

	window.image = '${images}';

	window.categoryId = '';
</script>

<link href="${images}/favicon.png" rel="icon">
<link href="${images}/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,400i,600,700|Raleway:300,400,400i,500,500i,700,800,900"
	rel="stylesheet">



<!-- Bootstrap core CSS-->
<link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="${vendor}/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="${vendor}/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">


<%-- <link href="${css}/responsive.bootstrap.min.css" rel="stylesheet"> --%>

<!-- Custom styles for this template-->
<link href="${css}/sb-admin.css" rel="stylesheet">


<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<!-- <div class="se-pre-con"></div> -->
	<div class="wrapper">
		
		<div class="col-md-3 col-md-offset-3">
		<div id="content-wrapper">

			<div class="container-fluid">

					<div class="panel  panel-default">
						<img src="${images}/logo.png" width="32" alt="">Register
						Application Form
					</div>

					<div class="panel-body">
						<div class="modal-body">
							<sf:form class="form-horizontal" modelAttribute="supplier"
								action="${contextRoot}/laboratory/supplier" method="POST"
								enctype="multipart/form-data">


								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="nameOfEstablishment" class="form-control"
													placeholder="Company" required="required" />
												<label for="nameOfEstablishment">Name</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="nameOfEstablishment" class="form-control"
													placeholder="Address" required="required" />
												<label for="nameOfEstablishment">Address</label>
											</div>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="telNo" class="form-control"
													placeholder="Contact No." required="required" />
												<label for="telNo">Contact No.</label>
											</div>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="fax" class="form-control" placeholder="Fax" />
												<label for="fax">Fax</label>
											</div>
										</div>
									</div>
								</div>



								<div class="form-group">
									<div class="form-row">

										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="personInvolved" class="form-control"
													placeholder="Authorized Person" required="required" />
												<label for="personInvolved">Authorized Person</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="position" class="form-control"
													placeholder="Position" required="required" />
												<label for="position">Position</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="email" type="email" class="form-control"
													placeholder="Email" required="required" />
												<label for="email">Email</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="website" class="form-control"
													placeholder="http://XXXXXX.com" />
												<label for="website">Website</label>
											</div>
										</div>
									</div>
								</div>





								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="reason" type="textarea" class="form-control"
													placeholder="Please explain why you need the certification?" />
												<label for="reason">Reason for Application</label>
											</div>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="numOfEmployees" class="form-control"
													placeholder="Number of Employees" />
												<label for="numOfEmployees">Number of Employees</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="productionAreaSize" class="form-control"
													placeholder="Production Area Size" />
												<label for="productionAreaSize">Production Area Size</label>
											</div>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="indoorArea" class="form-control"
													placeholder="Indoor Area (m2)" />
												<label for="indoorArea">Indoor Area (m2)</label>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="openArea" class="form-control"
													placeholder="Open Area (m2)" />
												<label for="openArea">Open Area (m2)</label>
											</div>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="numOfRawMaterial" class="form-control" />
												<label for="numOfRawMaterial">Number of Raw Material
													Warehouses</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="numProductsWarehouses" class="form-control" />
												<label for="numProductsWarehouses">Number of
													Finished Products Warehouses</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="productionCapacity" class="form-control" />
												<label for="productionCapacity">Production Capacity
													(TON/YEAR)</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="productionLines" class="form-control" />
												<label for="productionLines">How many production
													lines are available and their uses(i.e. types, purposes,
													functionality)</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="customProduction" class="form-control" />
												<label for="customProduction">Does company do custom
													production(like private label)</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="productBrands" class="form-control" />
												<label for="productBrands">Brands of Products</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="productVarieties" class="form-control" />
												<label for="productVarieties">Product Varieties</label>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="productNotHalal" type="textarea"
													class="form-control" />
												<label for="productNotHalal">State products that
													will not be Halal certified? (If any)</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="namesOfRawMaterials" type="textarea"
													class="form-control" />
												<label for="namesOfRawMaterials">Names of Raw
													Materials</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="namesOfSuppliers" type="textarea"
													class="form-control" />
												<label for="namesOfSuppliers">Names of Suppliers</label>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<sf:input path="productsProcess" type="textarea"
													class="form-control" />
												<label for="productsProcess">Products Process</label>
											</div>
										</div>
									</div>
								</div>
								<sf:input type="hidden" path="id" />
								<sf:input type="hidden" path="createdOn" />
								<sf:input type="hidden" path="enable" />
								<sf:input type="hidden" path="active" />
								<sf:input type="hidden" path="code" />
								<sf:input type="hidden" path="user" />
								<sf:input type="hidden" path="createdBy" />
								<a href="${contextRoot}/laboratory/suppliers"
									class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
								 <input type="submit" value="Save" class="btn btn-primary" />
							</sf:form>

						</div>


					</div>
				</div>

			</div>
		</div>



		<!-- Footer comes here -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript-->
		<script src="${vendor}/jquery/jquery.min.js"></script>
		<script src="${vendor}/bootstrap/js/bootstrap.bundle.min.js"></script>
		<script src="${js}/bootbox.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="${vendor}/jquery-easing/jquery.easing.min.js"></script>

		<!-- Page level plugin JavaScript-->
		<script src="${vendor}/chart.js/Chart.min.js"></script>
		<script src="${vendor}/datatables/jquery.dataTables.js"></script>
		<script src="${vendor}/datatables/dataTables.bootstrap4.js"></script>



		<!-- Custom scripts for all pages-->
		<script src="${js}/sb-admin.min.js"></script>

		<script src="${js}/myapp.js"></script>
	</div>

</body>

</html>