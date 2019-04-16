
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


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
							<h1 class="main-title float-left">Add Personal Expenditures</h1>
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

								<form method="POST" action="submitPersonalExpenditures"
									modelAttribute="PersonalExpenditures" >

									
										<div class="form-group ">
											<label for="exampleInputEmail1">Date</label> <input
												type="Date" name="date" class="form-control" id="date"
												aria-describedby="numberlHelp" placeholder="Date"
												required>

										</div>
										
										<div class="form-group ">
											<label for="exampleInputEmail1">Reason</label> <input
												type="text" name="reason" class="form-control" id="reason"
												aria-describedby="numberlHelp" placeholder="Reason"
												required>

										</div>
									<div class="form-group ">
											<label for="exampleInputEmail1">Amount</label> <input
												type="number" name="amount" class="form-control" id="amount"
												aria-describedby="numberlHelp" placeholder="Bill No"
												required>

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