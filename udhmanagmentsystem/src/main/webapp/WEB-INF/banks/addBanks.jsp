
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import = "com.UDHFashion.udhmanagmentsystem.model.User" %>
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
		}else {
			User user = (User) session.getAttribute("user"); 
			if(user.getRole().equals("casher")){
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
							<h1 class="main-title float-left">Add Bank Account</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Home</li>
								<li class="breadcrumb-item active">Bank Account</li>
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
							<br> <br> <br>
							<div class="card-body">
								<div class="offset-md-2">
									<form:form method="post" action="addBanks"
										modelAttribute="bankAccount">
										<div class="form-row ">
											<fieldset class="form-group  col-md-4   ">
												<label for="exampleInputEmail1">Bank Name</label>
												<form:input type="text" path="bankName" class="form-control"
													placeholder="Bank Name" required="required" />
											</fieldset>

											<fieldset class="form-group  col-md-4 offset-md-1  ">
												<label for="exampleInputEmail1">Account Number</label>
												<form:input type="text" path="accountNumber"
													class="form-control" placeholder="Account Number"
													required="required" />
											</fieldset>
										</div>
										<br>
										<div class="form-row ">
											<fieldset class="form-group col-md-4  ">
												<label for="exampleInputEmail1">Account Type</label>
												<form:select path="accountType" class="form-control"
													required="required">
													<option selected="true" disabled="disabled">Select
														account type</option>
													<form:option value="currentAccount"> Current Account </form:option>
													<form:option value="savingsAccount"> Savings Account </form:option>
												</form:select>
											</fieldset>

											<fieldset class="form-group col-md-4  offset-md-1">
												<label for="exampleInputEmail1">Current Balance</label>
												<form:input type="number" path="currentBalance"
													class="form-control" placeholder="Current Balance"
													required="required" />
											</fieldset>
										</div>
										<br>

										<div style="margin-left: 310px">
											<button type="submit" class="btn btn-primary">
												<i class="fa fa-plus" aria-hidden="true"></i> Add Account
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

</body>
</html>
<%@ include file="../includes/footer.jsp"%>