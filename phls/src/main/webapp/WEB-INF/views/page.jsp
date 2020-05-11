<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="lib" value="/resources/lib" />
<spring:url var="contactform" value="/resources/contactform" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Philippine National Halal Laboratory and Science Center</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="DOST12 halal laboratory" name="keywords">
<meta content="" name="description">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<script>
	window.lib = '${lib}';
</script>
<!-- Favicons -->
<link href="${images}/favicon.png" rel="icon">
<link href="${images}/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,400i,600,700|Raleway:300,400,400i,500,500i,700,800,900"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="${lib}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="${lib}/nivo-slider/css/nivo-slider.css" rel="stylesheet">
<link href="${lib}/owlcarousel/owl.carousel.css" rel="stylesheet">
<link href="${lib}/owlcarousel/owl.transitions.css" rel="stylesheet">
<link href="${lib}/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${lib}/animate/animate.min.css" rel="stylesheet">
<link href="${lib}/venobox/venobox.css" rel="stylesheet">

<!-- Nivo Slider Theme -->
<link href="${css}/nivo-slider-theme.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="${css}/style.css" rel="stylesheet">

<!-- Responsive Stylesheet File -->
<link href="${css}/responsive.css" rel="stylesheet">

<!-- =======================================================
    Theme Name: eBusiness
    Theme URL: https://bootstrapmade.com/ebusiness-bootstrap-corporate-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
</head>

