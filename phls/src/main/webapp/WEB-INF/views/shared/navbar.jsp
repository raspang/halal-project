<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<script>
	window.userRole = '${userModel.role}';

</script>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				
				<li><a href="http://www.gov.ph"><img
						src="${images}/govph.png" width="27" alt=""></a></li>
				<li><a href="http://dost.gov.ph"><img
						src="${images}/dost.png" width="28" alt=""></a></li>
				<li><a href="${contextRoot}/home"><img
						src="${images}/logo.png" width="33" alt=""></a></li>
				

				<li><a href="${contextRoot}/home">Home</a></li>

				<li id="enterprise"><a href="${contextRoot}/enterprise">Service</a>
				</li>

				<li id="about"><a href="${contextRoot}/about">About Us</a></li>
				<li id="contact"><a href="${contextRoot}/contact">Contact</a></li>

				<li id="login">
					<a href="${contextRoot}/login"><b>Login</b></a></li>
					
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li id="signup"><a href="${contextRoot}/membership">Sign Up</a></li>
					<li id="login"><a href="${contextRoot}/login">Login</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="dropdown" id="userModel"><a
						class="btn dropdown-toggle" href="javascript:void(0)"
						id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="true"> ${userModel.fullName} <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
<%-- 							<security:authorize access="hasAuthority('USER')">
								<li id="cart"><a href="${contextRoot}/cart/show"> <span
										class="glyphicon glyphicon-shopping-cart"></span>&#160; <span
										class="badge">${userModel.cart.cartLines}</span> &#8369;
										${userModel.cart.grandTotal}
								</a></li>
								<li role="separator" class="divider"></li>
							</security:authorize> --%>
							<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
						</ul>
					</li>
				</security:authorize>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>

