
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


	</br>
	</br>
	</br>
	</br>
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

								<form method="POST" action="creditBills"
									modelAttribute="creditBills" onsubmit="return validator()">

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Bill No</label> <input
											type="text" name="shopName" class="form-control"
											id="shopName" aria-describedby="emailHelp"
											placeholder="Bill No" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Bill Date</label> <input
											type="text" name="shopAddress" class="form-control"
											id="shopAddress" aria-describedby="numberlHelp"
											placeholder="Bill Date" required>

									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Shop No</label> <input
											type="number" name="shopTelephone" class="form-control"
											id="shopNo" placeholder="Shop Name" required>
									</div>
								</div>
								
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Shop Name</label> <input
											type="number" name="shopTelephone" class="form-control"
											id="shopName" placeholder="Shop Name" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Bill Amount</label> <input
											type="number" name="shopName" class="form-control"
											id="billAmount" aria-describedby="emailHelp"
											placeholder="Bill Amount" required>
									</div>
									
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Payed Date</label> <input
											type="number" name="PayedDate" class="form-control"
											id="payDate" aria-describedby="emailHelp"
											placeholder="Payed Date" required>
									</div>
									
									
									</div>

									<div style="margin-left: 500px">
										<button type="submit" class="btn btn-primary">Add</button>
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
