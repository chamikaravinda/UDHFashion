
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
							<h1 class="main-title float-left">Add Deposit</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Home</li>
								<li class="breadcrumb-item active">Bank Account</li>
							</ol>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<!-- end row -->
				<br> <br> <br>
				<div class="row">

					<div class=" col-md-12">
						<div class="card">
							<br> <br> <br>
							<div class="card-body">
								<div class="offset-md-2">
									<form:form method="post" action="addDeposites"
										modelAttribute="bankDeposit">
										<div class="form-row ">
											<fieldset class="form-group  col-md-4   ">
												<form:input type="Date" path="date" class="form-control"
													required="required" />
											</fieldset>

											<fieldset class="form-group  col-md-4 offset-md-1  ">
												<form:input type="number" path="amount" class="form-control"
													placeholder="Amount" required="required" />
											</fieldset>
										</div>
										<br>
										<div class="form-row ">
											<fieldset class="form-group col-md-4  ">
												<form:select path="account" class="form-control"
													required="required">
													<option selected="true" disabled="disabled">Select
														an account</option>
													<c:forEach var="account" items="${accounts}">
														<form:option value="${account.id}"> ${account.bankName} : ${account.accountNumber} </form:option>
													</c:forEach>
												</form:select>
											</fieldset>
										</div>
										<br>

										<div style="margin-left: 310px">
											<button type="submit" class="btn btn-primary">Add
												Deposit</button>
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

</body>
</html>
<%@ include file="../includes/footer.jsp"%>