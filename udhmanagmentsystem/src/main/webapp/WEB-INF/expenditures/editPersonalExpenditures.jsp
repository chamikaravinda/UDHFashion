
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.UDHFashion.udhmanagmentsystem.model.User"%>

<script>
	function validator() {

		var shopName = document.getElementById("shopName").value;
		var shopAddress = document.getElementById("shopAddress").value;
		var shopTele = document.getElementById("shopTele").value;

		if (shopName == null || shopName == "") {
			alert("Please Enter a shop name ");
			return false;
		}

		if (shopAddress == null || shopAddress == "") {
			alert("Please Enter a shop name ");
			return false;
		}

		if (shopTele == null || shopTele == "") {
			alert("Please enter a shop telephone number ");
			return false;
		}

		if (shopTele.length != 10) {
			alert("Telephone number must contain 10 characters");
			return false;
		}
	}
</script>

<meta charset="ISO-8859-1">
<title>Edit Shop Expenditures</title>
</head>
<body>

	<%
		if (session.getAttribute("user") == null) {
			response.sendRedirect("login");
		} else {
			User user = (User) session.getAttribute("user");
			if (user.getRole().equals("casher")) {
				response.sendRedirect("/error");
			}

		}
	%>

	<div class="content-page">

		<!-- Start content -->
		<div class="content">

			<div class="container-fluid">


				<div class="row">
					<div class="col-xl-12">
						<div class="breadcrumb-holder">
							<h1 class="main-title float-left">Shop Expenditures</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Home</li>
								<li class="breadcrumb-item active">Update</li>
							</ol>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<br> <br> <br> <br> <br>
				<!-- end row -->

				<div class="row">

					<div class=" col-md-12">
						<div class="card mb-3">

							<div class="card-body">

								<form:form method="POST" action="updatePersonalExpenditures"
									modelAttribute="p_expenditures">

									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="exampleInputEmail1">ID</label>
											<form:input type="text" path="id" class="form-control"
												aria-describedby="numberlHelp" placeholder=""
												required="required" />

										</div>
										<div class="form-group col-md-6">
											<label for="exampleInputEmail1">Date</label>
											<form:input type="Date" path="date" class="form-control"
												aria-describedby="emailHelp" placeholder=""
												required="required" />
										</div>

									</div>

									<div class="form-row">

										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Reason</label>
											<form:input type="text" path="reason" class="form-control"
												placeholder="" required="required" />
										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Amount</label>
											<form:input type="text" path="amount" class="form-control"
												placeholder="" required="required" />
										</div>
									</div>

									<form:input type="hidden" path="id" />

									<div style="margin-left: 500px">
										<button type="submit" class="btn btn-primary">Update</button>
									</div>
								</form:form>

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