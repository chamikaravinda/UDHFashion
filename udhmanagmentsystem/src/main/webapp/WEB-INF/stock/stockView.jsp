
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	</br>
	</br>
	</br>
	</br>

	<div class="content-page">

		<!-- Start content -->
		<div class="content">
	
			<div class="container-fluid">

				<div class="row">

					<div class="col-md-12">
						<div class="card mb-3">
							<div class="col-md-12a">
								<a href="addStock" class="btn btn-primary btn-lg active"
									role="button" aria-pressed="true">Add</a> 
									
									<a href="barcodeGenerateView"
									class="btn btn-primary btn-lg active" role="button"
									aria-pressed="true">Generate Barcodes</a>
							</div>


							<div class="card-body">
								<div class="table-responsive">
									<table id="example1"
										class="table table-bordered table-hover display">
										<thead>
											<tr>
												<th>Item Code</th>
												<th> Description</th>
												<th>Gross Price</th>
												<th>Price (Tag Amount)</th>
												<th>Discount</th>
												<th>Net Price</th>
												<th>Quantity</th>
												<th>Net Profit</th>
												<th>Estimated Net Profit</th>
												<th>Shop Id</th>
												<td><span><i class="fa fa-pencil-square"
														aria-hidden="true"></i></span></td>
												<td><span><i class="fa fa-trash"
														aria-hidden="true"></i></span></td>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="result" items="${stockList}">
												<tr>
													<td>${result.itemCode}</td>
													<td>${result.itemDescription}</td>
													<td>${result.grossPrice}</td>
													<td>${result.price}</td>
													<td>${result.discount}</td>
													<td>${result.netPrice}</td>
													<td>${result.itemQuantity}</td>
													<td>${result.netProfit}</td>
													<td>${result.estimatedNetProfit}</td>
													<td>${result.shopId}</td>
													<td>
														<form method = "POST" action = "editItem" modelAttribute="item">
         													<input name = "itemCode" type = "hidden" value = "${result.itemCode}" >
         													<button type="submit" al class="btn btn-primary">Update</button>
         												</form>
													</td>
													<td>
														<form method = "POST" action = "deleteItem" modelAttribute="item">
         													<input name = "itemCode" type = "hidden" value = "${result.itemCode}" >
         													<button type="submit" al class="btn btn-primary">Delete</button>
         												</form>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>

							</div>
						</div>
						<!-- end card-->
					</div>

					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">

					</div>

				</div>
			</div>
			<!-- END container-fluid -->

		</div>
		<!-- END content -->

	</div>
<%@ include file="../includes/footer.jsp"%>