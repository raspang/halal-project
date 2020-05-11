<%@include file="../flows-shared/header.jsp" %>
<div class="container">
	
	<div class="row">
	
		<div class="col-sm-6">
	
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>
			
				<div class="panel-body">
					<div class="text-center">
						<h3>Name : <strong>${registerSupplierModel.user.firstName} ${registerModel.user.lastName}</strong></h3>
						<h4>Email : <strong>${registerSupplierModel.user.email}</strong></h4>
						<h4>Contact : <strong>${registerSupplierModel.user.contactNumber}</strong></h4>
						<br/>
						<p>
							<a href="${flowExecutionUrl}&_eventId_personal1" class="btn btn-primary">Edit</a>
						</p>
					</div>
				</div>
			
			</div>
					
		
		</div>
		
		<div class="col-sm-6">
		
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Billing Address</h4>
				</div>
			
				<div class="panel-body">
					<div class="text-center">
						<p>${registerSupplierModel.billing.addressLineOne}, </p>
						<p>${registerSupplierModel.billing.addressLineTwo}, </p>
						<p>${registerSupplierModel.billing.city} -  ${registerSupplierModel.billing.postalCode}, </p>
						<p>${registerSupplierModel.billing.state}</p>
						<p>${registerSupplierModel.billing.country}</p>
						<p>
							<a href="${flowExecutionUrl}&_eventId_billing1" class="btn btn-primary">Edit</a>
						</p>
					</div>
				</div>
			
			</div>
		
		</div>
	
	</div>
	
	<div class="row">
		
		<div class="col-sm-4 col-sm-offset-4">
			
			<div class="text-center">
				
				<a href="${flowExecutionUrl}&_eventId_submit1" class="btn btn-lg btn-primary">Confirm</a>
				
			</div>
			
		</div>
		
	</div>

</div>
<%@include file="../flows-shared/footer.jsp" %>