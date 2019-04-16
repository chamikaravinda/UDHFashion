
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
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salary Sheet</title>
</head>
<body>
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
	<!-- Salary payment succesfull message -->
	<script type="text/javascript">
		function salarySuccesfull() {
			swal("Successful", "Advance Paied Succesfuly", "success");
		}
	</script>

	<c:if test="${success== 1}">
		<script type="text/javascript">
			window.onload = salarySuccesfull;
		</script>
	</c:if>

	<!-- Update salarySheet successfull message -->
	<script type="text/javascript">
		function succesfull() {
			swal("Successful", "Salary Update Succesfull", "success");

		}
	</script>

	<c:if test="${success == 1}">
		<script type="text/javascript">
			window.onload = succesfull;
		</script>
	</c:if>

	<div class="content-page">

		<!-- Start content -->
		<div class="content">

			<div class="container-fluid">

				<div class="row">
					<div class="col-xl-12">
						<div class="breadcrumb-holder">
							<h1 class="main-title float-left">Paid Salaries</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Home</li>
								<li class="breadcrumb-item active">Salary Sheets</li>
							</ol>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>

				<div class="row">

					<div class="col-md-12">
						<div class="card mb-3">
							<div class="col-md-12a"></div>

							<div class="card-body">
								<div class="table-responsive">
									<table id="example1"
										class="table table-bordered table-hover display">
										<thead>
											<tr>
												<th>Paid Date</th>
												<th>Worker No</th>
												<th>Worker Name</th>
												<th>Absent Days</th>
												<th>Total Business</th>
												<th>Bonus</th>
												<th>Monthly Basic</th>
												<th>Basic Salary</th>
												<th>Advance Payments</th>
												<th>Total Salary</th>

											</tr>
										</thead>
										<tbody>

											<c:forEach var="salary" items="${salaryList}">
												<tr>
													<td>${salary.date}</td>
													<td>${salary.empNo}</td>
													<td>${salary.empName}</td>
													<td>${salary.absent}</td>
													<td>Rs.<fmt:formatNumber type="number"
															pattern="###.##" value="${salary.totalBussines}" /></td>
													<td>Rs.<fmt:formatNumber type="number"
															pattern="###.##" value="${salary.totalBussines}" /></td>
													<td>Rs.<fmt:formatNumber type="number"
															pattern="###.##" value="${salary.monthlyBasic}" /></td>
													<td>Rs.<fmt:formatNumber type="number"
															pattern="###.##" value="${salary.basicSalary}" /></td>
													<td>Rs.<fmt:formatNumber type="number"
															pattern="###.##" value="${salary.advancePayment}" /></td>
													<td>Rs.<fmt:formatNumber type="number"
															pattern="###.##" value="${salary.totalSalray}" /></td>
													<!-- <td>
														<form method="POST" action="viewSalarySheet"
															modelAttribute="Salary">
															<input name="id" type="hidden" value="${salary.id}">
															<button type="submit" al class="btn btn-link">
																<span class="fa fa-share-square-o" aria-hidden="true"></span>
															</button>
														</form>
													</td> -->
												</tr>
											</c:forEach>

										</tbody>
									</table>

								</div>
							</div>
							<!-- end card-->
						</div>

						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">

						</div>

					</div>
				</div>
				<!-- END container-fluid -->

			</div>
			<!-- END content -->

		</div>
</body>
</html>
<%@ include file="../includes/footer.jsp"%>
