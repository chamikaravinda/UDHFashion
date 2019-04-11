<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script>
	function validator(){
		
		var grossPrice = document.getElementById("grossPrice").value;
		var tagAmount = document.getElementById("tagAmount").value;
		var discount = document.getElementById("discount").value;
		var netPrice = document.getElementById("netPrice").value;
		var quantity = document.getElementById("quantity").value;
		
		if( grossPrice == null || grossPrice == "" ){
			alert("You cannot keep the gross price value "))
		}
		
		}		
	}
</script>

<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">


			<div class="row">
				<div class="col-xl-12">
					<div class="breadcrumb-holder">
						<h1 class="main-title float-left">Return Note</h1>

						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->

			<div class="row">
				<!-- To divide the page in two forms -->
				<div class="col-md-6">
					<div class="card mb-3">


						<div class="card-body">
							<form method="POST" action="billSearch">
								<div class="form-group">
									<label for="exampleInputEmail1">Bill Number</label> <input
										type="number" class="form-control" id="billNumber"
										name="billId" aria-describedby="emailHelp"
										placeholder="Enter Bill Number" required>
									<div style="margin: 10px;">
										<button type="submit" class="btn btn-primary">Search</button>
									</div>

								</div>

							</form>

							<!-- Start to show the details about Bill  -->


							<div class="row">

								<div class=" col-md-12">
									<div class="card mb-3">

										<div class="card-body">



											<div class="row">

												<table class="table table-borderless">


													<tr>
														<td>
															<p>Bill ID : ${billSearch.id}</p>
														</td>
														<td>
															<p>Bill Date : ${billSearch.date}</p>
														</td>
														<td>
															<p>Cashier ID : ${billSearch.cashireId}</p>
														</td>


													</tr>


													<tr>
														<td>
															<p>Gross Amount: ${billSearch.grossAmount}</p>
														</td>
														<td>
															<p>Net Amount : ${billSearch.netAmount}</p>

														</td>
														<td>
															<p>Total Discount : ${billSearch.totalDiscount}</p>


														</td>
													</tr>


												</table>

											</div>

										</div>
									</div>
									<!-- end card-->
								</div>
							</div>


							<!--  End the Details about of the Bill -->

							<div class="col-12">
								<div class="card mb-3">


									<div class="card-body">

										<table class="table table-responsive-xl table-bordered">
											<thead>

												<tr>

													<th scope="col">Item Number</th>
													<th scope="col">Quantity</th>
													<th scope="col">Amount</th>
													<th scope="col">Return</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="result" items="${bill_item}">

													<tr>

														<td>${result.itemNo}</td>
														<td>${result.qty}</td>
														<td>${result.amount}</td>
														<td>
															<form method="POST" action="toReturnNote"
																modelAttribute="item">
																
																<input type="hidden" name="id" value="${result.id}"> 
																<input type="hidden" name="billId" value="${result.billId}"> 
																<input type="hidden" name="itemNo" value="${result.itemNo}">
																<input type="hidden" name="qty" value="${result.qty}">
																<input type="hidden" name="amount" value="${result.amount}"> 
																<input type="hidden" name="price" value="${result.price}"> 
																<input type="hidden" name="reduseDiscount" value="${result.reduseDiscount}">
																<button type="submit" class="btn btn-primary">Return</button>
															</form>

														</td>
													</tr>






												</c:forEach>
											</tbody>

										</table>


									</div>
								</div>
								<!-- end card-->
							</div>



						</div>
					</div>
				</div>

				<!--  End the Table -->

				<!-- Start the  Return  Note  -->

				<form method="POST" action="printNote">

					<div class="col-12" style="margin: 60px">
						<div class="card mb-3">


							<div class="card-body">
								<table class="table table-responsive-xl table-bordered">
									<thead>
										<tr>

											<th scope="col">Item Number</th>
											<th scope="col">Quantity</th>
											<th scope="col">Amount</th>

										</tr>
									</thead>
									<tbody>

										<c:forEach var="result" items="${printNote_item}">
											<tr>

												<td>${result.itemNo}</td>
												<td>${result.qty}</td>
												<td>${result.amount}</td>

											</tr>


										</c:forEach>
									</tbody>
								</table>

								<div style="margin-left: 150px">

									<button type="submit" class="btn btn-primary">Print
										Note</button>

								</div>


							</div>
						</div>
					</div>

				</form>

				<!--End Return Note Table -->
			</div>

		</div>
		<!-- END container-fluid -->
	</div>
	<!-- END content -->
</div>

<%@ include file="../includes/footer.jsp"%>