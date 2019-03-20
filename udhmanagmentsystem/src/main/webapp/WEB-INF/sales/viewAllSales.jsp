
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



<!--  to sweet alerts-->


<!-- added success message -->
<script type="text/javascript">
	function addedsuccesfully() {
		swal("Shop Added Succesfully");
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
		swal("Shop updated Succesfully");
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
		swal("Shop Deleted Succesfully");
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
		swal("Shop Delete Unsuccesfull");
	}
</script>

<c:if test="${success == 4}">
	<script type="text/javascript">
		window.onload = deleteunsuccesfull;
	</script>
</c:if>


<!--  to sweet alerts-->



<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">

			<div class="row">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="col-md-12a">
							
						</div>

						<div class="card-body">
							<div class="table-responsive">
								<table id="example1"
									class="table table-bordered table-hover display">
									<thead>
										<tr>
											<th>Date</th>
											<th>Cashier ID</th>
											<th>Gross Amount</th>
											<th>Net Amount</th>
											<th>Total Discount</th>
											<th>Balance</th>
											<th>No of Item</th>


										</tr>
									</thead>
									<tbody>

										<c:forEach var="result" items="${getallBill}">
											<tr>
												<td>${result.date}</td>
												<td>${result.cashireId}</td>
												<td>${result.grossAmount}</td>
												<td>${result.netAmount}</td>
												<td>${result.totalDiscount}</td>
												<td>${result.balance}</td>
												<td>${result.noOfItem}</td>


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
		</div>
		<!-- END content -->

	</div>
	</body>
	</html>
	<%@ include file="../includes/footer.jsp"%>