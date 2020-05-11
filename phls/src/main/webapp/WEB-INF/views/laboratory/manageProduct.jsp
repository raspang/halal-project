 <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="${contextRoot}/laboratory/">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Product</li>
          </ol>
	
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		 <!-- DataTables Example -->
          <div class="card mb-3">
          
            <div class="card-header">
              <i class="fas fa-table"></i>
              List of All Products</div>
            <div class="card-body">
              <div class="table-responsive">
              <a class="btn btn-primary" style="float: left"  href="${contextRoot}/laboratory/product"><i class="fas fa-plus-square"></i></a>
                <table class="table table-bordered" id="dataTableProductId" width="100%" cellspacing="0">
                  <thead>
                    <tr>
					    <th>Created On</th>
					    <th>Updated On</th>
					    <th>Code</th>
					    <th>Name</th>					    
					    <th>Description</th>
						<th>Company</th>
					    <th>Ingredients</th>
					    <th>Halal Analysis</th>
					    <th>Thayyibban Analysis</th>
					    <th></th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
						 <th>Created On</th>
					    <th>Updated On</th>				   
					    <th>Code</th>
					    <th>Name</th>					    
					    <th>Description</th>
						<th>Company</th>
					    <th>Ingredients</th>
					    <th>Halal Analysis</th>
					    <th>Thayyibban Analysis</th>					    
					    <th></th>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>