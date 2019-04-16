
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
</script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<div class="content-page">

		<!-- Start content -->
		<div class="content">

			<div class="container-fluid">


				<div class="row">
					<div class="col-xl-12">
						<div class="breadcrumb-holder">
							<h1 class="main-title float-left">Add Shop Expenditures</h1>
							<ol class="breadcrumb float-right">
									<li class="breadcrumb-item">Home</li>
							<li class="breadcrumb-item active">Expenditures</li>
							</ol>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<br><br><br><br><br>
				<!-- end row -->

				<div class="row">

					<div class=" col-md-12">
						<div class="card mb-3">

							<div class="card-body">

								<form method="POST" action="submitShopExpenditures"
									modelAttribute="ShopExpenditures">

									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="exampleInputEmail1">Date </label> <input
												type="Date" name="date" class="form-control" id="date"
												aria-describedby="emailHelp" placeholder="Date" required>
										</div>
										<div class="form-group col-md-6">
											<label for="exampleInputEmail1">Bill No</label> <input
												type="text" name="billNo" class="form-control" id="billNo"
												aria-describedby="numberlHelp" placeholder="Bill No"
												required>

										</div>
									</div>
										
									<div class="form-row">
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Name</label> <input
												type="text" name="name" class="form-control" id="name"
												placeholder="Name" required>
										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Reason</label> <input
												type="text" name="reason" class="form-control" id="reason"
												placeholder="Reason" required>
										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Amount</label> <input
												type="text" name="amount" class="form-control" id="amount"
												placeholder="Amount" required>
										</div>
									</div>

										<div style="margin-left: 500px">
											<button type="submit" class="btn btn-primary">Add</button>
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

</body>
</html>
<%@ include file="../includes/footer.jsp"%>