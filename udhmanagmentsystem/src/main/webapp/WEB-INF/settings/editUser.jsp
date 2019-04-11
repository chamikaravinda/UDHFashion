
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
			swal("Account Update Succesfully");
		}
	</script>

	<c:if test="${success == 1}">
		<script type="text/javascript">
			window.onload = addedsuccesfully;
		</script>
	</c:if>

	<!-- update error message -->
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
	
		<!-- username taken error message -->
	<!-- Username taken error message -->
	<script type="text/javascript">
		function usernameerror() {
			swal("Unsuccessful","Username already in use.Choose another username","error");
		}
	</script>

	<c:if test="${error == 2}">
		<script type="text/javascript">
			window.onload = usernameerror;
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
								<div class="text-right">

									<p>
										<a href="deleteUser?id=${user.id}"><i class="fa fa-trash"
											aria-hidden="true"></i> Delete User</a>
									</p>

								</div>
								<br>
								<div>
									<form:form method="post" action="updateUser"
										modelAttribute="user">
										<div class="form-row ">
											<fieldset class="form-group  col-md-5   ">
												<label for="exampleInputEmail1">First Name</label>
												<form:input type="text" path="fname" class="form-control"
													placeholder="Bank Name" required="required" />
											</fieldset>

											<fieldset class="form-group  col-md-5 offset-md-1  ">
												<label for="exampleInputEmail1">Last Name</label>
												<form:input type="text" path="lname" class="form-control"
													placeholder="Account Number" required="required" />
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
											<form:input type="hidden" path="id" />
											<form:input type="hidden" path="password" />

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
										<div class="text-left">
												<p>
													<a href="passwordUpdate?id=${user.id}"><i
														class="fa fa-key" aria-hidden="true"></i> Password Update</a>
												</p>
										</div>
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

</body>
</html>
<%@ include file="../includes/footer.jsp"%>