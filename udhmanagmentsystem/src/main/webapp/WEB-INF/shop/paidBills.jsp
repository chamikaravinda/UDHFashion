a
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
			swal("Credit Bill Added Succesfully");	
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
			swal("Credit Bill updated Succesfully");	
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
			swal("Credit Bill Deleted Succesfully");	
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
			swal("Credit Bill Delete Unsuccesfull");	
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
												<th>ID</th>
												<th>Bill No</th>
												<th>Bill Date</th>
												<th>Shop Name</th>
												<th>Bill Amount</th>
												<th>Payed Date</th>
												<th>Payment Method</th>

												<td><span><i class="fa fa-trash"
														aria-hidden="true"></i></span></td>
											</tr>
									 </thead>
										<tbody>
			
											<c:forEach var="result" items = "${paidbills}">
												<tr>
         											<td> ${result.id} </td>	
         											<td> ${result.billNo} </td>	
         											<td> ${result.billDate} </td>	
         											<td> ${result.shopName } </td>
         											<td> ${result.billAmount } </td>
         											<td> ${result.paymentDate } </td>
         											<td> ${result.paymentMethod } </td>
         											
         											<td> 	
         												<form method = "POST" action = "deleteCashPayments" modelAttribute="creditBill">
         													<input name = "id" type = "hidden" value = "${result.id}" >
         													<button type="submit"  class="btn btn-primary">Delete</button>
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
