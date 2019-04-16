
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
						<h1 class="main-title float-left">Add Cash Payments</h1>
						<ol class="breadcrumb float-right">
							<li class="breadcrumb-item">Home</li>
							<li class="breadcrumb-item active">CashPayments</li>
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

							<form:form method="POST" action="addcashPayments"
								modelAttribute="cashPayment">
								<div class="form-row">
									<div class="form-group col-md-5 offset-md-1">
										<label>Bill No</label>

										<form:input type="text" path="billNo" class="form-control"
											id="billNo" required="required" />
									</div>

									<div class="form-group col-md-5">
										<label for="exampleInputEmail1">Bill Date</label>
										<form:input type="Date" path="billDate" class="form-control"
											id="billDate" aria-describedby="numberlHelp"
											placeholder="Bill Date" required="required" />

									</div>

								</div>

								<div class="form-row">
									<div class="form-group col-md-5 offset-md-1">
										<label for="sel1">Shop Name</label>
										<form:select type="text " path="shopName" class="form-control"
											id="shopName" required="required">
											<c:forEach var="result" items="${shopList}">

												<option>${result.shopName}</option>

											</c:forEach>
										</form:select>
									</div>
									<div class="form-group col-md-5">
										<label for="exampleInputEmail1">Bill Amount</label>
										<form:input type="number" path="billAmount"
											class="form-control" id="billAmount"
											aria-describedby="emailHelp" placeholder="Bill Amount"
											required="required" />
									</div>


									<form:input type="hidden" path="id" />

								</div>
								<div class="form-group col-md-5 offset-md-1">
									<label for="exampleInputEmail1">Payment Date</label> <input
										type="Date" name="paymentDate" class="form-control"
										id="paymentDate" aria-describedby="emailHelp"
										placeholder="Payed Date" required>
								</div>
								<br />
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