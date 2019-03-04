
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

							<form method="POST" action="submitCreditBills"
								modelAttribute="creditBills" onsubmit="return validator()">


								<div class="form-row">
									<label for="exampleInputEmail1">Bill No</label> <input
										type="text" name="billNo" class="form-control" id="billNo"
										aria-describedby="emailHelp" placeholder="Bill No" required>
								</div>
								<div class="form-row">
									<label for="exampleInputEmail1">Bill Date</label> <input
										type="Date" name="billDate" class="form-control" id="billDate"
										aria-describedby="numberlHelp" placeholder="Bill Date"
										required>

								</div>
								<div class="form-row">
									<label for="sel1">Shop Name</label> <select name="shopName"
										class="form-control" id="shopId" required>

										<c:forEach var="result" items="${shopList}">

											<option>${result.shopName}</option>

										</c:forEach>

									</select>
								</div>
								
								<div class="form-row">
									<label for="exampleInputEmail1">Bill Amount</label> <input
										type="number" name="billAmount" class="form-control" id="billAmount"
										aria-describedby="numberlHelp" placeholder="Bill Amount"
										required>

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
</div>

<%@ include file="../includes/footer.jsp"%>