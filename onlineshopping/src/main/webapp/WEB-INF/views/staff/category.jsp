<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/staff/">Dashboard</a></li>
	<li class="breadcrumb-item active">Category</li>
</ol>

<!-- DataTables Example -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Category
	</div>

	<div class="card-body">
	 <sf:form  class="form-horizontal" modelAttribute="category"  action="${contextRoot}/staff/category" method="POST">
				<div class="modal-body">
				<table>
                <tr>
                    <td><sf:label path="name" class="control-label">Name</sf:label></td>
                    <td><sf:input path="name" class="form-control" placeholder="Category Name" />
                    	<sf:errors path="name" />
                    </td>                   
                </tr>

                <tr>
                    <td><sf:label path="description" class="control-label">Description</sf:label></td>
                    <td><sf:input path="description" class="form-control"/></td>
                </tr>
                <tr>
                	<td>&nbsp;</td>
                </tr>
                <tr>
                	<sf:input type="hidden" path="id"/>
                	<td><a href="${contextRoot}/staff/categories"  class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;<input type="submit" value="Save"   class="btn btn-primary"  /></td>                
                </tr>
	            </table>				
				</div>			
		</sf:form>
	
	</div>
</div>
