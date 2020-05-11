<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
	content="DOST 12 - Halal Laboratory website">
<meta name="author" content="DOST XII">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">


<title>${title} - Philippine National Halal Laboratory and Halal
	Science Center</title>
<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
	
	
	
</script>

<!-- Bootstrap core CSS-->
<link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="${vendor}/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="${vendor}/datatables/dataTables.bootstrap4.css" rel="stylesheet">


<%-- <link href="${css}/responsive.bootstrap.min.css" rel="stylesheet"> --%>

<!-- Custom styles for this template-->
<link href="${css}/sb-admin.css" rel="stylesheet">


</head>

<body id="page-top">

	<%@include file="laboratory/shared/navbar.jsp"%>

	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="laboratory/shared/sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">


				<c:if test="${userClickDashboard == true }">
					<%@include file="laboratory/dashboard.jsp"%>
				</c:if>

				<c:if test="${userClickOnsiteAssessments == true }">
					<%@include file="laboratory/manageOnsite.jsp"%>
				</c:if>	
				
				<c:if test="${userClickProducts == true }">
					<%@include file="laboratory/manageProduct.jsp"%>
				</c:if>

				<c:if test="${userClickSupplier == true }">
					<%@include file="laboratory/manageSupplier.jsp"%>
				</c:if>

				<c:if test="${userClickIngredient == true }">
					<%@include file="laboratory/manageIngredient.jsp"%>
				</c:if>

				<c:if test="${userClickShipment == true }">
					<%@include file="laboratory/manageShipment.jsp"%>
				</c:if>

				<c:if test="${userClickCertificate == true }">
					<%@include file="laboratory/manageCertification.jsp"%>
				</c:if>

				<c:if test="${userClickCats == true }">
					<%@include file="laboratory/manageCategory.jsp"%>
				</c:if>
				<c:if test="${userClickCat == true }">
					<%@include file="laboratory/category.jsp"%>
				</c:if>

				<c:if test="${productForm == true }">
					<%@include file="laboratory/product.jsp"%>
				</c:if>

				<c:if test="${ingredientForm == true }">
					<%@include file="laboratory/ingredient.jsp"%>
				</c:if>
	
				<c:if test="${productIngredientsForm == true }">
					<%@include file="laboratory/product-ingredient.jsp"%>
				</c:if>	
	
				<c:if test="${productIngredientDetailForm == true }">
					<%@include file="laboratory/ingredient-detail.jsp"%>
				</c:if>		
	
				<c:if test="${supplierForm == true }">
					<%@include file="laboratory/supplier.jsp"%>
				</c:if>		
	
				<c:if test="${supplierProductsForm == true }">
					<%@include file="laboratory/supplier-product.jsp"%>
				</c:if>	
								
								
				<c:if test="${onsiteAssessmentForm == true }">
					<%@include file="laboratory/onsiteassessment.jsp"%>
				</c:if>	

				<c:if test="${userClickNutritionfact == true }">
					<%@include file="laboratory/manageNutritionFacts.jsp"%>
				</c:if>	
								
				<c:if test="${nutritionfactsForm == true }">
					<%@include file="laboratory/nutritionfact.jsp"%>
				</c:if>	
				
				<c:if test="${userClickHalalParameters == true }">
					<%@include file="laboratory/manageHalalParameter.jsp"%>
				</c:if>	
				<c:if test="${halalParamForm == true }">
					<%@include file="laboratory/halalparameter.jsp"%>
				</c:if>									
				              
				<c:if test="${productHalalParamForm == true }">
					<%@include file="laboratory/product-halalanalysis.jsp"%>
				</c:if>					
				
				<c:if test="${halalAnalysisReportForm == true }">
					<%@include file="laboratory/halalanalysisreport.jsp"%>
				</c:if>
	
				<c:if test="${productNutritionFactsParamForm == true }">
					<%@include file="laboratory/product-nutritionfactsresult.jsp"%>
				</c:if>					
				
				<c:if test="${nutritionFactsResultForm == true }">
					<%@include file="laboratory/nutritionfactsresult.jsp"%>
				</c:if>
				
				<c:if test="${certificateForm == true }">
					<%@include file="laboratory/certification.jsp"%>
				</c:if>
				
				<c:if test="${userClickSetting == true }">
					<%@include file="laboratory/setting.jsp"%>
				</c:if>

				<c:if test="${userClickPersonnels == true }">
					<%@include file="laboratory/managePersonnel.jsp"%>
				</c:if>
								
				<c:if test="${personnelForm == true }">
					<%@include file="laboratory/personnel.jsp"%>
				</c:if>
				
				<c:if test="${userClickOnsiteAddress == true }">
					<%@include file="laboratory/onsiteAddress.jsp"%>
				</c:if>			
				
								
			</div>
			<!-- /.container-fluid -->
			<%@include file="laboratory/shared/footer.jsp"%>

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="${contextRoot}/logout">Logout</a>
				</div>
			</div>
		</div>
	</div>


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
    <script src="${js}/myDatabaseTable.js"></script>

    
    
</body>

</html>
