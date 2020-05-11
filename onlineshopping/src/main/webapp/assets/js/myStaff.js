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
								+ '/staff/json/data/all/categories';
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
													if (userRole === 'STAFF') {
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/categories?id='
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

					var $dataCertification = $('#dataTableCertificationId');
					if ($dataCertification.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/staff/json/data/all/certifications';
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
													if (userRole === 'STAFF') {
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
								+ '/staff/json/data/all/ingredients';

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
											},
											{
												data : 'critical',
												mRender : function(data, type,
														row) {
													if (data == true)
														return 'Critcal';
													else
														return 'Safe';
												}
											},
											{
												data : 'id',
												bSortable : false,
												width : "8%",
												mRender : function(data, type,
														row) {
													var str = '';
													if (userRole === 'STAFF') {
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/ingredients?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a> | ';
														str += modalDeleteString(
																data,
																window.contextRoot
																		+ '/staff/ingredient/'
																		+ data
																		+ '/delete');
													}
													return str;
												}
											} ]
								});
					}

					var $dataProduct = $('#dataTableProductId');
					if ($dataProduct.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/staff/json/data/all/products';
						$dataProduct
								.DataTable({
									 "order": [[ 1, "desc" ]],
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
												data : 'createdOnStr'
	
											},
											{
												data : 'updatedOnStr'
	
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
												data : 'supplier.nameOfEstablishment'
											},
											{
												data : 'id',
												bSortable : false,
												width : "8%",
												mRender : function(data, type,
														row) {
													if (userRole === 'STAFF') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/product/'
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
													if (userRole === 'STAFF') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/product/'
																+ data
																+ '/halalanalysis"><i class="fa fa-list"></i></a>';
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
													if (userRole === 'STAFF') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/product/'
																+ data
																+ '/nutritionfactsresult"><i class="fa fa-list"></i></a>';
														return str;
													}
												}
											},
											{
												data : 'displayed',
												bSortable : false,
												mRender : function(data, type,
														row) {
													var str = '';
													if (data) {
														str += '<label class="switch"> <input type="checkbox" value="'
																+ row.id
																+ '" checked="checked">  <div class="slider round"> </div></label>';

													} else {
														str += '<label class="switch"> <input type="checkbox" value="'
																+ row.id
																+ '">  <div class="slider round"> </div></label>';
													}

													return str;
												}
											},
											{
												data : 'id',
												bSortable : false,
												width : "8%",
												mRender : function(data, type, row) {
													var str = '';
													if (userRole === 'STAFF') {
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/product?id='
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

											} ],

									initComplete : function() {
										var api = this.api();
										api
												.$(
														'.switch input[type="checkbox"]')
												.on(
														'change',
														function() {
															var checked = this.checked;
															var checkbox = $(this);
															$
																	.ajax({
																		url : window.contextRoot
																				+ '/staff/product/'
																				+ checkbox
																						.prop('value')
																				+ '/activation'
																	});
														});

									}
								});
					}

					var $dataManufacture = $('#dataTableSupplierId');
					var table = '';
					if ($dataManufacture.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/staff/json/data/all/suppliers';
						table = $dataManufacture
								.DataTable({
									"order" : [ [ 1, "desc" ] ],
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
												data : 'createdOnStr'
											},
											{
												data : 'updateOnStr'
											},
											{
												data : 'nameOfEstablishment'
											},
											{
												data : 'personInvolved'
											},
											{
												data : 'position'
											},
											{
												data : 'telNo'
											},
											{
												data : 'email'
											},
											{
												data : 'id',
												bSortable : false,
												width : "6%",
												mRender : function(data, type, row) {
													if (userRole === 'STAFF') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/supplier/'
																+ data
																+ '/products"><i class="fa fa-list"></i></a>';
														return str;
													}
												}
											},
											{
												data : 'enable',
												bSortable : false,
												width : "10%",
									
												mRender : function(data, type, row) {
													var str = '';
													if (userRole === 'STAFF') {
														
														if(data)
															str += '<i class="fas fa-user-alt"></i>';//modalConfirm(row.id+'activate', "Delete the existing User Account permanately. Are you sure?", "fa-user-alt", window.contextRoot+'/staff/supplier/'+row.id+'/activation', 'btn-success')
														else
															str += modalConfirm(row.id+'activate', "Activate Email address for this Supplier. Kindly confirm?", "fa-user-alt", window.contextRoot+'/staff/supplier/'+row.id+'/activation', 'btn-warning')
													}
													return str;
												}
											},
											{
												data : 'user.enabled',
												bSortable : false,
												mRender : function(data, type, row) {
													var str = '';
													if (userRole === 'STAFF') {
														if (data != null) {
															if (data) {
																str += '<label class="switch"> <input type="checkbox" value="'
																		+ row.user.id
																		+ '" checked="checked">  <div class="slider round"> </div></label>';

															} else {
																str += '<label class="switch"> <input type="checkbox" value="'
																		+ row.user.id
																		+ '">  <div class="slider round"> </div></label>';
															}
														}
													}

													return str;
												}
											},
											{
												data : 'createdByStr'
											},
											{
												data : 'id',
												bSortable : false,
												width : "6%",
												mRender : function(data, type,
														row) {
													if (userRole === 'STAFF') {
														var str = '';
														str += '<a href="#"><i class="fas fa-file-pdf"></i></a>|';
														str += '<a href="#"><i class="fas fa-file-excel"></i></a>';

														return str;
													}
												}
											},
											{
												data : 'id',
												bSortable : false,
												width : "8%",
												mRender : function(data, type, row) {
													var str = '';
													if (userRole === 'STAFF') {													
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/supplier?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a>|';
														str += modalDeleteString(
																data,
																window.contextRoot
																		+ '/staff/supplier/'
																		+ data
																		+ '/delete');
														
													}
													return str;

												}
											} ],
											initComplete : function() {
												var api = this.api();
												api
														.$(
																'.switch input[type="checkbox"]')
														.on(
																'change',
																function() {
																	var checked = this.checked;
																	var checkbox = $(this);
																	$
																			.ajax({
																				url : window.contextRoot
																						+ '/staff/user/'
																						+ checkbox.prop('value')
																						+ '/activation'
																			});
																});

											}
								 
								});
						

						
					}

					

					var $dataOnsite = $('#dataTableOnsiteId');
					if ($dataOnsite.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/staff/json/data/all/onsiteassessments';
						$dataOnsite
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
												data : 'createdOnStr'
											},
											{
												data : 'updateOnStr'
											},
											{
												data : 'supplier.nameOfEstablishment'
											},
											{
												data : 'certification.halalCertificateNo'
											},
											{
												data : 'certification.title'
											},
											{

												data : 'id',
												bSortable : false,
												width : "4%",
												mRender : function(data, type,
														row) {
													if (userRole === 'STAFF') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/'
																+ data
																+ '"><i class="fa fa-list"></i></a>';
														return str;
													}
												}
											},
											{
												data : 'status',
												width : "10%",
												mRender : function(data, type,
														row) {
													var str = '';
													if (data === 1) {
														str += '<i class="fas fa-thermometer-three-quarters"></i>&nbsp;No Status';
													} else if (data === 2) {
														str += '<i class="fas fa-thermometer-three-quarters"></i>&nbsp;In Progress';
													} else {
														str += '<i class="fas fa-thermometer-three-quarters"></i>&nbsp;Done';
													}
													return str;
												}
											},
											{
												data : 'statusDescription'
											},
											{
												data : 'id',
												bSortable : false,
												width : "6%",
												mRender : function(data, type,
														row) {
													if (userRole === 'STAFF') {
														var str = '';
														str += '<a href="#"><i class="fas fa-file-pdf"></i></a>  |  ';
														str += '<a href="#"><i class="fas fa-file-excel"></i></a>';

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
													str += '<a href="'
															+ window.contextRoot
															+ '/staff/onsiteassessment?id='
															+ data
															+ '"><i class="fas fa-edit"></i></a> | ';

													str += '<a href="'
															+ window.contextRoot
															+ '/staff/onsiteassessment/'
															+ data
															+ '/delete"><i class="fas fa-trash-alt"></i></a>';
													return str;

												}
											} ]
								});
					}

					var $dataNutritionFact = $('#dataTableNutritionFactId');
					if ($dataNutritionFact.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/staff/json/data/all/nutritionfacts';
						$dataNutritionFact
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
													if (userRole === 'STAFF') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/nutritionfactsparameter?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a>  |  ';

														/*
														 * str += '<a href="' +
														 * window.contextRoot +
														 * '/laboratory/nutritionfactsparameter/' +
														 * data + '/delete"
														 * data-confirm="Are you
														 * sure you want to
														 * delete?">' + '<i
														 * class="fas
														 * fa-trash-alt"></i></a>'
														 */
														str += modalDeleteString(
																data,
																window.contextRoot
																		+ '/staff/nutritionfactsparameter/'
																		+ data
																		+ '/delete');
														return str;

													}

												}
											} ]
								});
					}

					/*
					 * $dataNutritionFact.on('click',
					 * ':not(form)[data-confirm]', function(e) { if
					 * (!confirm($(this).data('confirm'))) {
					 * e.stopImmediatePropagation(); e.preventDefault(); } });
					 */

					var $dataHalalParam = $('#dataTableHalalParameterId');
					if ($dataHalalParam.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/staff/json/data/all/halalparameters';
						$dataHalalParam
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
													if (userRole === 'STAFF') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/staff/halalparameter?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a>  |  ';

														/*
														 * str += '<a href="' +
														 * window.contextRoot +
														 * '/laboratory/halalparameter/' +
														 * data + '/delete"
														 * data-confirm="Are you
														 * sure you want to
														 * delete?">' + '<i
														 * class="fas
														 * fa-trash-alt"></i></a>'
														 */

														str += modalDeleteString(
																data,
																window.contextRoot
																		+ '/staff/halalparameter/'
																		+ data
																		+ '/delete');
														return str;

													}

												}
											} ]
								});
					}

					var $tableOrder = $('#dataTableOrderId');

					if ($tableOrder.length) {
						var jsonUrl = '';

						jsonUrl = window.contextRoot
								+ '/staff/json/data/all/orders';
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
									}, {
										data : 'user.email'
									}, {
										data : 'user.contactNumber'
									}, {
										data : 'orderCount'
									}, {
										data : 'billing.addressLineOne'
									}, {
										data : 'shipping.addressLineOne'
									}, {
										data : 'orderTotal'
									}, {
										data : 'id'
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
					
					function modalConfirm(index, message, fa, link, btn){
						var str = '';
						str += '<a href="#" class="btn '+btn+'" data-toggle="modal" data-target="#modalconfirm'+index+'"><i class="fas '+fa+'"></i></a>';

						str += '<div id="modalconfirm'+index+'" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">';
						str +=  '<div class="modal-dialog modal-sm" role="document">';
						str +=     '<div class="modal-content">';
						str += '<div class="modal-header"><h4 class="modal-title">Confirm</h4><button type="button" class="close" data-dismiss="modal"aria-label="Close"><span aria-hidden="true">&times;</span></button></div>';
						
						str += ' <div class="modal-body">';
						str += message;
						str += '<div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
						str += '<a href="'+link+'"  class="btn btn-primary">Save</a></div>';
						str +='</div></div>';
						str +=   '</div></div>';
						return str;
					}

			
				});
