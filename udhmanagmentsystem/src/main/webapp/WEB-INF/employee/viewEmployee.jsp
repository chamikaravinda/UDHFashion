
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
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View WholeSale Shop</title>
</head>
<body>


	</br>
	</br>
	</br>
	</br>
	<div class="content-page">

		<!-- Start content -->
		<div class="content">

			<div class="container-fluid">

				<div class="row">

					<div class="col-md-12">
						<div class="card mb-3">
							<div class="col-md-12a">
								<a href="addEmployee" class="btn btn-primary" style="margin:10px"
									role="button" aria-pressed="true">Add</a>

							</div>

							<div class="card-body">
								<div class="table-responsive">
									<table id="example1"
										class="table table-bordered table-hover display">
										<thead>
											<tr>
												<th>Employee No</th>
												<th>Employee Name</th>
												<th>Address</th>
												<th>Telephone</th>
												<th>Guardian Telephone</th>

												<td><span><i class="fa fa-pencil-square"
														aria-hidden="true"></i></span></td>
												<td><span><i class="fa fa-trash"
														aria-hidden="true"></i></span></td>
											</tr>
										</thead>
										<tbody>
			
											<c:forEach var="result" items = "">
												<tr>
         											<td>  </td>	
         											<td>  </td>	
         											<td> </td>	
         											<td>  </td>
         											<td> </td>
         											<td> </td>
         											<td> 	
         												<form method = "POST" action = "deleteShop" modelAttribute="shop">
         													<input name = "shopId" type = "hidden" value = "" >
         													<button type="submit" al class="btn btn-primary">Delete</button>
         												</form>
         											</td>	
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
<%@ include file="../includes/footer.jsp"%>le="../includes/footer.jsp"
%>
