
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
<script>
	function validator() {

		var shopName = document.getElementById("shopName").value;
		var shopAddress = document.getElementById("shopAddress").value;
		var shopTele = document.getElementById("shopTele").value;

		if (shopName == null || shopName == "") {
			alert("Please Enter a shop name ");
			return false;
		}

		if (shopAddress == null || shopAddress == "") {
			alert("Please Enter a shop name ");
			return false;
		}

		if (shopTele == null || shopTele == "") {
			alert("Please enter a shop telephone number ");
			return false;
		}

		if (shopTele.length != 10) {
			alert("Telephone number must contain 10 characters");
			return false;
		}
	}
</script>





<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">


			<div class="row">
				<div class="col-xl-12">
					<div class="breadcrumb-holder">
						<h1 class="main-title float-left">New Payment</h1>
						<ol class="breadcrumb float-right">
							<li class="breadcrumb-item">Home</li>
							<li class="breadcrumb-item active">payments</li>
						</ol>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->

			<div class="row">

				<div class=" col-md-6 offset-md-3">
					<br /> <br /> <br />
					<div class="card mb-3">

						<div class="card-body">

							<form method="POST" action="newPayment">
								<div class="form-row">
									<label for="sel1">Credit Bill Number</label> <select
										name="billNumber" class="form-control" id="billNumber"
										required>


										<option value="newPayment">New Payment</option>
										<c:forEach var="result" items="${creditBillList}">

											<option value="${result.billNo}">${result.billNo}</option>>

										</c:forEach>

									</select>
								</div>

								<br>
								<div class="form-row">
									<label for="sel1">Select Payment Method</label> <select
										name="method" class="form-control" id="method"
										required="required">
										<option value="cash">Cash</option>
										<option value="Cheque">Cheque</option>
									</select>
								</div>
								<br />
								<div class="offset-md-5">
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>

							</form>

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