<body data-spy="scroll" data-target="#navbar-example">

	<div id="preloader"></div>

	<header>
		<!-- header-area start -->
		<div id="sticker" class="header-area">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-sm-12">

						<!-- Navigation -->
						<nav class="navbar navbar-default">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
								<button type="button" class="navbar-toggle collapsed"
									data-toggle="collapse"
									data-target=".bs-example-navbar-collapse-1"
									aria-expanded="false">
									<span class="sr-only">Toggle navigation</span> <span
										class="icon-bar"></span> <span class="icon-bar"></span> <span
										class="icon-bar"></span>
								</button>
								<!-- Brand -->
								<div class="logo">
									<a href="https://www.gov.ph/"> <img
										style="margin: 20px 0px" width="32px" height="32px"
										src="${images}/nav/govph.png">
									</a> <a href="http://region12.dost.gov.ph/"> <img
										style="margin: 20px 0px" width="32px" height="32px"
										src="${images}/nav/dost.png">
									</a>
								</div>

								<!--  <a class="navbar-brand page-scroll sticky-logo" href="index.html">
                  <h1><span>e</span>Business</h1> -->
								<!-- Uncomment below if you prefer to use an image logo -->
								<!-- <img src="img/logo.png" alt="" title=""> -->
								</a>
							</div>
							<!-- Collect the nav links, forms, and other content for toggling -->
							<div
								class="collapse navbar-collapse main-menu bs-example-navbar-collapse-1"
								id="navbar-example">
								<ul class="nav navbar-nav navbar-right">
									<li class="active"><a class="page-scroll" href="#home"><i
											class="fa fa-home"></i>Home</a></li>
									<li><a class="page-scroll" href="#about"><i
											class="fa fa-info-circle"></i>About Us</a></li>
									<li><a class="page-scroll" href="#services"><i
											class="fa fa-flask"></i>Services</a></li>
									<li><a class="page-scroll" href="#team"><i
											class="fa fa-spinner"></i>Process</a></li>


									<!--   <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Drop Down<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                      <li><a href=# >Drop Down 1</a></li>
                      <li><a href=# >Drop Down 2</a></li>
                    </ul> 
                  </li>-->

									<li><a class="page-scroll" href="#blog">News</a></li>
									<li><a class="page-scroll" href="#contact">Contact</a></li>
									<li><a href="${contextRoot}/login"><i
											class="fa fa-sign-in"></i>Login</a></li>
								</ul>
							</div>
							<!-- navbar-collapse -->
						</nav>
						<!-- END: Navigation -->
					</div>
				</div>
			</div>
		</div>
		<!-- header-area end -->
	</header>
	<!-- header end -->

	<!-- Start Slider Area -->
	<div id="home" class="slider-area">
		<div class="bend niceties preview-2">
			<div id="ensign-nivoslider" class="slides">
				<img src="${images}/slider/slider3.jpg" alt=""
					title="#slider-direction-1" /> <img
					src="${images}/slider/slider3.jpg" alt=""
					title="#slider-direction-2" /> <img
					src="${images}/slider/slider3.jpg" alt=""
					title="#slider-direction-3" />
			</div>

			<!-- direction 1 -->
			<div id="slider-direction-1" class="slider-direction slider-one">
				<div class="container">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="slider-content">
								<!-- layer 1 -->
								<div class="layer-1-1 hidden-xs wow slideInDown"
									data-wow-duration="2s" data-wow-delay=".2s">
									<h2 class="title1">The Philippine Science and Technology
										Laboratory for the Development of the Halal Industry</h2>
								</div>
								<!-- layer 2 -->
								<div class="layer-1-2 wow slideInUp" data-wow-duration="2s"
									data-wow-delay=".1s">
									<h1 class="title2">DOST XII - Halal Laboratory</h1>
								</div>
								<!-- layer 3 -->
								<div class="layer-1-3 hidden-xs wow slideInUp"
									data-wow-duration="2s" data-wow-delay=".2s">
									<a class="ready-btn right-btn page-scroll" href="#services">See
										Services</a> <a class="ready-btn page-scroll" href="#about">Learn
										More</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- direction 2 -->
			<div id="slider-direction-2" class="slider-direction slider-two">
				<div class="container">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="slider-content text-center">
								<!-- layer 1 -->
								<div class="layer-1-1 hidden-xs wow slideInUp"
									data-wow-duration="2s" data-wow-delay=".2s">
									<h2 class="title1">DOST XII - Halal Laboratory</h2>
								</div>
								<!-- layer 2 -->
								<div class="layer-1-2 wow slideInUp" data-wow-duration="2s"
									data-wow-delay=".1s">
									<h1 class="title2">Be Halal Certified Now!</h1>
								</div>
								<!-- layer 3 -->
								<div class="layer-1-3 hidden-xs wow slideInUp"
									data-wow-duration="2s" data-wow-delay=".2s">
									<a class="ready-btn right-btn page-scroll" href="#services">See
										Services</a> <a class="ready-btn page-scroll" href="#about">Learn
										More</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- direction 3 -->
			<div id="slider-direction-3" class="slider-direction slider-two">
				<div class="container">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="slider-content">
								<!-- layer 1 -->
								<div class="layer-1-1 hidden-xs wow slideInUp"
									data-wow-duration="2s" data-wow-delay=".2s">
									<h2 class="title1">PNHLHSC is the premier institution
										under the Department of Science and Technology Regional Office
										12 in the Republic of the Philippines.</h2>
								</div>
								<!-- layer 2 -->
								<div class="layer-1-2 wow slideInUp" data-wow-duration="2s"
									data-wow-delay=".1s">
									<h1 class="title2">Philippine National Halal Laboratory
										and Science Center</h1>
								</div>
								<!-- layer 3 -->
								<div class="layer-1-3 hidden-xs wow slideInUp"
									data-wow-duration="2s" data-wow-delay=".2s">
									<a class="ready-btn right-btn page-scroll" href="#services">See
										Services</a> <a class="ready-btn page-scroll" href="#about">Learn
										More</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Slider Area -->





	<!-- Start About area -->
	<div id="about" class="about-area area-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="section-headline section-headline text-center">
						<h2>
							<i class="fa fa-info-circle"></i>About DOST XII - Philippine
							National Halal Laboratory and Science Center
						</h2>
					</div>
					<p>The Philippines National Halal Laboratory and Halal Science
						Center is the premier institution under the Department of Science
						and Technology Regional Office 12 in the Republic of the
						Philippines.</p>
					<p>The PNHLHSC is manned and managed by competent and dedicated
						Muslim Ranking Officials, scientists and employees that ensures
						authenticity of results from tests and analysis of Products and
						maintain integrity and discipline to sustain customers trusts and
						confidence for the certified by the PNHCL Halal Products made by
						Filipino Manufacturers and exported from the Philippines to the
						global markets.</p>
					<p>The PNHLHSC is equipped with state of the art laboratory
						equipment indispensable to determine the genuineness of Halal
						Products and can guarantee that its certified Halal Products of
						the manufacturers being supplied to the local and international
						consumers are authentic and free from adulteration and critical
						ingredients.</p>
					<p>The PNHLHSC is the main source of science and technology on
						Halal that can assist Halal patrons, practitioner, scientists and
						technologists including researchers and the academe and those that
						vested their interest upon Halal for their economic prosperity and
						physical wellness and improvements.</p>

				</div>
			</div>

			<div class="row">
				<!-- single-well start-->
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="well-left">
						<div class="single-well">
							<!-- <a href="#"> -->
							<img src="${images}/about/mandate.jpg" alt="">

						</div>
					</div>
				</div>
				<!-- single-well end-->
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="well-middle">
						<div class="single-well">
							<!--  <a href="#"> -->
							<br /> <br />
							<!-- 							<br />
							<h4 class="sec-head">Our Mandate</h4> -->

							<p class="card-text">The Philippine National Halal Centre and
								Laboratory is mandated to coordinate science and technology on
								Halal and ensure that the results therefrom will be utilized for
								the maximum benefits of the producers and consumers of Halal
								products.</p>
						</div>
					</div>
				</div>
				<!-- End col-->
			</div>
			<hr />

			<div class="row">

				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="well-middle">
						<div class="single-well">
							<!--  <a href="#"> -->
							<br /> <br />
							<!-- 							 <br />
							<h4 class="sec-headright">Our Vision</h4> -->

							<p class="card-text" style="text-align: right">By 2020, the
								Philippine National Halal Centre and Laboratory will be the main
								passport of Halal Industry Products for both local and
								international consumers and the source of Halal knowledge for
								scientists, researchers and practitioners.</p>
						</div>
					</div>
				</div>
				<!-- End col-->
				<!-- single-well start-->
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="well-left">
						<div class="single-well">
							<!-- <a href="#"> -->
							<img src="${images}/about/vision.jpg" alt=""> </a>
						</div>
					</div>
				</div>
				<!-- single-well end-->
			</div>

		</div>
	</div>
	<!-- End About area -->







	<!-- Start Service area -->

	<div id="services" class="services-area area-padding">

		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="section-headline services-head text-center">
						<h2>Our Services</h2>

					</div>
				</div>
			</div>
			<div class="row text-center">
				<div class="services-contents">
					<!-- Start Left services -->
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="about-move">
							<div class="services-details">
								<div class="single-services">
									<a class="services-icon" href="#"> <i
										class="fa fa-handshake-o"></i>
									</a>
									<h4>Halal Consultancy</h4>
