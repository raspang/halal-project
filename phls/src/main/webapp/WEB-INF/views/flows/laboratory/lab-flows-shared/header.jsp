<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	window.contextRoot = '${contextRoot}'
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

	<%@include file="navbar.jsp"%>

	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">