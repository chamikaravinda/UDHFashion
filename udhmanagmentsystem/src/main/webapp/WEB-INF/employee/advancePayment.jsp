
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<!-- advance payment Unsuccesfull message -->
<script type="text/javascript">
	function Unsuccesful() {
		swal("Advance Payment Unsuccesfull");
	}
</script>

<c:if test="${error== 1}">
	<script type="text/javascript">
		window.onload = Unsuccesful;
	</script>
</c:if>

<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">


			<div class="row">
				<div class="col-xl-12">
					<div class="breadcrumb-holder">
						<h1 class="main-title float-left">Advance Payment</h1>
						<ol class="breadcrumb float-right">
							<li class="breadcrumb-item">Home</li>
							<li class="breadcrumb-item active">Payments</li>
						</ol>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->
			<br> <br> <br>

			<div class="row">

				<div class=" col-md-8 offset-md-2">
					<div class="card mb-3">

						<div class="card-body">

							<br>
							<br>
							<form method="POST" action="advancePay"
								modelAttribute="advancePayment">



								<div class="form-row">
									<div class="form-group col-md-4 offset-md-4">
										<label for="exampleInputPassword1">Employee Number</label> <input
											list="hosting-plan" type="text" name="empNo"
											class="form-control" id="empNo"
											aria-describedby="numberlHelp" placeholder="" required>


										<datalist id="hosting-plan">
											<c:forEach var="emp" items="${employees}">

												<option value="${emp.empNo}" />
											</c:forEach>
										</datalist>
									</div>




								</div>
								<div class="form-row">

									<div class="form-group col-md-4 offset-md-4">
										<label for="exampleInputPassword1">Amount</label> <input
											type="number" name="amount" class="form-control" id="amount"
											placeholder="Advance Payment" required>
									</div>


								</div>
								<br>
								<div style="margin-left: 490px">
									<button type="submit" class="btn btn-primary">Pay</button>
								</div>

							</form>
							<br>
							<br>
						</div>
					</div>
					<!-- end card-->
				</div>
			</div>
		</div>
		<!-- END container-fluid -->
	</div>
	<!-- END content -->
</div>
<%@ include file="../includes/footer.jsp"%>