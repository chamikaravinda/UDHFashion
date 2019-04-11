
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
	<!-- added success message -->
	<script type="text/javascript">
		function addedsuccesfully() {
			swal("Successful","User Adding Succesfully","success");
		}
	</script>

	<c:if test="${success == 1}">
		<script type="text/javascript">
			window.onload = addedsuccesfully;
		</script>
	</c:if>

	<!-- add error message -->
	<script type="text/javascript">
		function updateerror() {
			swal("Unsuccessful","Unexpected Error occured","error");
		}
	</script>

	<c:if test="${error == 1}">
		<script type="text/javascript">
			window.onload = updateerror;
		</script>
	</c:if>

	<!-- Username taken error message -->
	<script type="text/javascript">
		function usernameerror() {
			swal("Unsuccessful","Username already in use.Choose another username","error");
		}
	</script>

	<c:if test="${error == 3}">
		<script type="text/javascript">
			window.onload = usernameerror;
		</script>
	</c:if>

	<!-- Password miss match error message -->
	<script type="text/javascript">
		function passwordmissmatch() {
			swal("Unsuccessful","Password and Confirm Password don't match","error");
		}
	</script>

	<c:if test="${error == 2}">
		<script type="text/javascript">
			window.onload = passwordmissmatch;
		</script>
	</c:if>


	<div class="content-page">

		<!-- Start content -->
		<div class="content">

			<div class="container-fluid">


				<div class="row">
					<div class="col-xl-12">
						<div class="breadcrumb-holder">
							<h1 class="main-title float-left">New User Account</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Settings</li>
								<li class="breadcrumb-item active">Users</li>
							</ol>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<!-- end row -->
				<br>

				<div class="row">

					<div class=" col-md-12">
						<div class="card">
							<br>
							<div class="card-body">
								<div>
									<form:form method="post" action="addUser" modelAttribute="user">
										<div class="form-row ">
											<fieldset class="form-group  col-md-5   ">
												<label for="exampleInputEmail1">First Name</label>
												<form:input type="text" path="fname" class="form-control"
													placeholder="First Name" required="required" />
											</fieldset>

											<fieldset class="form-group  col-md-5 offset-md-1  ">
												<label for="exampleInputEmail1">Last Name</label>
												<form:input type="text" path="lname" class="form-control"
													placeholder="Last Name" required="required" />
											</fieldset>
										</div>
										<br>
										<div class="form-row ">
											<fieldset class="form-group col-md-5  ">
												<label for="exampleInputEmail1">Role</label>
												<form:select path="role" class="form-control"
													required="required">
													<option selected="true" disabled="disabled">Select
														account type</option>
													<form:option value="admin"> Admin </form:option>
													<form:option value="manager"> Manager</form:option>
													<form:option value="casher"> Casher</form:option>
												</form:select>
											</fieldset>

											<fieldset class="form-group col-md-5  offset-md-1">
												<label for="exampleInputEmail1">Username</label>
												<form:input type="text" path="username" class="form-control"
													placeholder="Username" required="required" />
											</fieldset>
										</div>
										<br>
										<div class="form-row ">
											<fieldset class="form-group  col-md-5   ">
												<label for="exampleInputEmail1">Password</label>
												<form:input type="password" path="password"
													class="form-control" id="password" placeholder="Password"
													onkeyup='check();' required="required" />
											</fieldset>

											<fieldset class="form-group  col-md-5 offset-md-1  ">
												<label for="exampleInputEmail1">Confirm Password </label>
												<form:input type="password" path="cpassword"
													class="form-control" id="confirm_password"
													placeholder="Confirm Password" onkeyup='check();'
													required="required" />
											</fieldset>
										</div>
										<div class="form-row ">
											<h6 id='message'></h6>
										</div>
										<br>
										<div class="col-md-2 offset-md-5">

											<button type="submit" class="btn btn-primary">
												<i class="fa fa-plus" aria-hidden="true"></i> Add
											</button>

										</div>

									</form:form>
									<br> <br>
								</div>
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
	<script>
		var check = function() {
			if (document.getElementById('password').value !== '') {
				if (document.getElementById('confirm_password').value !== '') {
					if (document.getElementById('password').value == document
							.getElementById('confirm_password').value) {
						document.getElementById('message').style.color = 'green';
						document.getElementById('message').innerHTML = 'Password Matches';
					} else {
						document.getElementById('message').style.color = 'red';
						document.getElementById('message').innerHTML = 'Password do not match';
					}
				}
			}
		}
	</script>
</body>
</html>
<%@ include file="../includes/footer.jsp"%>