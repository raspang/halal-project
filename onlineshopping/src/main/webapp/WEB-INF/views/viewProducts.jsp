
<div class="container">

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a>
		</li>
		<li class="breadcrumb-item active">Products</li>
	</ol>


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
							<div class="col-md-5">
								<input type="text" class="fuzzy-search form-control" placeholder="Search for product" />
							</div>
							<div class="col-md-5"></div>
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