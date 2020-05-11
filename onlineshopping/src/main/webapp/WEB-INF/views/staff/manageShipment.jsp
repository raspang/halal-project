  <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="${contextRoot}/staff/">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Shipment</li>
          </ol>
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-table"></i>
              List of Shipment</div>
            <div class="card-body">
              <div class="table-responsive">
              <a class="btn btn-primary" style="float: left" href=""><i class="fas fa-plus-square"></i></a>
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>	
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Description</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Description</th>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>