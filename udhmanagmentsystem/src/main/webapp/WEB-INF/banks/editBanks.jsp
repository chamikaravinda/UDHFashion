
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

	<div class="content-page">

		<!-- Start content -->
		<div class="content">

			<div class="container-fluid">


				<div class="row">
					<div class="col-xl-12">
						<div class="breadcrumb-holder">
							<h1 class="main-title float-left">Edit Bank Account</h1>
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
									<form:form method="post" action="editBanks"
										modelAttribute="bankAccount">
										<div class="form-row ">
											<fieldset class="form-group  col-md-4   ">
												<form:input type="text" path="bankName" class="form-control"
													placeholder="Bank Name" required="required" />
											</fieldset>

											<fieldset class="form-group  col-md-4 offset-md-1  ">
												<form:input type="text" path="accountNumber"
													class="form-control" placeholder="Account Number"
													required="required" />
											</fieldset>
										</div>
										<br>
										<div class="form-row ">
											<fieldset class="form-group col-md-4  ">
												<form:select path="accountType" class="form-control"
													required="required">
													<form:option value="currentAccount"> Current Account </form:option>
													<form:option value="savingsAccount"> Savings Account </form:option>
												</form:select>
											</fieldset>

											<fieldset class="form-group col-md-4  offset-md-1">
												<form:input type="number" path="currentBalance"
													class="form-control" placeholder="Current Balance"
													required="required" />
											</fieldset>

											<form:input type="hidden" path="id"/>

										</div>
										<br>

										<div style="margin-left: 310px">
											<button type="submit" class="btn btn-primary">Update Account</button>
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