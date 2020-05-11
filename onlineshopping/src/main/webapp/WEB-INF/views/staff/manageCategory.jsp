<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a
		href="${contextRoot}/staff/">Dashboard</a></li>
	<li class="breadcrumb-item active">Category</li>
</ol>

	<c:if test="${not empty message}">	
		<div class="mb-3">			
				<div class="alert alert-success">${message}</div>				
		</div>
	</c:if>
<!-- DataTables Example -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> List of Categories
	</div>

	<div class="card-body">
		<!-- Button trigger modal -->
		<div class="table-responsive">
		
		<a class="btn btn-primary" style="float: left"  data-toggle="modal" data-target="#modalCategoryId"><i class="fas fa-plus-square"></i></a>
			<table class="table table-bordered" id="dataTableCategory"
				width="100%" cellspacing="0">
				<thead>
					<tr>
						
						<th>Name</th>
						<th>Description</th>
						<th></th>
					</tr>
				</thead>
				<tfoot>
					<tr>
					
						<th>Name</th>
						<th>Description</th>
						<th></th>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<div class="card-footer small text-muted">Updated yesterday at
		11:59 PM</div>
</div>

<!-- Modal -->
<div class="modal fade" id="modalCategoryId" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Category</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			
			<sf:form id="categoryForm" class="form-horizontal" modelAttribute="category"  action="${contextRoot}/staff/category" method="POST">
				<div class="modal-body">

				<div class="form-group">
					<label class="control-label col-md-4">Name</label>
					<div class="col-md-8 validate">
						<sf:input type="text" path="name" class="form-control" placeholder="Category Name" /> 
					</div>
				</div>
       			
       			<div class="form-group">				
					<label class="control-label col-md-4">Description</label>
					<div class="col-md-8 validate">
						<sf:textarea path="description" class="form-control"
							placeholder="Enter category description here!" /> 
					</div>
				</div>	  				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					 <button type="Submit" class="btn btn-primary">Save</button>
				</div>
			</sf:form>
		</div>
	</div>
</div>







<%-- <div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
    <sf:form class="form-horizontal" modelAttribute="category"  action="${contextRoot}/laboratory/category" method="POST">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                 <h3 id="myModalLabel">Delete Confirmation</h3>

            </div>
            <div class="modal-body">
                <p class="error-text"><i class="fa fa-warning modal-icon"></i>Are you sure you want to delete the cover?
                  </p>
            </div>
            <div class="modal-footer">
               <button class="btn btn-default"data-dismiss="modal" aria-hidden="true">Cancel</button> 
               <a href="#" class="btn btn-danger"  id="modalDelete" >Delete</a>
            </div>
        </div>
       </sf:form>
    </div>
</div> --%>
