<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<div class="content-page">

		<!-- Start content -->
		<div class="content">

			<div class="container-fluid">


				<div class="row">
					<div class="col-xl-12">
						<div class="breadcrumb-holder">
							<h1 class="main-title float-left">Edit Item</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Home</li>
								<li class="breadcrumb-item active">Forms</li>
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

								<form:form method="POST" action="updateStock"
									modelAttribute="item">
									<div class="form-row">
										<div class="form-group col-md-4">
											<label for="sel1">Item Code</label>
											<form:input type="text" class="form-control" path="itemCode"
												aria-describedby="emailHelp" placeholder="" readonly="true" />
										</div>
										<div class="form-group col-md-4">
											<label for="inputPassword4">Item Quantity</label>
											<form:input type="number" path="itemQuantity"
												class="form-control" id="quantity" placeholder="Quantity"
												required="required" />
										</div>
										<div class="form-group col-md-4">
											<label for="sel1">Shop</label>
											<form:select path="shopId" class="form-control" id="shopId"
												required="required">

												<c:forEach var="result" items="${shopList}">

													<form:option value="${result.shopId}">${result.shopName}</form:option>

												</c:forEach>

											</form:select>
										</div>
									</div>

									<div class="form-row">
										<div class="form-group col-md-4">
											<label for="inputEmail4">Item Description</label>
											<form:input type="text" path="itemDescription"
												class="form-control" id="itemDescription"
												placeholder="Item Description" required="required" />
										</div>

										<div class="form-group col-md-4">
											<label for="inputEmail4">Gross Price</label>
											<form:input path="grossPrice" type="number"
												class="form-control" id="grossPrice"
												placeholder="Gross Price" required="required" />
										</div>

										<div class="form-group col-md-4">
											<label for="inputPassword4">Price Tag Amount</label>
											<form:input path="price" type="number" class="form-control"
												id="tagAmount" placeholder="Price Tag Amount"
												required="required" />
										</div>
									</div>


									<div class="form-row">
										<div class="form-group col-md-4">
											<label for="inputPassword4">Discount</label>
											<form:input path="discount" type="number"
												class="form-control" id="discount" placeholder="Discount"
												required="required" />
										</div>
										<div class="form-group col-md-4">
											<label for="inputEmail4">Net Price</label>
											<form:input path="netPrice" type="number"
												class="form-control" id="grossPrice" placeholder="Net Price"
												required="required" />
										</div>

									</div>
									<div class="form-row"></div>

									<button type="submit" class="btn btn-primary">Update
										Stock</button>
								</form:form>

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

</body>
</html>
<%@ include file="../includes/footer.jsp"%>