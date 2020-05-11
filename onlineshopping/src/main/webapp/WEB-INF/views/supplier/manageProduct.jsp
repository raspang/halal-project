  <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="${contextRoot}/supplier/">Dashboard</a>
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
              <a class="btn btn-primary" style="float: left"  href="${contextRoot}/supplier/product"><i class="fas fa-plus-square"></i></a>
                <table class="table table-bordered" id="dataTableProductId" width="100%" cellspacing="0">
                  <thead>
                    <tr>
					    <th></th>
					    <th>Code</th>
					    <th>Name</th>
					    <th>Qty</th>
					    <th>Unit Price</th>
					    <th>Ingredient</th>
					 
					    <th></th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
					    <th></th>
					    <th>Code</th>
					    <th>Name</th>
					    <th>Qty</th>
					    <th>Unit Price</th>
					    <th>Ingredient</th>
					    <th></th>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>