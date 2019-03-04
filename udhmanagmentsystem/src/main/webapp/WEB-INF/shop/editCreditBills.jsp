
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
						<h1 class="main-title float-left">Edit Credit Bills</h1>
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

							<form:form method="POST" action="submitCreditBill"
								modelAttribute="creditBills" >


								<div class="form-row">
									<label for="exampleInputEmail1">Bill No</label> <form:input
										type="text" name="billNo" class="form-control" path="billNo"
										aria-describedby="emailHelp" placeholder="" required="required"/>
								</div>
								<div class="form-row">
									<label for="exampleInputEmail1">Bill Date</label> <form:input
										type="Date" path="billDate" class="form-control" 
										aria-describedby="numberlHelp" placeholder=""
										required="required"/>

								</div>
								<div class="form-row">
									<label for="exampleInputEmail1">Shop Name</label> <form:input
										type="text" path="shopName" class="form-control" 
										aria-describedby="numberlHelp" placeholder=""
										required="required"/>

								</div>

								<div style="margin-left: 500px">
									<button type="submit" class="btn btn-primary">Update Bill</button>
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