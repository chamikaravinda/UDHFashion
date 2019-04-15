
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
<title>Insert title here</title>
</head>
<body>


	<!-- Add employee unsuccess message -->
	<script type="text/javascript">
		function unsuccesfull() {
			swal("Employee Adding Unsuccesfull");
		}
	</script>

	<c:if test="${error == 1}">
		<script type="text/javascript">
			window.onload = unsuccesfull;
		</script>
	</c:if>

	<!-- employee number exsists message -->
	<script type="text/javascript">
		function EmpNumberTaken() {
			swal("Employee Number Already taken");
		}
	</script>

	<c:if test="${error == 2}">
		<script type="text/javascript">
			window.onload = EmpNumberTaken;
		</script>
	</c:if>

	<div class="content-page">

		<!-- Start content -->
		<div class="content">

			<div class="container-fluid">

				<div class="row">
					<div class="col-xl-12">
						<div class="breadcrumb-holder">
							<h1 class="main-title float-left">Add Employee</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Home</li>
								<li class="breadcrumb-item active">Employee</li>
							</ol>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<!-- end row -->
				<br>
				<br>
				<div class="row">

					<div class=" col-md-12">
						<div class="card mb-3">

							<div class="card-body">

								<form method="POST" action="submitEmployee"
									modelAttribute="employee" onsubmit="return validator()">

									<div class="form-group">

										<label for="exampleInputEmail1">Employee No </label> <input
											type="text" name="empNo" class="form-control" id="empNo"
											aria-describedby="emailHelp" placeholder="Employee No"
											required>

									</div>

									<div class="form-row">


										<div class="form-group col-md-4">
											<label for="exampleInputEmail1">Employee Name</label> <input
												type="text" name="empName" class="form-control" id="empName"
												aria-describedby="numberlHelp" placeholder="Employee Name"
												required>

										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Address</label> <input
												type="text" name="empAddress" class="form-control"
												id="empAddress" placeholder="Address" required>
										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputEmail1">Basic Salary</label> <input
												type="number" name="basicSalary" class="form-control"
												id="basicSalary" aria-describedby="numberlHelp"
												placeholder="Basic Salary" required>

										</div>

									</div>


									<div class="form-row">
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Job date</label> <input
												type="Date" name="jobDate" class="form-control" id="jobDate"
												placeholder="Date" required>
										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Telephone</label> <input
												type="number" name="contactNum" class="form-control"
												id="contactNum" placeholder="Telephone" max="9999999999"
												required>
										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Guardian Telephone</label>
											<input type="number" name="gContactNum" class="form-control"
												id="gContactNum" placeholder="Guardian Telephone"
												max="9999999999" required>
										</div>
									</div>
									<br><br>
									<div class="offset-md-5">
										<button type="submit" class="btn btn-primary col-md-2">Add
											</button>
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