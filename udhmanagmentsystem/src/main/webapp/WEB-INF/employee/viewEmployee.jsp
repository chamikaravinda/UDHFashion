
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




<!-- added success message -->
	<script type="text/javascript">
		function addedsuccesfully() {	
			swal("Employee Added Succesfully");	
		}
	</script>

	<c:if test="${success == 1}">
		<script type="text/javascript">
			window.onload = addedsuccesfully;
		</script>
	</c:if>
	
<!-- update success message -->
	<script type="text/javascript">
		function updatesuccesfully() {	
			swal("Employee updated Succesfully");	
		}
	</script>

	<c:if test="${success == 2}">
		<script type="text/javascript">
			window.onload = updatesuccesfully;
		</script>
	</c:if>
<!-- delete success message -->
	<script type="text/javascript">
		function deletesuccesfully() {	
			swal("Employee Deleted Succesfully");	
		}
	</script>

	<c:if test="${success == 3}">
		<script type="text/javascript">
			window.onload = deletesuccesfully;
		</script>
	</c:if>

<!-- delete unsuccess message -->
	<script type="text/javascript">
		function deleteunsuccesfull() {	
			swal("Employee Delete Unsuccesfull");	
		}
	</script>

	<c:if test="${success == 4}">
		<script type="text/javascript">
			window.onload = deleteunsuccesfull;
		</script>
	</c:if>

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
												<th>BasicSalary</th>
												<th>Telephone</th>
												<th>job Date</th>
												<th>Guardian Telephone</th>

												<td><span><i class="fa fa-pencil-square"
														aria-hidden="true"></i></span></td>
												<td><span><i class="fa fa-trash"
														aria-hidden="true"></i></span></td>
											</tr>
										</thead>
										<tbody>
			
											<c:forEach var="result" items = "${employeeList}">
												<tr>
         											<td>${result.empNo}</td>	
         											<td>${result.empName}  </td>	
         											<td>${result.empAddress} </td>	
         											<td>${result.basicSalary} </td>
         											<td>${result.jobDate}  </td>
         											<td>${result.contactNum} </td>
         											<td>${result.gContactNum} </td>
         											
         											<td><a href="<c:url value='/editEmployee?empNo=${result.empNo}' />">Edit</a></td>
         											
         										
         											<td> 
         												<form method = "POST" action = "deleteEmployee" modelAttribute="employee">
         													<input name = "empNo" type = "hidden" value = "${result.empNo}" >
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
		</div>

<%@ include file="../includes/footer.jsp"%>
