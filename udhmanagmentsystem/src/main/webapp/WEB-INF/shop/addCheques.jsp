
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.UDHFashion.udhmanagmentsystem.service.IShopDAO"%>
<%@page import="com.UDHFashion.udhmanagmentsystem.service.ShopDAOImpl"%>
<%@page import="com.UDHFashion.udhmanagmentsystem.model.Shop"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit Bills</title>
</head>
<body>


	<div class="content-page">

		<!-- Start content -->
		<div class="content">

			<div class="container-fluid">


				<div class="row">
					<div class="col-xl-12">
						<div class="breadcrumb-holder">
							<h1 class="main-title float-left">Add Cheque</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Home</li>
								<li class="breadcrumb-item active">Cheque</li>
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

								<form method="POST" action="viewcreditBills"
									modelAttribute="creditBills" onsubmit="return validator()">

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Bill No</label> <input
											type="text" name="billNo" class="form-control"
											id="billNo" aria-describedby="emailHelp"
											placeholder="Bill No" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Billing Date</label> <input
											type="text" name="bilingDate" class="form-control"
											id="bilingDate" aria-describedby="numberlHelp"
											placeholder="Bill Date" required>

									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Shop No</label> <input
											type="number" name="shopNo" class="form-control"
											id="shopNo" placeholder="Shop No" required>
									</div>
									
								</div>
								
								<div class="form-row">
									
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Shop Name</label> <input
											type="test" name="shopName" class="form-control"
											id="shopName" placeholder="Shop Name" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Bank Name</label> <input
											type="text" name=""bankName"" class="form-control"
											id="bankName" placeholder="Bank Name" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Bank Account No</label> <input
											type="number" name="bankAccNo" class="form-control"
											id="bankAccNo" placeholder="Bank Account No" required>
									</div>
									
									
								</div>
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Cheque No</label> <input
											type="number" name="chequeNo" class="form-control"
											id="chequeNo" placeholder="Cheque No" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Cheque Amount</label> <input
											type="number" name="chequeAmount" class="form-control"
											id="chequeAmount" placeholder="Cheque Amount" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Cheque Date</label> <input
											type="text" name="chequeDate" class="form-control"
											id="chequeDate" placeholder="Cheque Date" required>
									</div>
									
									</div>
									<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Payment Date</label> <input
											type="number" name="payDate" class="form-control"
											id="payDate" placeholder="Payment Date" required>
									</div>
									
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Payment Amount</label> <input
											type="number" name="paymentAmount" class="form-control"
											id="paymentAmount" placeholder="Payment Amount" required>
									</div>
									
									
									</div>

									<div style="margin-left: 500px">
										<button type="submit" class="btn btn-primary">Add Cheque</button>
									</div>

								</form>

							</div>
						</div>
						<!-- end card-->
					</div>
				</div>
			</div>
			<!-- END content -->

		</div>
</body>
</html>
<%@ include file="../includes/footer.jsp"%>le="../includes/footer.jsp"
%>
