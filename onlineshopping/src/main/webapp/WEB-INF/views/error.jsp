<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
<meta name="description" content="Online Shopping Website Using Spring MVC and Hibernate">
<meta name="author" content="DOST XII">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>${title} - Philippine National Halal Laboratory and Halal Science
	Center</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'

	window.image = '${images}';

	window.categoryId = '';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">



<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">



<%--     <link href="${css}/bootstrap.responsive.css" rel="stylesheet">
    <link href="${css}/bootstrap.responsive.min.css" rel="stylesheet"> --%>
     
<!-- Custom CSS -->
<!-- Bootstrap Readable Theme -->

<%--   <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">   --%>
  <link href="${css}/myapp.css" rel="stylesheet"> 
 


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="wrapper">

		<%@include file="./shared/navbar.jsp"%>
			
		
		<div class="content">
		
			<div class="container">
			
				<div class="row">
				
					<div class="col-xs-12">
					
						
						<div class="jumbotron">
						
							<h3>${errorTitle}</h3>
							<hr/>
								${errorDescription}
							
						
						</div>
						
											
					</div>					
				
				</div>
			
			</div>
							
		</div>

		
		<%@include file="./shared/footer.jsp" %>

	</div>
		
	
</body>


</html>