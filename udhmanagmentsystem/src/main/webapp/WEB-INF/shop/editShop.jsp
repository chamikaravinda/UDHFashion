
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.UDHFashion.udhmanagmentsystem.model.User"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
							<h1 class="main-title float-left">Update Whole Sale Shop</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Home</li>
								<li class="breadcrumb-item active">Forms</li>
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

								<form:form method="POST" action="submitUpdateShop"
									modelAttribute="updateShop">
									<div class="form-group">
										<label for="exampleInputEmail1">Shop Name</label>
										<form:input type="text" class="form-control" path="name"
											aria-describedby="emailHelp" placeholder=""
											required="required" />

									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Address</label>
										<form:input type="text" class="form-control" path="address"
											aria-describedby="" placeholder="" required="required" />

									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Telephone</label>
										<form:input type="number" class="form-control"
											path="telephone" placeholder="" required="required" />
									</div>

									<form:input type="hidden" path="id" />
									<button type="submit" class="btn btn-primary">Update</button>
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