  <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="${contextRoot}/supplier/">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Onsite Assessment</li>
          </ol>
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-table"></i>
              List of Onsite Assessments</div>
            <div class="card-body">
            
              <div class="table-responsive">
                <a class="btn btn-primary" style="float: left" href="${contextRoot}/supplier/onsiteassessment"><i class="fas fa-plus-square"></i></a>
                <table class="table table-bordered" id="dataTableOnsiteId" width="100%" cellspacing="0">
                  <thead>
                    <tr>
					    <th>CreatedOn</th>
					    <th>UpdatedOn</th>
					    <th>Supplier Name</th>
					    <th>Certificate No.</th>
					    <th>Certificate Name</th>
					    <th>CB</th>
					    <th>Status</th>
					    <th></th>
					    <th></th>
					    <th></th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
					    <th>Created On</th>
					    <th>Updated On</th>
					    <th>Supplier Name</th>
					    <th>Certificate No.</th>
					    <th>Certificate Name</th>
					    <th>CB</th>
					    <th>Status</th>
					    <th></th>
					    <th></th>
					    <th></th>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>
          