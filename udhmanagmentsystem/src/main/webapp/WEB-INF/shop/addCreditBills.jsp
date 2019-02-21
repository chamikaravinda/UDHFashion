
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
							<h1 class="main-title float-left">Add Credit Bills</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Home</li>
								<li class="breadcrumb-item active">CreditBills</li>
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


									<div class="form-group">
										<label for="exampleInputEmail1">Bill No</label> <input
											type="text" name="shopName" class="form-control"
											id="shopName" aria-describedby="emailHelp"
											placeholder="Bill No" required>
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Bill Date</label> <input
											type="text" name="shopAddress" class="form-control"
											id="shopAddress" aria-describedby="numberlHelp"
											placeholder="Bill Date" required>

									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Shop Name</label> <input
											type="number" name="shopTelephone" class="form-control"
											id="shopName" placeholder="Shop Name" required>
									</div>
									
									
									
									<div class="form-group">
									  <label for="sel1">Payment Method</label>
									  <select class="form-control" id="sel1">
									    <option>1</option>
									    <option>2</option>
									    <option>3</option>
									    <option>4</option>
									  </select>
									</div>
									
									

									<div style="margin-left: 500px">
										<button type="submit" class="btn btn-primary">Add Bill</button>
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