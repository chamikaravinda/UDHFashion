aa
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
						<h1 class="main-title float-left">Credit Bill pay by Cash</h1>
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

							<form method="POST" action="submitCashPayment"
								modelAttribute="creditBills" >

								<div class="form-row">
								<div class="form-group col-md-4">
										<label for="sel1">Bill No</label> <select name="billNo"
											class="form-control" id="billNo" required>

											<c:forEach var="result" items="${creditBillList}">

												<option>${result.billNo}</option>

											</c:forEach>

										</select>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Bill Date</label> <input
											type="Date" name="billDate" class="form-control"
											id="billDate" aria-describedby="numberlHelp"
											placeholder="Bill Date" required>

									</div>
									
								</div>

							<div class="form-row">
									<div class="form-group col-md-4">
										<label for="sel1">Shop Name</label> <select name="shopName"
											class="form-control" id="shopName" required>

											<c:forEach var="result" items="${shopList}">

												<option>${result.shopName}</option>

											</c:forEach>

										</select>
									</div>
									
									
									
									
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Bill Amount</label> <input
											type="number" name="billAmount" class="form-control"
											id="billAmount" aria-describedby="emailHelp"
											placeholder="Bill Amount" required>
									</div>




								</div>
								<div class="form-group col-md-8.5">
									<label for="exampleInputEmail1">Payment Date</label> <input
										type="Date" name="paymentDate" class="form-control" id="paymentDate"
										aria-describedby="emailHelp" placeholder="Payed Date" required>
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
</div>
<%@ include file="../includes/footer.jsp"%>