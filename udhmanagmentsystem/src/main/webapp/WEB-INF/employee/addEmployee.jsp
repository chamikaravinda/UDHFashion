
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


	<!-- Add employee unsuccess message -->
	<script type="text/javascript">
		function unsuccesfull() {
			swal("Unsuccessful", "Employee Adding Unsuccesfull", "error");
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
			swal("Unsuccessful", "Employee Number Already taken", "error");
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
				<br> <br>
				<div class="row">

					<div class=" col-md-12">
						<div class="card mb-3">

							<div class="card-body">

								<form:form method="POST" action="submitEmployee"
									modelAttribute="employee">

									<div class="form-group">

										<label for="exampleInputEmail1">Employee No </label>
										<form:input type="text" path="empNo" class="form-control"
											id="empNo" aria-describedby="emailHelp"
											placeholder="Employee No" required="required" />

									</div>

									<div class="form-row">


										<div class="form-group col-md-4">
											<label for="exampleInputEmail1">Employee Name</label>
											<form:input type="text" path="empName" class="form-control"
												id="empName" aria-describedby="numberlHelp"
												placeholder="Employee Name" required="required" />

										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Address</label>
											<form:input type="text" path="empAddress"
												class="form-control" id="empAddress" placeholder="Address"
												required="required" />
										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputEmail1">Basic Salary</label>
											<form:input type="number" path="basicSalary"
												class="form-control" id="basicSalary"
												aria-describedby="numberlHelp" placeholder="Basic Salary"
												required="required" />
										</div>

									</div>


									<div class="form-row">
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Job date</label>
											<form:input type="Date" path="jobDate" class="form-control"
												id="jobDate" placeholder="Date" required="required" />
										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Telephone</label>
											<form:input type="number" path="contactNum"
												class="form-control" id="contactNum" placeholder="Telephone"
												max="9999999999" required="required" />
										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputPassword1">Guardian Telephone</label>
											<form:input type="number" path="gContactNum"
												class="form-control" id="gContactNum"
												placeholder="Guardian Telephone" max="9999999999"
												required="required" />
										</div>
									</div>
									<br>
									<br>
									<div class="offset-md-5">
										<button type="submit" class="btn btn-primary col-md-2">Add
										</button>
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