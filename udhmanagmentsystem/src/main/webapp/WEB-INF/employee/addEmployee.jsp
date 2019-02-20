
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

				<div class="row">

					<div class=" col-md-12">
						<div class="card mb-3">

							<div class="card-body">

								<form method="POST" action="viewEmployee" modelAttribute="employee"
									onsubmit="return validator()">


									<div class="form-group">
										<label for="exampleInputEmail1">Employee No </label> <input
											type="number" name="empNo" class="form-control"
											id="employeeNo" aria-describedby="emailHelp"
											placeholder="Employee No" required> 
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Employee Name</label> <input
											type="text" name="shopAddress" class="form-control"
											id="empName" aria-describedby="numberlHelp"
											placeholder="Employee Name" required>

									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Address</label> <input
											type="text" name="shopTelephone" class="form-control"
											id="address" placeholder="Address" required>
									</div>
										<div class="form-group">
										<label for="exampleInputPassword1">Telephone</label> <input
											type="number" name="eTel" class="form-control"
											id="eTel" placeholder="Telephone" required>
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Guardian Telephone</label> <input
											type="number" name="gTel" class="form-control"
											id="gTel" placeholder="Guardian Telephone" required>
									</div>
									<div style="margin-left: 500px">
										<button type="submit" class="btn btn-primary">Add Employee</button>
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