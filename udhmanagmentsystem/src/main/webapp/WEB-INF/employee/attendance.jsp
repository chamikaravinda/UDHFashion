
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
						<div class="col-md-12a"></div>

						<div class="card-body">
							<div class="table-responsive">
								<form>
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

											<c:forEach var="result" items="${employeeList}">
												<tr>
													<td>${result.empNo}</td>
													<td>${result.empName}</td>
													<td><select name="attendance" id="attendance"
														onchange="showfield(this.options[this.selectedIndex].value)">
															<option value="1" selected="selected">Present</option>
															<option value="2">Absant</option>

													</select>
														<div id="div1"></div></td>

													<td><input type="text" name="reason"
														class="form-control" id="reason"
														placeholder="Reason for absant" required></td>



												</tr>
											</c:forEach>

										</tbody>



									</table>

									<div>

										<button class="btn btn-primary" style="margin-left:700px">
											<span class="spinner-border spinner-border-sm"></span>
											Submit
										</button>
									</div>


								</form>

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
