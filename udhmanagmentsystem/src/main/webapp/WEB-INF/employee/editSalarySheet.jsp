
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.UDHFashion.udhmanagmentsystem.service.IShopDAO"%>
<%@page import="com.UDHFashion.udhmanagmentsystem.service.ShopDAOImpl"%>
<%@page import="com.UDHFashion.udhmanagmentsystem.model.Shop"%>
<%@page import="com.UDHFashion.udhmanagmentsystem.model.User"%>
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


<!-- added unsuccesfull message -->
<script type="text/javascript">
	function unsuccesfull() {
		swal("Sale is Unsuccesfull");
	}
</script>

<c:if test="${error == 1}">
	<script type="text/javascript">
		window.onload = unsuccesfull;
	</script>
</c:if>

<!-- edit unsuccesfull message -->
<script type="text/javascript">
	function editUnsuccesfull() {
		swal("Update Salary Sheet failed");
	}
</script>

<c:if test="${error == 2}">
	<script type="text/javascript">
		window.onload = editUnsuccesfull;
	</script>
</c:if>

<!-- payment unsuccesfull message -->
<script type="text/javascript">
	function paymentUnsuccesfull() {
		swal("Salary Payment failed");
	}
</script>

<c:if test="${error == 3}">
	<script type="text/javascript">
		window.onload = paymentUnsuccesfull;
	</script>
</c:if>
<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">


			<div class="row">
				<div class="col-xl-12">
					<div class="breadcrumb-holder">
						<h1 class="main-title float-left">Salary Payment</h1>
						<ol class="breadcrumb float-right">
							<li class="breadcrumb-item">Home</li>
							<li href="viewAllSales" class="breadcrumb-item active">Salary
								Sheet</li>
						</ol>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>

			<div class="row ">

				<div class="col-md-12 ">
					<div class="card mb-3">
						<div class="col-md-12a ">
							<form:form method="POST" action="empSalarySheet"
								modelAttribute="salary">
								<div class="form-row">
									<div class="form-group col-md-5" style="margin: 20px">
										<label for="exampleInputEmail1">Employee No</label>
										<form:input type="text" path="empNo" class="form-control"
											aria-describedby="emailHelp" placeholder="Employee No"
											readonly="true" />
									</div>

									<div class="form-group col-md-5" style="margin: 20px">
										<label for="exampleInputEmail1">Employee Name</label>
										<form:input type="text" path="empName" class="form-control"
											aria-describedby="emailHelp" placeholder="Employee Name"
											readonly="true" />
									</div>

									<div class="form-group col-md-5" style="margin: 20px">
										<label for="exampleInputEmail1">Absent Days</label>
										<form:input type="text" path="absent" class="form-control"
											aria-describedby="emailHelp" placeholder="Absent Days"
											required="required" />
									</div>

									<div class="form-group col-md-5" style="margin: 20px">
										<label for="exampleInputEmail1">Present Days</label>
										<form:input type="text" path="present" class="form-control"
											aria-describedby="emailHelp" placeholder="Present Days"
											required="required" />
									</div>

									<div class="form-group col-md-5" style="margin: 20px">
										<label for="exampleInputEmail1">Total Business</label>
										<form:input type="text" path="totalBussines"
											class="form-control" aria-describedby="emailHelp"
											placeholder="Total Business" required="required" />
									</div>

									<div class="form-group col-md-5" style="margin: 20px">
										<label for="exampleInputEmail1">Basic Salary</label>
										<form:input type="text" path="basicSalary"
											class="form-control" aria-describedby="emailHelp"
											placeholder="Basic Salary" required="required" />
									</div>

									<div class="form-group col-md-5" style="margin: 20px">
										<label for="exampleInputEmail1">Bonus</label>
										<form:input type="text" path="bonus" class="form-control"
											aria-describedby="emailHelp" placeholder="Bonus"
											required="required" />
									</div>

									<div class="form-group col-md-5" style="margin: 20px">
										<label for="exampleInputEmail1">Advance Payments</label>
										<form:input type="text" path="advancePayment"
											class="form-control" aria-describedby="emailHelp"
											placeholder="Advance Payments" required="required" />
									</div>

									<div class="form-group col-md-5 " style="margin: 20px">
										<label for="exampleInputEmail1">Total Salary</label>
										<form:input type="text" path="totalSalray"
											class="form-control" aria-describedby="emailHelp"
											placeholder="Total Salary" required="required" />
									</div>
								</div>
								<form:hidden path="id" />

								<div>
									<br>
									<div class="row">
										<div class="col-md-1 offset-md-5">
											<button type="submit" style="width: 100px"
												class="btn btn-primary" name="SalarySheetUpdate">
												<span class="fa fa-pencil" aria-hidden="true" ></span> Update
											</button>
										</div>

										<div class="col-md-1 ">
											<button type="submit" style="width: 100px"
												class="btn btn-primary" name="SalarySheetPay">
												<span class="fa fa-print" aria-hidden="true" ></span> Pay
											</button>
										</div>
									</div>
									<div class="row">
										<div class="col-md-3 ">
											<button type="submit" style="width: 300px"
												class="btn btn-link" name="SalarySheetPrint">
												<span class="fa fa-print" aria-hidden="true"></span> Print
												Salary Sheet
											</button>
										</div>
									</div>
								</div>
								<br>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END container-fluid -->

	</div>
	<!-- END content -->

</div>
</div>


<%@ include file="../includes/footer.jsp"%>
