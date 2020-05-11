<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

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

<title>${title} - Philippine National Halal Laboratory and Halal
	Science Center</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'

	window.image = '${images}';

	window.categoryId = '';
</script>

<link href="${css}/bootstrap.css" rel="stylesheet">

<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<link href="${css}/myapp.css" rel="stylesheet">



</head>

<body>

	<!-- <div class="se-pre-con"></div> -->
	<div class="wrapper">



		<div class="content">


			<div class="row">

				<div class="col-md-4 col-md-offset-4">

					<div class="panel panel-primary">

						<div class="panel-heading">
							<h4>
								<img src="${images}/logo.png" width="32" alt=""><strong
									style="color: white;">Application Registration Form</strong>
							</h4>
						</div>

						<div class="panel-body">

							<sf:form method="POST" modelAttribute="supplier" action="${contextRoot}/halalregistration"
								class="form-horizontal" enctype="multipart/form-data">
								<div class="form-row">
									<p>Please provide information as much as you can.</p>
								</div>
								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="nameOfEstablishment">Company Name</label>
												<sf:input path="nameOfEstablishment" class="form-control"
													placeholder="Name Of Establishment" required="required" />
												<sf:errors path="nameOfEstablishment" cssClass="help-block"
													element="em" />
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="nameOfEstablishment">Office Address</label>
												<sf:input path="addressOfEstablishment" class="form-control"
													placeholder="Company Address" required="required" />
												<sf:errors path="addressOfEstablishment"
													cssClass="help-block" element="em" />
											</div>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="telNo">Contact No.</label>
												<sf:input path="telNo" class="form-control"
													placeholder="Contact No." required="required" />
												<sf:errors path="telNo" cssClass="help-block" element="em" />
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="form-row">

										<div class="col-md-12">
											<div class="form-label-group">
												<label for="fax">Fax</label>
												<sf:input path="fax" class="form-control" placeholder="Fax" />

											</div>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="form-row">

										<div class="col-md-12">
											<div class="form-label-group">
												<label for="personInvolved">Authorized Person</label>
												<sf:input path="personInvolved" class="form-control"
													placeholder="Authorized Person" required="required" />
												<sf:errors path="personInvolved" cssClass="help-block"
													element="em" />
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="position">Position</label>
												<sf:input path="position" class="form-control"
													placeholder="Position" required="required" />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="email">Email</label>
												<sf:input path="email" type="email" class="form-control"
													placeholder="Email" required="required" />
												<sf:errors path="email" cssClass="help-block" element="em" />
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="website">Website</label>
												<sf:input path="website" type="url" class="form-control"
													placeholder="http://XXXXXX.com" />

											</div>
										</div>
									</div>
								</div>





								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="reason">Reason for Application</label>
												<sf:input path="reason" type="textarea" class="form-control"
													placeholder="Please explain why you need the certification?"
													required="required" />

											</div>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="numOfEmployees">Number of Employees</label>
												<sf:input path="numOfEmployees" type="number"
													class="form-control" placeholder="Number of Employees" />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="productionAreaSize">Production Area Size</label>
												<sf:input path="productionAreaSize" class="form-control"
													placeholder="Production Area Size" />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-6">
											<div class="form-label-group">
												<label for="indoorArea">Indoor Area (m2)</label>
												<sf:input path="indoorArea" class="form-control"
													placeholder="Indoor Area (m2)" />

											</div>
										</div>

										<div class="col-md-6">
											<div class="form-label-group">
												<label for="openArea">Open Area (m2)</label>
												<sf:input path="openArea" class="form-control"
													placeholder="Open Area (m2)" />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-6">
											<div class="form-label-group">
												<label for="numOfRawMaterial"><br>Number of Raw
													Material Warehouses</label>
												<sf:input path="numOfRawMaterial" type="number"
													class="form-control" />

											</div>
										</div>
										<div class="col-md-6">
											<div class="form-label-group">
												<br> <label for="numProductsWarehouses">Number
													of Finished Products Warehouses</label>
												<sf:input path="numProductsWarehouses" type="number"
													class="form-control" />

											</div>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="productionCapacity">Production Capacity
													(TON/YEAR)</label>
												<sf:input path="productionCapacity" class="form-control" />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="productionLines">How many production
													lines are available and their uses(i.e. types, purposes,
													functionality, etc)</label>
												<sf:input path="productionLines" class="form-control"
													placeholder=".., .., .., .." />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="customProduction">Does company do custom
													production(like private label)</label>
												<sf:input path="customProduction" class="form-control" />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="productBrands">Brands of Products</label>
												<sf:input path="productBrands" class="form-control"
													placeholder=".., .., .., .." />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="productVarieties">Product Varieties</label>
												<sf:input path="productVarieties" class="form-control"
													placeholder=".., .., .., .." />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="productNotHalal">State products that
													will not be Halal certified? (If any)</label>
												<sf:input path="productNotHalal" type="textarea"
													class="form-control" />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="namesOfRawMaterials">Names of Raw
													Materials</label>
												<sf:input path="namesOfRawMaterials" type="textarea"
													class="form-control" placeholder=".., .., .., .., .." />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="namesOfSuppliers">Names of Suppliers</label>
												<sf:input path="namesOfSuppliers" type="textarea"
													class="form-control" placeholder=".., .., .., .., .." />

											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="productsProcess">Process Flow for each
													Product</label>
												<sf:input path="productsProcess" type="textarea"
													class="form-control" placeholder=".., .., .., .., .." />

											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="form-row">
										<div class="col-md-12">
											<div class="form-label-group">
												<label for="file">File</label>
												<sf:input path="file" type="file" class="form-control" />
											</div>
										</div>
									</div>
								</div>

								<sf:input type="hidden" path="id" />
								<sf:input type="hidden" path="updatedOn" />
								<sf:input type="hidden" path="createdOn" />
								<sf:input type="hidden" path="enable" />
								<sf:input type="hidden" path="active" />
								<sf:input type="hidden" path="code" />
								
								
								<button type="submit" class="btn btn-lg btn-primary">Submit</button>

								<a class="btn btn-lg btn-default" href="${contextRoot}/home">Cancel</a>

							</sf:form>


						</div>


					</div>


				</div>


			</div>

		</div>



		<!-- Footer comes here -->
		<%@include file="./shared/footer.jsp"%>

		<script src="${js}/jquery.min.js"></script>
		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.js"></script>



		<script src="${js}/myapp.js"></script>
</body>

</html>