
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

<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">


			<div class="row">
				<div class="col-xl-12">
					<div class="breadcrumb-holder">
						<h1 class="main-title float-left">Credit Bill Cheque Payment</h1>
						<ol class="breadcrumb float-right">
							<li class="breadcrumb-item">Home</li>
							<li class="breadcrumb-item active">Cheque</li>
						</ol>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->
			<br>
			<div class="row">

				<div class=" col-md-12">
					<div class="card mb-3">

						<div class="card-body">

							<form:form method="POST" action="existCreditBillChequePayments"
								modelAttribute="creditBills">

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Bill No</label>
										<form:input type="text" path="billNo" class="form-control"
											id="billNo" aria-describedby="emailHelp"
											placeholder="Bill No" required="required" />
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Billing Date</label>
										<form:input type="Date" path="billDate" class="form-control"
											id="billDate" aria-describedby="numberlHelp"
											placeholder="Bill Date" required="required" />

									</div>

									<div class="form-group col-md-4">
										<label for="sel1">Shop Name</label>
										<form:input type="text" path="shopName" class="form-control"
											id="shopId" required="required" />
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="sel1">Bill Amount</label>
										<form:input type="number" path="billAmount"
											class="form-control" id="billAmount" required="required" />
									</div>

									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Bank Name</label> <input
											type="text" name="bankName" class="form-control"
											id="bankName" placeholder="Bank Name" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Bank Account No</label> <input
											type="text" name="bankAccount" class="form-control"
											id=bankAccount placeholder="Bank Account No" required>
									</div>


								</div>
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Cheque No</label> <input
											type="number" name="chequeNo" class="form-control"
											id="chequeNo" placeholder="Cheque No" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Cheque Date</label> <input
											type="Date" name="chequeDate" class="form-control"
											id="chequeDate" placeholder="Cheque Date" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Payment Date</label> <input
											type="Date" name="paymentDate" class="form-control"
											id="paymentDate" placeholder="Payment Date" required>
									</div>
								</div>
								<br>
								<div class="offset-md-5">
									<button type="submit" class="btn btn-primary col-md-2">Pay</button>
								</div>

							</form:form>

						</div>
					</div>
					<!-- end card-->
				</div>
			</div>
		</div>
		<!-- END content -->

	</div>
</div>
<%@ include file="../includes/footer.jsp"%>