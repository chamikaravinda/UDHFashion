
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.UDHFashion.udhmanagmentsystem.model.User"%>

<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("login");
	} else {
		User user = (User) session.getAttribute("user");
		User editUser = (User) request.getAttribute("user");
		if (user.getRole().equals("casher") && user.getId() != editUser.getId()) {
			response.sendRedirect("/error");
		}

	}
%>
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
			swal("Account Update Succesfully");
		}
	</script>

	<c:if test="${success == 1}">
		<script type="text/javascript">
			window.onload = addedsuccesfully;
		</script>
	</c:if>

	<!--incorrect current password error message -->
	<script type="text/javascript">
		function incorrectPassword() {
			swal("Unsuccessful", "Current Password is incorrect", "error");
		}
	</script>

	<c:if test="${error == 1}">
		<script type="text/javascript">
			window.onload = incorrectPassword;
		</script>
	</c:if>

	<!-- Password miss match error message -->
	<script type="text/javascript">
		function passwordmissmatch() {
			swal("Unsuccessful", "Password and Confirm Password don't match",
					"error");
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
							<h1 class="main-title float-left">User Account</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Settings</li>
								<li class="breadcrumb-item active">Users</li>
							</ol>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<!-- end row -->
				<div class="row">

					<div class=" col-md-12">
						<div class="card">
							<div class="card-body">
								<c:if test="${sessionScope.user.role != 'casher'}">
									<div class="text-right">

										<p>
											<a href="deleteUser?id=${user.id}"><i class="fa fa-trash"
												aria-hidden="true"></i> Delete User</a>
										</p>

									</div>
								</c:if>
								<br>
								<div>
									<form:form method="post" action="passwordUpdate"
										modelAttribute="user">

										<form:input type="hidden" path="fname" />

										<form:input type="hidden" path="lname" />
										<form:input type="hidden" path="role" />
										<form:input type="hidden" path="username" />
										<form:input type="hidden" path="id" />
										<div class="form-row ">
											<fieldset class="form-group  col-md-6 offset-md-3">
												<label for="exampleInputEmail1">Current Password</label>
												<form:input type="password" path="password"
													class="form-control" id="password" placeholder="Password"
													onkeyup='check();' required="required" />
											</fieldset>

											<fieldset class="form-group  col-md-6 offset-md-3">
												<label for="exampleInputEmail1">New Password </label>
												<form:input type="password" path="npassword"
													class="form-control" id="new_password"
													placeholder="New Password" onkeyup='check();'
													required="required" />
											</fieldset>

											<fieldset class="form-group  col-md-6 offset-md-3  ">
												<label for="exampleInputEmail1">Confirm Password </label>
												<form:input type="password" path="cpassword"
													class="form-control" id="confirm_password"
													placeholder="Confirm Password" onkeyup='check();'
													required="required" />
											</fieldset>
											<fieldset class="form-group  col-md-6 offset-md-3  ">
												<label for="exampleInputEmail1">

													<h6 id='message'></h6>
											</fieldset>
										</div>
										<br>
										<br>
										<div class="col-md-2 offset-md-5">

											<button type="submit" class="btn btn-primary">
												<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												Update
											</button>

										</div>
										<br>
										<br>
									</form:form>

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

			if (document.getElementById('new_password').value !== '') {
				if (document.getElementById('confirm_password').value !== '') {
					if (document.getElementById('new_password').value == document
							.getElementById('confirm_password').value) {
						document.getElementById('message').style.color = 'green';
						document.getElementById('message').innerHTML = 'Password Matches';
					} else {
						document.getElementById('message').style.color = 'red';
						document.getElementById('message').innerHTML = 'New Password and Confirm Password not matching';
					}
				}
			}
		}
	</script>
</body>
</html>
<%@ include file="../includes/footer.jsp"%>