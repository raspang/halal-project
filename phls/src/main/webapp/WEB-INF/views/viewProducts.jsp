
<div class="container">



	<c:if test="${userClickAllProducts == true}">

		<script>
			window.categoryId = '';
		</script>

	</c:if>


	<c:if test="${userClickCategoryProducts == true}">
		<script>
			window.categoryId = '${category.id}';
		</script>

	</c:if>




	<div class="row">


		<div class="breadcrumb">

			<h1>
				<b>Online Shopping</b>
			</h1>

			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">

					<div class="item active">
						<img src="${images}/buy-logo.png" width="28" style="float: left;">
						<p>&nbsp;Order product.</p>
					</div>

					<div class="item">
						<img src="${images}/mouse-logo.png" width="28"
							style="float: left;">
						<p>&nbsp;You'll receive delivery.</p>
					</div>

					<div class="item">
						<img src="${images}/icon-logo.png" width="28" style="float: left;">
						<p>&nbsp;Product with verified Halal.</p>
					</div>

				</div>

			</div>

		</div>

		<!-- Would be to display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- to display the actual products -->
		<div class="col-md-9">




			<div class="row">

				<div class="col-xs-12">

					<div id="halal-item">
						<div class="row">
							<div class="col-md-4">
								<input type="text" class="fuzzy-search form-control" placeholder="Search for product name" />
							</div>
							<div class="col-md-6"></div>
							<div class="col-md-2">
								<button class="sort btn btn-default" data-sort="name">Sort
									by name</button>
							</div>
						</div>
						<div class="row">
							<ul id="myproductsid" class="list list-group"></ul>
						</div>
						<div class="row">
							<div class="col-md-5"></div>
							<div class="col-md-6">
								<ul class="pagination"></ul>
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
</div>