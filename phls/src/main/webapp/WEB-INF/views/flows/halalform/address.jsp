<%@include file="../flows-shared/header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">

		<div class="col-md-7 col-md-offset-3">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4><img src="${images}/logo.png" width="32"  alt="">Register - On Site Assessment</h4>
				</div>

				<div class="panel-body">
										<div class="form-row"> <p>Please provide the location that team will conduct assessment.</p>
					</div>
					<sf:form method="POST" modelAttribute="onsite"
						class="form-horizontal">

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="addressLineOne">Address Line 1</label>
										<sf:input path="addressLineOne" class="form-control"
											placeholder="address" required="required" />
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="addressLineTwo">Address Line 2</label>
										<sf:input path="addressLineTwo" class="form-control"
											placeholder="address" />
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="city">City</label>
										<sf:input path="city" class="form-control"  placeholder="City" />
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="state">State</label>
										<sf:input path="state" class="form-control" placeholder="State" />
									</div>
								</div>
							</div>
						</div>							
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<div class="form-label-group">
										<label for="postalCode">Postal Code</label>
										<sf:input path="postalCode" class="form-control" placeholder="Postal Code" />
									</div>
								</div>
							</div>
						</div>							
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="state">Country</label>
										<sf:input path="country" class="form-control" placeholder="Country" />
									</div>
								</div>
							</div>
						</div>						


						<sf:input type="hidden" path="id" />

<%-- 						<a href="${flowExecutionUrl}&_eventId_supplier"
							class="btn btn-lg btn-primary">Back - Company Profile</a> --%>

							
						<button type="submit" name="_eventId_confirm"
							class="btn btn-lg btn-primary">Next - Confirmation</button>

						<a class="btn btn-lg btn-danger" href="${flowExecutionUrl}&_eventId=home">Cancel</a>

					</sf:form>


				</div>


			</div>


		</div>


	</div>


</div>

<%@include file="../flows-shared/footer.jsp"%>
