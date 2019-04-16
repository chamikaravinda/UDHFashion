
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

							<form:form method="POST" action="updateCreditBill"
								modelAttribute="creditBill">

								<div class="row">
									<div class="form-row col-md-5 ">
										<label for="exampleInputEmail1">Bill No</label>
										<form:input type="text" class="form-control" path="billNo"
											aria-describedby="emailHelp" placeholder=""
											required="required" />
									</div>
									<div class="form-row offset-md-1 col-md-5 ">
										<label for="exampleInputEmail1">Bill Date</label>
										<form:input type="Date" path="billDate" class="form-control"
											aria-describedby="numberlHelp" placeholder=""
											required="required" />

									</div>

									<div class="form-group col-md-5">
										<br> <label for="sel1">Shop Name</label>
										<form:select path="shopName" class="form-control" id="shopId"
											required="required">

											<c:forEach var="result" items="${shopList}">

												<form:option value="${result.shopName}"> ${result.shopName} </form:option>

											</c:forEach>

										</form:select>
									</div>

									<div class="form-row offset-md-1 col-md-5 ">
										<br> <label for="exampleInputEmail1">Amount</label>
										<form:input type="text" path="billAmount" class="form-control"
											aria-describedby="numberlHelp" placeholder=""
											required="required" />

									</div>

									<form:input type="hidden" path="id" />

									<br />
									<br />

									<div class="offset-md-5">
										<button type="submit" class="btn btn-primary">Update
											Bill</button>
									</div>
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