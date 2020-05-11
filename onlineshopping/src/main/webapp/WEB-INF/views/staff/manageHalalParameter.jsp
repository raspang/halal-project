  <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
  <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="${contextRoot}/laboratory/">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Halal Parameter</li>
          </ol>
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-table"></i>
              List of Halal Parameters</div>
            <div class="card-body">
             
              <div class="table-responsive">
              <a style="float: left"  href="${contextRoot}/staff/halalparameter"class="btn btn-primary"><i class="fas fa-plus-square"></i></a>  
                <table class="table table-bordered" id="dataTableHalalParameterId" width="100%" cellspacing="0">
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
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>