<!-- 									<p class="sec-headjustify">Services has dedicated field of
										specialize in the Halal market. We've anticipated the rapid
										rise in interest during this field, and that we have dedicated
										ourselves to developing specific experience in this niche
										sector. Through our network of contacts in governments, trade
										stakeholders, NGOs and Islamic agencies, DOST Region XII
										Consultants has designed up a unique, dynamically evolving
										image of the Halal market globally. At DOST XII, we provide
										consulting services to SME’s, Governments, Business
										Stakeholders, service suppliers and different agencies seeking
										to extend their competitive advantage during this advanced and
										apace dynamical sector.</p> -->
								</div>
							</div>
							<!-- end about-details -->
						</div>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="about-move">
							<div class="services-details">
								<div class="single-services">
									<a class="services-icon" href="#"> <i
										class="fa fa-certificate"></i>

									</a>
									<h4>Halal Certification</h4>
<!-- 									<p class="sec-headjustify">This is one certification that
										food institutions can attempt to acquire. As a result, it will
										increase their client base. Individuals will touch on problems
										relating to culture, or spiritual harmony. However, as an area
										wherever we tend to far-famed for our food, the halal
										certification is perhaps one amongst the most important
										impacts of Islam Globally.DOST XII certifies the product
										underneath the reverent coordination of recognized Islamic law
										higher-up Board, extremely qualified Food Technologists, and
										R&D professionals in respect of eligibility for Certification
										through analysis primarily based methodology scrutinizing the
										sources of ingredients, examining the whole supply chain,
										chemical examination and analyzing Islamic law prospects of
										ingredients utilized in the product.</p> -->
								</div>
							</div>
							<!-- end about-details -->
						</div>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<!-- end col-md-4 -->
						<div class=" about-move">
							<div class="services-details">
								<div class="single-services">
									<a class="services-icon" href="#"> <i
										class="fa fa-binoculars"></i>
									</a>
									<h4>Halal Research and Development</h4>
