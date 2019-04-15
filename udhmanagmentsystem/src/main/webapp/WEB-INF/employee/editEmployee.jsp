
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
							<h1 class="main-title float-left">Update Employee</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Home</li>
								<li class="breadcrumb-item active">Update Employee</li>
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

								<form:form method="POST" action="submitUpdateEmployee" modelAttribute="employee" >
								<div class="form-group">
									
									
										<label for="exampleInputEmail1">Employee No </label> <form:input
											type="text" path="empNo" class="form-control"
											 aria-describedby="emailHelp"
											placeholder="" readonly="true" required="required"/> 
									</div>

								<div class="form-row">
									
									
									
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Employee Name</label> <form:input
											type="text" path="empName" class="form-control"
											 aria-describedby="numberlHelp"
											placeholder="" required="required"/>

									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Address</label> <form:input
											type="text" path="empAddress" class="form-control"
											 placeholder="" required="required"/>
									</div>
									
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">BasicSalary</label> <form:input
											type="text" path="basicSalary" class="form-control"
											 placeholder="" required="required"/>
									</div>
									
								</div>
								
										
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Job date</label> <form:input
											type="Date" path="jobDate" class="form-control"
											 placeholder=""  required="required"/>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Telephone</label> <form:input
											type="number" path="contactNum" class="form-control"
											 placeholder="" required="required"/>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Guardian Telephone</label> <form:input
											type="number" path="gContactNum" class="form-control"
											 placeholder="" required="required"/>
									</div>
								</div>
								
									<div style="margin-left: 500px">
										<button type="submit" class="btn btn-primary">Update Employee</button>
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

</body>
</html>
<%@ include file="../includes/footer.jsp"%>