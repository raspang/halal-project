 <%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
	<script>
		window.userRole = '${userModel.role}';
	</script>
 
 <!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
       <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="${contextRoot}/home">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="about.html">About Us</a>
            </li>
			       <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Our Services
              </a>
              <div class="dropdown-menu dropdown-menu-left" aria-labelledby="navbarDropdownPortfolio">
                <a class="dropdown-item" href="Labservices.html">Halal Laboratory Services</a>
                <a class="dropdown-item" href="portfolio-2-col.html">Halal Food Developement/Training</a>
                <a class="dropdown-item" href="portfolio-3-col.html">Halal Research and Development</a>
                <a class="dropdown-item" href="portfolio-4-col.html">Halal Packaging and Labeling</a>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="services.html">Multimedia</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="halalproducts.html">Halal Products</a>
            </li>		
            <li class="nav-item">
              <a class="nav-link" href="contact.html">Contact Us</a>
            </li>
           
             <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Forms
              </a>
              <div class="dropdown-menu dropdown-menu-left" aria-labelledby="navbarDropdownPortfolio">
                <a class="dropdown-item" href="formlabservices.html">Laboratory Services</a>
                <a class="dropdown-item" href="HalalQA.html">Halal Quality Assurance</a>
                
              </div>
            </li>		
			     <li class="nav-item">
              <a class="nav-link" href="services.html">Careers</a>
            </li>
           
          </ul>
        
      </div>
    </nav>