<!-- 									<p class="sec-headjustify">To Establish Halal work
										Synergize with Government and Non Government authorities for
										Halal Research and Development. Develop a Globally network for
										Halal business analysis for sharing the experience
										internationally.The Halal world market is promising a fast and
										sustained growth. The reasons of the prompt growing are
										multiple. The importance of this market has on the worldwide
										scene, discussing in-depth development from the social control
										and innovation management views. galvanized by this chance,
										DOST XII try to explore comprehensive innovation method
										leading firms from Haram to Halal product within the food
										business.</p> -->
								</div>
							</div>
							<!-- end about-details -->
						</div>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<!-- end col-md-4 -->
						<div class=" about-move">
							<div class="services-details">
								<div class="single-services">
									<a class="services-icon" href="#"> <i class="fa fa-flask"></i>
									</a>
									<h4>Halal Standardization</h4>
<!-- 									<p class="sec-headjustify"> Halal Standardization is that the
										method of implementing and developing halal technical
										standards supported thr agreement of different parties that
										embody corporations,users,interest teams, standards
										organizations and governments standardizations will facilitate
										to maximize halal compatability,ability,safety,repeatability
										or quality. Generally, our Halal Assurance System adheres to
										the Halal Standards set by the OIC-SMIIC. And since each
										country has specific statutory and regulatory requirements,
										the same must also be complied accordingly. The firm to be
										granted Certificated on Halal Quality Assurance must undergo
										thorough Halal assessment and evaluation by DOST XII in
										partnership with the Ulamas and Shariah Lawyers, whenever
										necessary. Finally, products must passed thru Halal Laboratory
										Test Analyses thru thr DOST XII Halal Laboratory. Aside from
										testing and analyses, we carry-out Packaging and Labelling.</p> -->
								</div>
							</div>
							<!-- end about-details -->
						</div>
					</div>
					<!-- End Left services -->


				</div>
			</div>
		</div>
	</div>
	<!-- End Service area -->


<%-- 	<!-- Start Our Process Area -->
	<div id="team" class="our-team-area area-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="section-headline text-center">
						<h2>Our Process</h2>
						<img src="${images}/slider/process.jpg" />
					</div>


				</div>
			</div>

		</div>
	</div> --%>
	<!-- End Our Process Area -->
	<!-- Start Suscrive Area -->
	<div class="suscribe-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs=12">
					<div class="suscribe-text text-center">
						<!-- <h3>DOST XII CERTIFICATION OF HALAL QUALITY ASSURANCE APPLICATION FORM</h3> -->
						<h3>On-Site Assessment and Product Certification</h3>
						<a class="sus-btn" href="${contextRoot}/halalform">REGISTER
							APPLICATION FORM</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Suscrive Area -->

	<!-- Start contact Area -->
	<div id="contact" class="contact-area">
		<div class="contact-inner area-padding">
			<div class="contact-overly"></div>
			<div class="container ">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="section-headline text-center">
							<h2>Contact us</h2>
						</div>
					</div>
				</div>
				<div class="row">

					<!-- Start contact icon column -->
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="contact-icon text-center">
							<div class="single-icon">
								<i class="fa fa-map-marker"></i>
								<p>
									Location: Department of Science and Technology Region XII<br>
									Philippine National Halal Laboratory Science Center<br>
									<span>Koronadal City, Philippines</span>
								</p>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- End Contact Area -->




	<div class="footer-area-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="copyright text-center">
						<p>
							&copy; Copyright <strong>DOST XII - PLHS </strong>. All Rights
							Reserved
						</p>
					</div>
					<div class="credits">
						<!--
                All the links in the footer should remain intact.
                You can delete the links only if you purchased the pro version.
                Licensing information: https://bootstrapmade.com/license/
                Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=eBusiness
              -->

					</div>
				</div>
			</div>
		</div>
	</div>


	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="${lib}/jquery/jquery.min.js"></script>
	<script src="${lib}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${lib}/owlcarousel/owl.carousel.min.js"></script>
	<script src="${lib}/venobox/venobox.min.js"></script>
	<script src="${lib}/knob/jquery.knob.js"></script>
	<script src="${lib}/wow/wow.min.js"></script>
	<script src="${lib}/parallax/parallax.js"></script>
	<script src="${lib}/easing/easing.min.js"></script>
	<script src="${lib}/nivo-slider/js/jquery.nivo.slider.js"
		type="text/javascript"></script>
	<script src="${lib}/appear/jquery.appear.js"></script>
	<script src="${lib}/isotope/isotope.pkgd.min.js"></script>

	<!-- Contact Form JavaScript File -->
	<script src="${contactform}/contactform.js"></script>

	<script src="${js}/main.js"></script>
</body>

</html>
