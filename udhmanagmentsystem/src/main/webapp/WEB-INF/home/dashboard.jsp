<%@include file="../includes/menuAndSideBar.jsp"%>


<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">


			<div class="row">
				<div class="col-xl-12">
					<div class="breadcrumb-holder">
						<h1 class="main-title float-left">Dashboard</h1>
						<ol class="breadcrumb float-right">
							<li class="breadcrumb-item">Home</li>
							<li class="breadcrumb-item active">Dashboard</li>
						</ol>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->


			<div class="row">
				<div class="col-xl-12">
					<!-- Dashboard content  -->

					<div class="row">
						<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
							<div class="card-box noradius noborder bg-default">
								<i class="fa fa-file-text-o float-right text-white"></i>
								<h6 class="text-white text-uppercase m-b-20">Items</h6>
								<h1 class="m-b-20 text-white counter">${num}</h1>
								<a href="addStock" class="text-white"> <span>Add New</span></a>

							</div>
						</div>

						<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
							<div class="card-box noradius noborder bg-warning">
								<i class="fa fa-building-o float-right text-white"></i>
								<h6 class="text-white text-uppercase m-b-20">Suppliers</h6>
								<h1 class="m-b-20 text-white counter">${allSuppliers}</h1>
								<a href="addShop" class="text-white"> <span>Add New</span></a>

							</div>
						</div>

						<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
							<div class="card-box noradius noborder bg-info">
								<i class="fa fa-user-o float-right text-white"></i>
								<h6 class="text-white text-uppercase m-b-20">Prasent Employees</h6>
								<h1 class="m-b-20 text-white counter">${currentSize}</h1>
								<a href="addEmployee" class="text-white"> <span>Add
										New</span></a>
							</div>
						</div>

						<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
							<div class="card-box noradius noborder bg-danger">
								<i class="fa fa-bar-chart float-right text-white"></i>
								<h6 class="text-white text-uppercase m-b-20">Daily Profit</h6>
								<h1 class="m-b-20 text-white counter">${todaysProfite}</h1>
								</br>
							</div>
						</div>

						<!-- Bar Chart -->
						<div class="col-12">
							<div class="card mb-3">
								<div class="card-header">
									<h3>
										<i class="fa fa-users"></i> Daily profit
									</h3>


								</div>

								<div class="card-body">

									<table id="example1"
										class="table table-bordered table-responsive-xl table-hover display">
										<thead>
											<tr>
												<th>Date</th>
												<th>Expenditure Amount</th>
												<th>Business Amount</th>
												<th>Net Profit</th>

											</tr>
										</thead>
										<tbody>
											
												<c:forEach var="result" items="${getDailyBusiness}">
												<tr>

													<td>${result.date}</td>
													<td>${result.expenseAmount}</td>
													<td>${result.bussinesAmount}</td>
													<td>${result.netProfite}</td>

												</tr>

												<tr>
											</c:forEach>
										</tbody>
									</table>

								</div>
							</div>
							<!-- end card-->
						</div>
						<!-- end it -->

					</div>

					<h1>${msg}</h1>
				</div>
			</div>



		</div>
		<!-- END container-fluid -->

	</div>
	<!-- END content -->

</div>
<!-- END content-page -->

<!-- JS -->


<!-- END Java Script for this page -->

<!-- End JS -->

<%@ include file="../includes/footer.jsp"%>
