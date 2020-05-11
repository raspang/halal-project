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
								+ '/laboratory/json/data/all/categories';
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
													if (userRole === 'LABORATORY') {
														str += '<a href="'
																+ window.contextRoot
																+ '/laboratory/categories?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a> | ';

														str += modalDeleteString(data, window.contextRoot + '/laboratory/category/' + data+ '/delete');
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
								+ '/laboratory/json/data/all/certifications';
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
													if (userRole === 'LABORATORY') {
														str += '<a href="'
																+ window.contextRoot
																+ '/laboratory/certificate?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a>|';
														
														str += modalDeleteString(data, 
																window.contextRoot
																+ '/laboratory/certificate/'
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
								+ '/laboratory/json/data/all/ingredients';

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
													if (userRole === 'LABORATORY') {
														str += '<a href="'
																+ window.contextRoot
																+ '/laboratory/ingredients?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a>|';
														str += modalDeleteString(data, 
																window.contextRoot
																+ '/laboratory/ingredient/'
																+ data
																+ '/delete'
														);
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
								+ '/laboratory/json/data/all/products';
						$dataProduct
								.DataTable({
									 "order": [[ 1, "desc" ]],
									lengthMenu : [
											[  10, 15 , 20],
											[ '10 Records', '15 Records', '20 Records' ] ],
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
											data : 'updatedOnStr'

										},	
											{
												data : 'code'

											},											
											{
												data : 'name'
											},

											{
												data : 'description'
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
													if (userRole === 'LABORATORY') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/laboratory/product/'
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
													if (userRole === 'LABORATORY') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/laboratory/product/'
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
												mRender : function(data, type, row) {
													if (userRole === 'LABORATORY') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/laboratory/product/'
																+ data
																+ '/nutritionfactsresult"><i class="fa fa-list"></i></a>';
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
													if (userRole === 'LABORATORY') {
														str += '<a href="'
																+ window.contextRoot
																+ '/laboratory/product?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a>|';
														str += modalDeleteString(data, 
																window.contextRoot
																+ '/laboratory/product/'
																+ data
																+ '/delete'
														);
													}
													return str;
												}

											} ]
								});
					}


					var $dataManufacture = $('#dataTableSupplierId');
					if ($dataManufacture.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/laboratory/json/data/all/suppliers';
						$dataManufacture
								.DataTable({
									 "order": [[ 1, "desc" ]],
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
												mRender : function(data, type,
														row) {
													if (userRole === 'LABORATORY') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/laboratory/supplier/'
																+ data
																+ '/products"><i class="fa fa-list"></i></a>';
														return str;
													}
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
													if (userRole === 'LABORATORY') {
														var str = '';
														str += '<a href="'+ window.contextRoot + '/laboratory/supplier/pdf?id='+data+'" target="_blank"><i class="fas fa-file-pdf"></i></a>';
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
													if (userRole === 'LABORATORY') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/laboratory/supplier?id='
																+ data
																+ '"><i class="fas fa-edit"></i></a>|';
														str += modalDeleteString(data, 
																window.contextRoot
																+ '/laboratory/supplier/'
																+ data
																+ '/delete'
																);
														
														return str;
													}

												}
											} ]
								});
					}

					
					var $dataTableOnsiteAddress = $('#dataTableOnsiteAddressId');
					if ($dataTableOnsiteAddress.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/laboratory/json/data/onsite/'+ window.supplierid
								+'/addresses';
						
						$dataTableOnsiteAddress
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
												data : 'addressLineOne'
											},
											{
												data : 'addressLineTwo'
											},
											{
												data : 'city'
											},
											{
												data : 'state'
											},
											{
												data : 'country'
											},

											{
												data : 'postalCode'
											},
											{
												data : 'onsite'
			
											},
											{
												data : 'id',
												bSortable : false,
												width : "8%",
												mRender : function(data, type,row) {

													var str = '';
													str += '<a href="'
													+ window.contextRoot
													+ '/laboratory/onsiteassessment?id='
													+ data
													+'"><i class="fas fa-edit"></i></a> | ';

													str += '<a href="'
														+ window.contextRoot
														+ '/laboratory/onsiteassessment/'
														+ data
														+ '/delete"><i class="fas fa-trash-alt"></i></a>';
													return str;

												}
											} ]
								});
					}
					var $dataOnsite = $('#dataTableOnsiteId');
					if ($dataOnsite.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/laboratory/json/data/all/onsiteassessments';
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
												data : 'supplier.id',
												bSortable : false,
												width : "8%",
												mRender : function(data, type, row) {
													if (userRole === 'LABORATORY') {
														var str = '';
														str += '<a href="'
																+ window.contextRoot
																+ '/laboratory/onsiteaddresses?supplierid='
																+ data
																+ '"><i class="fa fa-list"></i></a>';
														return str;
													}
												}
											},
											{
												data : 'status',
												width : "10%",
												mRender : function(data, type, row) {
													var str = '';
													if (data === 1) {
														str += '<i class="fas fa-thermometer-three-quarters" style="color:orange"></i>&nbsp;No Status';
													} else if (data === 2) {
														str += '<i class="fas fa-thermometer-three-quarters" style="color:yellow"></i>&nbsp;In Progress';
													} else {
														str += '<i class="fas fa-thermometer-three-quarters" style="color:green"></i>&nbsp;Done';
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
													if (userRole === 'LABORATORY') {
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
												mRender : function(data, type,
														row) {

													var str = '';
													str += '<a href="'
													+ window.contextRoot
													+ '/laboratory/onsiteassessment?id='
													+ data
													+'"><i class="fas fa-edit"></i></a> | ';

													str += '<a href="'
														+ window.contextRoot
														+ '/laboratory/onsiteassessment/'
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
								+ '/laboratory/json/data/all/nutritionfacts';
						$dataNutritionFact
								.DataTable({

									lengthMenu : [
											[ 10, 15, 20 ],
											[ '10 Records', '15 Records','20 Records' ] ],
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
												mRender : function(data, type,row) {
													if (userRole === 'LABORATORY') {
													var str = '';
													str += '<a href="'
															+ window.contextRoot
															+ '/laboratory/nutritionfactsparameter?id='
															+ data
															+ '"><i class="fas fa-edit"></i></a>|';
													str += modalDeleteString(data,
															window.contextRoot
															+ '/laboratory/nutritionfactsparameter/'
															+ data
															+ '/delete');
													return str;
													
													}

												}
											} ]
								});
					}
					
					
					
					var $dataHalalParam = $('#dataTableHalalParameterId');
					if ($dataHalalParam.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/laboratory/json/data/all/halalparameters';
						$dataHalalParam
								.DataTable({

									lengthMenu : [
											[ 10, 15, 20 ],
											[ '10 Records', '15 Records','20 Records' ] ],
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
												mRender : function(data, type,row) {
													if (userRole === 'LABORATORY') {
													var str = '';
													str += '<a href="'
															+ window.contextRoot
															+ '/laboratory/halalparameter?id='
															+ data
															+ '"><i class="fas fa-edit"></i></a>|';
															
													str += 	modalDeleteString(data, window.contextRoot
															+ '/laboratory/halalparameter/'
															+ data
															+ '/delete');
													return str;
													
													}

												}
											} ]
								});
					}
					
	
					var $dataPersonnel = $('#dataTablePersonnelId');
					if ($dataPersonnel.length) {
						var jsonUrl = '';
						jsonUrl = window.contextRoot
								+ '/laboratory/json/data/all/personnels';
						$dataPersonnel
								.DataTable({

									lengthMenu : [
											[ 10, 15, 20 ],
											[ '10 Records', '15 Records','20 Records' ] ],
									pageLength : 10,
									ajax : {
										url : jsonUrl,
										dataSrc : ''
									},
									columns : [

											{
												data : 'lastName'
											},
											{
												data : 'firstName'
											},
											{
												data : 'middleName'
											},
											{
												data : 'position'
											},
											{
												data : 'incharge'
											},
											{
												data : 'id',
												bSortable : false,
												width : "8%",
												mRender : function(data, type,row) {
													if (userRole === 'LABORATORY') {
													var str = '';
													str += '<a href="' + window.contextRoot + '/laboratory/personnel?id=' + data + '"><i class="fas fa-edit"></i></a>|';
													str += modalDeleteString(data,
															window.contextRoot + '/laboratory/personnel/' + data + '/delete');
													return str;
													
													}

												}
											} ]
								});
					}
					
				function modalDeleteString(index, link){
						var str = '';
						str += '<a href="#" data-toggle="modal" data-target="#nomodal'+index+'"><i class="fas fa-trash-alt"></i></a>';
					
						str +='<div id="nomodal'+index+'" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">';
						str += '<div class="modal-dialog" role="document"> <div class="modal-content">';

						str += '<div class="modal-header"><h4 class="modal-title">Delete</h4><button type="button" class="close" data-dismiss="modal"aria-label="Close"><span aria-hidden="true">&times;</span></button></div>';
							
						str += '<div class="modal-body"><p>Are you sure you want to delete?</p></div>';
							
						str += '<div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
						str += '<a href="'+link+'" class="btn btn-danger">Delete</a></div></div></div></div>';
						return str;
				}
				
				});
