
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

								<form method="POST" action="submitChequePayment"
									modelAttribute="chequePayment" >

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Bill No</label> <input
											type="text" name="billNo" class="form-control"
											id="billNo" aria-describedby="emailHelp"
											placeholder="Bill No" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Billing Date</label> <input
											type="Date" name="billDate" class="form-control"
											id="billDate" aria-describedby="numberlHelp"
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
											<label for="sel1">Shop Name</label> <select name="shopName"
												class="form-control" id="shopId" required>

												<c:forEach var="result" items="${shopList}">

													<option>${result.shopName}</option>

												</c:forEach>

											</select>
										</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Bank Name</label> <input
											type="text" name="bankName" class="form-control"
											id="bankName" placeholder="Bank Name" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Bank Account No</label> <input
											type="number" name="bankAccount" class="form-control"
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
										<label for="exampleInputPassword1">Cheque Amount</label> <input
											type="number" name="chequeAmount" class="form-control"
											id="chequeAmount" placeholder="Cheque Amount" required>
									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Cheque Date</label> <input
											type="Date" name="chequeDate" class="form-control"
											id="chequeDate" placeholder="Cheque Date" required>
									</div>
									
									</div>
									<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Payment Date</label> <input
											type="Date" name="paymentDate" class="form-control"
											id="paymentDate" placeholder="Payment Date" required>
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
</div>
<%@ include file="../includes/footer.jsp"%>