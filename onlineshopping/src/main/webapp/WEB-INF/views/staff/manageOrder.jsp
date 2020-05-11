  <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="${contextRoot}/staff/">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Order</li>
          </ol>
		
          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-table"></i>
              List of All Orders</div>
            <div class="card-body">
              <div class="table-responsive">
             <%--  <a class="btn btn-primary" style="float: left"  href="${contextRoot}/staff/product"><i class="fas fa-plus-square"></i></a> --%>
                <table class="table table-bordered" id="dataTableOrderId" width="100%" cellspacing="0">
                  <thead>
                    <tr>
					    <th>Order Date</th>
					    <th>Name</th>
					    <th>Email</th>
					    <th>Contact Number</th>
					    <th>Order Count</th>
					    <th>Billing</th>
					    <th>Shipping</th>
						<th>Order Total</th>
						<th></th>			  
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
					    <th>Order Date</th>
					    <th>Name</th>
					    <th>Email</th>
					    <th>Contact Number</th>
					    <th>Order Count</th>
					    <th>Billing</th>
					    <th>Shipping</th>				    
						<th>Order Total</th>
						<th></th>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>