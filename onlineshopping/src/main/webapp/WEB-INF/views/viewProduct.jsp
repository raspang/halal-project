<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="container">
	
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a>
		</li>
		<li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Products</a></li>
		<li class="breadcrumb-item active">${product.name }</li>
	</ol>

	<div class="row">




		<!-- to display the actual products -->
		<div class="col-md-9">



			<div class="row">

				<div class="col-xs-12">

					<!-- Display the product image -->
					<div class="col-xs-12 col-sm-4">

						<div class="thumbnail">

							<img src="${images}/${product.code}.png"
								class="img img-responsive" />

						</div>

					</div>

					<h3>${product.name}</h3>
					<hr />


					<p>${product.description}</p>
					<hr />

					<h4>
						Price: <strong> ${product.unitPrice} </strong>
					</h4>
					<hr />
					<h5>
						Ingredients:
						<c:forEach items="${ingredientDetails}" var="ingredientDetail"
							varStatus="loop">
							<c:choose>
								<c:when
									test="${ingredientDetail.ingredient.critical}">
									<i title="${ingredientDetail.markDescription}"
										style="color: darkred">${ingredientDetail.ingredient.name}</i>
								</c:when>
								<c:otherwise>
										${ingredientDetail.ingredient.name}
								</c:otherwise>

							</c:choose>
 							${!loop.last ? ',' : ''}
						</c:forEach>
					</h5>
					
<%-- 					<c:if test="${fn:length(halalAnalysisReports) gt 0}">
					<hr />
						No found:
						<c:forEach items="${halalAnalysisReports}"
							var="halalAnalysisReport" varStatus="loop">
							<c:if test="${halalAnalysisReport.mark eq 0}">
									<b>${halalAnalysisReport.halalParameter.name}</b>
									${!loop.last ? ',' : ''}
							</c:if>
	 						
						</c:forEach>
					</c:if> --%>
					
<%-- 					<c:if test="${fn:length(nutritionFactsResults) gt 0}">
					<hr />
						It contains:
						<c:forEach items="${nutritionFactsResults}"
							var="nutritionFactsResult" varStatus="loop">
							<b>${nutritionFactsResult.nutritionFactsParameter.name}</b>
							${!loop.last ? ',' : ''}
						</c:forEach>
					</c:if> --%>


					<c:choose>

						<c:when test="${product.quantity < 1}">

							<h6>
								Qty. Available: <span style="color: red">Out of Stock!</span>
							</h6>

						</c:when>
						<c:otherwise>

							<h6>Qty. Available: ${product.quantity}</h6>

						</c:otherwise>

					</c:choose>

					<security:authorize access="isAnonymous() or hasAuthority('USER')">

						<c:choose>

							<c:when test="${product.quantity < 1}">

								<a href="javascript:void(0)" class="btn btn-success disabled">
									<strike> <span
										class="glyphicon glyphicon-shopping-cart"></span> Add to Cart
								</strike>
								</a>

							</c:when>
							<c:otherwise>

								<a href="${contextRoot}/cart/add/${product.id}/product"
									class="btn btn-success"> <span
									class="glyphicon glyphicon-shopping-cart"></span> Add to Cart
								</a>


							</c:otherwise>

						</c:choose>
					</security:authorize>

				</div>

			</div>
		</div>
	</div>
</div>