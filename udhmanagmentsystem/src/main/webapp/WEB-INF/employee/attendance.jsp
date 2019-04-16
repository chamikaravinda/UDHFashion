
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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



<!-- added success message -->
<script type="text/javascript">
	function addedsuccesfully() {
		swal("S	uccessful", "Attendence Added Succesfully", "success");

	}
</script>

<c:if test="${success == 1}">
	<script type="text/javascript">
		window.onload = addedsuccesfully;
	</script>
</c:if>

<!-- added unsuccess message -->
<script type="text/javascript">
	function addedunsuccesfull() {
		swal("Unsuccessful", "Attendence Adding Unsuccesful", "error");

	}
</script>

<c:if test="${unsuccess == 1}">
	<script type="text/javascript">
		window.onload = addedunsuccesfull;
	</script>
</c:if>


<!-- update success message -->
<script type="text/javascript">
	function updatesuccesfully() {
		swal("Unsuccessful", "Attendence updated Succesfully", "success");

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
			<div class="breadcrumb-holder">
				<h1 class="main-title float-left">Today's Attendance</h1>
				<ol class="breadcrumb float-right">
					<li class="breadcrumb-item">Home</li>
					<li class="breadcrumb-item active">Attendance</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<div class="row">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="col-md-12a"></div>

						<div class="card-body">
							<div class="table-responsive">
								<form:form method="post" action="saveattendance" modelAttribute="attendenceForm" >
									<table id="example1"
										class="table table-bordered table-hover display">
										<thead>
											<tr>
												<th>Employee No</th>
												<th>Employee Name</th>
												<th>Status</th>
												<th>Reason</th>



											</tr>
										</thead>
										<tbody>

											<c:forEach items="${attendenceForm.attendence}" var="attend" varStatus="status">
												<tr>
													<td>${attend.empNo}</td>
													<td>${attend.empName}</td>
													<td><select name="attendence[${status.index}].status" id="attendance" class="form-control">
															<option value="PRESENT" <c:if test="${attend.status == 'PRESENT' }"> selected="selected" </c:if>> Present</option>
															<option value="ABSENT"  <c:if test="${attend.status== 'ABSENT' }"> selected="selected" </c:if>> Absent</option>

													</select>
														<div id="div1"></div></td>

													<td><input type="text" name="attendence[${status.index}].Reason"
														class="form-control" id="reason"
														placeholder="Reason for absent" value ="${attend.reason}"></td>
														
														<input type="hidden" name="attendence[${status.index}].id" value="${attend.id}">
														<input type="hidden" name="attendence[${status.index}].empNo" value="${attend.empNo}">
														<input type="hidden" name="attendence[${status.index}].empName" value="${attend.empName}">
														<input type="hidden" name="attendence[${status.index}].attendence_ID" value="${attend.attendence_ID}">
														<input type="hidden" name="attendence[${status.index}].date" value="${attend.date}">
														
												</tr>
											</c:forEach>

										</tbody>



									</table>

									<div>

										<button class="btn btn-primary" style="margin-left: 700px">
											<span class="spinner-border spinner-border-sm"></span> Submit
										</button>
									</div>


								</form:form>

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

<script type="text/javascript">
	function showfield(name) {
		if (name == 'Other')
			document.getElementById('div1').innerHTML = 'Other: <input type="text" name="other" />';
		else
			document.getElementById('div1').innerHTML = '';
	}
</script>

<%@ include file="../includes/footer.jsp"%>
