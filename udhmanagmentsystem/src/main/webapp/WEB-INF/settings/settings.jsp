<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ page import="com.UDHFashion.udhmanagmentsystem.model.User"%>

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
<!-- added success message -->
<script type="text/javascript">
	function addedsuccesfully() {
		swal("Successful", "User Added Succesfully", "success");
	}
</script>

<c:if test="${success == 1}">
	<script type="text/javascript">
		window.onload = addedsuccesfully;
	</script>
</c:if>

<!-- update success message -->
<script type="text/javascript">
	function updatesuccesfully() {
		swal("Successful", "User Updated Successfully ", "success");
	}
</script>

<c:if test="${success == 2}">
	<script type="text/javascript">
		window.onload = updatesuccesfully;
	</script>
</c:if>

<!-- delete success message -->
<script type="text/javascript">
	function deleteSuccesfully() {
		swal("Successful", "User Deleted Successfully ", "success");
	}
</script>

<c:if test="${success == 3}">
	<script type="text/javascript">
		window.onload = deleteSuccesfully;
	</script>
</c:if>

<!-- Password update success message -->
<script type="text/javascript">
	function passwordUpdatedSuccesfully() {
		swal("Successful", "User Password Updated Successfully ", "success");
	}
</script>
<c:if test="${success == 4}">
	<script type="text/javascript">
		window.onload = passwordUpdatedSuccesfully;
	</script>
</c:if>

<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">
			<div class="row">
				<div class="col-xl-12">
					<div class="breadcrumb-holder">
						<h1 class="main-title float-left">Settings</h1>
						<ol class="breadcrumb float-right">
							<li class="breadcrumb-item">Home</li>
							<li class="breadcrumb-item active">Settings</li>
						</ol>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->

			<div class="row">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="col-md-12a"></div>

						<div class="card-body">
							<div class="row">
								<div class="col-md-4">
									<span><h5>User Accounts</h5> <br> <a href="addUser"
										class="btn btn-sm btn-primary" role="button"
										aria-pressed="true"><i class="fa fa-plus"
											aria-hidden="true"></i> New User</a></span>
								</div>

							</div>
							<br> <br>
							<div class="table-responsive">
								<table id="example1"
									class="table table-bordered table-hover display">
									<thead>
										<tr>
											<th>First Name</th>
											<th>Last Name</th>
											<th>User Name</th>
											<th>Role</th>
											<td><span><i class="fa fa-pencil-square"
													aria-hidden="true"></i></span></td>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="result" items="${users}">
											<tr>
												<td>${result.fname}</td>
												<td>${result.lname}</td>
												<td>${result.username}</td>
												<td>${result.role}</td>
												<td><a
													href="<c:url value='/editUser?id=${result.id}' />"><i
														class="fa fa-share" aria-hidden="true"></i></a></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>

							</div>
						</div>
						<!-- end card-->
					</div>

					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">

					</div>

				</div>
			</div>
			<!-- END container-fluid -->

		</div>
		<!-- END content -->

	</div>
</div>

<%@ include file="../includes/footer.jsp"%>
