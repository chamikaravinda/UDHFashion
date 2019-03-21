
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">


			<div class="row">
				<div class="col-xl-12">
					<div class="breadcrumb-holder">
						<h1 class="main-title float-left">Advance Payment</h1>
						<ol class="breadcrumb float-right">
							<li class="breadcrumb-item">Home</li>
							<li class="breadcrumb-item active">Payments</li>
						</ol>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->
			<br><br><br><br><br><br><br><br>
			<div class="row">
				
				<div class=" col-md-8 offset-md-2">
					<div class="card mb-3">

						<div class="card-body">

							<form method="POST" action="advancePayment"
								modelAttribute="advancePayment">
							


								<div class="form-row">
									<div class="form-group col-md-4 offset-md-4">
										<label for="exampleInputPassword1">Employee Number</label> <input
											type="number" name="empNo" class="form-control" id="empNo"
											placeholder="Employee ID" required>
									</div>
									
								
									
																		
								</div>
									<div class="form-row">
									
										<div class="form-group col-md-4 offset-md-4">
										<label for="exampleInputPassword1">Amount</label> <input
											type="number" name="amount" class="form-control"
											id="amount" placeholder="submit Amount to pay" required>
									</div>
									
									
									</div>
								<div style="margin-left: 450px">
									<button type="submit" class="btn btn-primary">Pay
										Employee</button>
								</div>

							</form>

						</div>
					</div>
					<!-- end card-->
				</div>
			</div>
		</div>
		<!-- END container-fluid -->
	</div>
	<!-- END content -->
</div>
<%@ include file="../includes/footer.jsp"%>