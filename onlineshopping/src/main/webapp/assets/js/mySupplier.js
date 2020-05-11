// Call the dataTables jQuery plugin
$(document)
		.ready(
				function() {
					
					/*------*/
					/* for fading out the alert message after 3 seconds */
					$alert = $('.alert');
					if($alert.length) {
						setTimeout(function() {
					    	$alert.fadeOut('slow');
						   }, 3000
						);		
					}

					// for handling CSRF token
					var token = $('meta[name="_csrf"]').attr('content');
					var header = $('meta[name="_csrf_header"]').attr('content');

					if ((token != undefined && header != undefined)
							&& (token.length > 0 && header.length > 0)) {
						// set the token header for the ajax request
						$(document).ajaxSend(function(e, xhr, options) {
							xhr.setRequestHeader(header, token);
						});
					}

					var $tableCategory = $('#dataTableCategory');

					if ($tableCategory.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/supplier/json/data/all/categories';
						$tableCategory
								.DataTable({

									lengthMenu : [
											[ 10, 15, 20 ],
											[ '10 Records', '15 Records',
													'20 Records' ] ],
									pageLength : 10,
									ajax : {
										url : jsonUrl,
										dataSrc : ''
									},
									columns : [
											{
												data : 'name'
											},
											{
												data : 'description'
											},
											{
												data : 'id',
												bSortable : false,
												width : "8%",
												mRender : function(data, type,
														row) {
													var str = '';
													if (userRole === 'SUPPLIER') {
														str += '<a href="'
																+ window.contextRoot
																+ '/supplier/categories?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a> | ';

														str += modalDeleteString(
																data,
																window.contextRoot
																		+ '/staff/category/'
																		+ data
																		+ '/delete');
													}
													return str;
												}
											} ]

								});
					}

					var $tableOrder = $('#dataTableOrderId');

					if ($tableOrder.length) {
						var jsonUrl = '';

						jsonUrl = window.contextRoot
								+ '/supplier/json/data/all/orders';
						$tableOrder
								.DataTable({

									lengthMenu : [
											[ 10, 15, 20 ],
											[ '10 Records', '15 Records',
													'20 Records' ] ],
									pageLength : 10,
									ajax : {
										url : jsonUrl,
										dataSrc : ''
									},
									columns : [ {
										data : 'orderDateStr'
									}, {
										data : 'nameStr'
									}, 
									{
										data : 'user.email'
									},
									{
										data : 'user.contactNumber'
									}
									, 
									{
										data : 'orderCount'
									},
									{
										data : 'billing.addressLineOne'
									},
									{
										data : 'shipping.addressLineOne'
									}
									,
									{
										data : 'orderTotal'
									}, {
										data : 'id'
									} ]

								});
					}
					
					var $dataCertification = $('#dataTableCertificationId');
					if ($dataCertification.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/supplier/json/data/all/certifications';
						$dataCertification
								.DataTable({

									lengthMenu : [
											[ 10, 15, 20 ],
											[ '10 Records', '15 Records',
													'20 Records' ] ],
									pageLength : 10,
									ajax : {
										url : jsonUrl,
										dataSrc : ''
									},
									columns : [

											{
												data : 'halalCertificateNo'
											},
											{
												data : 'title'
											},
											{
												data : 'description'
											},
											{
												data : 'local',
												mRender : function(data, type,
														row) {
													if (data == true)
														return 'Local';
													else
														return 'International';
												}
											},
											{
												data : 'id',
												bSortable : false,
												width : "8%",
												mRender : function(data, type,
														row) {
													var str = '';
													if (userRole === 'SUPPLIER') {
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/certificate?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a> | ';

														str += modalDeleteString(
																data,
																window.contextRoot
																		+ '/staff/certificate/'
																		+ data
																		+ '/delete');
													}
													return str;
												}
											} ]
								});
					}

					var $tableIngredient = $('#dataTableIngredientsId');
					if ($tableIngredient.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/supplier/json/data/all/ingredients';

						$tableIngredient
								.DataTable({

									lengthMenu : [
											[ 10, 15, 20 ],
											[ '10 Records', '15 Records',
													'20 Records' ] ],
									pageLength : 10,
									ajax : {
										url : jsonUrl,
										dataSrc : ''
									},
									columns : [
											{
												data : 'name'
											},
											{
												data : 'description'
											}
											]
								});
					}

					var $dataProduct = $('#dataTableProductId');
					if ($dataProduct.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/supplier/json/data/all/products';
						$dataProduct
								.DataTable({

									lengthMenu : [
											[ 5, 10, 15 ],
											[ '5 Records', '10 Records',
													'15 Records' ] ],
									pageLength : 5,
									ajax : {
										url : jsonUrl,
										dataSrc : ''
									},
									columns : [
											{
												data : 'code',
												bSortable : false,
												mRender : function(data, type,
														row) {
													return '<img src="'
															+ window.contextRoot
															+ '/resources/images/'
															+ data
															+ '.png" class="dataTableImg"/>';

												}
											},
											{
												data : 'code'

											},
											{
												data : 'name'
											},

											{
												data : 'quantity'
											},
											{
												data : 'unitPrice'
											},

											{
												data : 'id',
												bSortable : false,
												width : "8%",
												mRender : function(data, type,
														row) {
													if (userRole === 'SUPPLIER') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/supplier/product/'
																+ data
																+ '/ingredients"><i class="fa fa-list"></i></a>';
														return str;
													}
												}
											},

											{
												data : 'id',
												bSortable : false,
												width : "8%",
												mRender : function(data, type,
														row) {
													var str = '';
													if (userRole === 'SUPPLIER') {
														str += '<a href="'
																+ window.contextRoot
																+ '/supplier/product?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a> | ';
														str += modalDeleteString(
																data,
																window.contextRoot
																		+ '/staff/product/'
																		+ data
																		+ '/delete');
													}
													return str;
												}

											} ]
								});
					}




			
					
					function modalDeleteString(index, link) {
						var str = '';
						str += '<a href="#" data-toggle="modal" data-target="#nomodal'
								+ index
								+ '"><i class="fas fa-trash-alt"></i></a>';

						str += '<div id="nomodal'
								+ index
								+ '" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">';
						str += '<div class="modal-dialog" role="document"> <div class="modal-content">';

						str += '<div class="modal-header"><h4 class="modal-title">Delete</h4><button type="button" class="close" data-dismiss="modal"aria-label="Close"><span aria-hidden="true">&times;</span></button></div>';

						str += '<div class="modal-body"><p>Are you sure you want to delete?</p></div>';

						str += '<div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
						str += '<a href="'
								+ link
								+ '" class="btn btn-danger">Delete</a></div></div></div></div>';
						return str;
					}

				});
