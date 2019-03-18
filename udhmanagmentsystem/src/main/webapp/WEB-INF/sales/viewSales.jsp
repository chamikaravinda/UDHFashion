
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
		swal("Personal Expenditures Added Succesfully");
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
		swal("Personal Expenditures updated Succesfully");
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
		swal("Personal Expenditures Deleted Succesfully");
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
		swal("Personal Expenditures Delete Unsuccesfull");
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

							<div class="form-group col-md-4">
								<label for="exampleInputEmail1">Item No</label> <input
									type="number" name="itemNo" class="form-control" id="itemNo"
									aria-describedby="numberlHelp" placeholder="" required>

							</div>
							<a href="#" class="btn btn-primary" style="margin: 10px"
								role="button" aria-pressed="true">Submit</a>

						</div>

						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-responsive-xl table-bordered">
									<thead>
										<tr>
									<thead>
										<th>Item No</th>
										<th>Price</th>
										<th>Qty</th>
										<th>Reduce Discount</th>
										<th>Amount</th>
									</thead>
									<tbody>
										<tr>

											<td>11001</td>
											<td>850</td>
											<td>10</td>
											<td>50</td>
											<td>8000</td>
										</tr>
										<tr>

											<td>11002</td>
											<td>650</td>
											<td>5</td>
											<td>50</td>
											<td>3000</td>
										</tr>


									</tbody>
								</table>


								</tr>
								</thead>
								<tbody>

									<c:forEach var="result" items="${pExpendituresList}">
										<tr>
											<td>${result.id}</td>
											<td>${result.date}</td>
											<td>${result.reason}</td>
											<td>${result.amount}</td>



										</tr>
									</c:forEach>

								</tbody>




								</table>



								<div class="form-row">


									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Gross Amount</label> <input
											type="text" name="grossAmount" class="form-control"
											id="grossAmount" aria-describedby="numberlHelp"
											placeholder="11750" required>

									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputPassword1">Total Discount</label> <input
											type="text" name="totalDiscount" class="form-control"
											id="totalDiscount" placeholder="750" required>
									</div>


								</div>

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Net Amount</label> <input
											type="number" name="netAmount" class="form-control"
											id="netAmount" aria-describedby="numberlHelp"
											placeholder="11000" required>

									</div>
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Cash</label> <input
											type="number" name="cash" class="form-control" id="cash"
											aria-describedby="numberlHelp" placeholder="15000" required>

									</div>


								</div>


								<div>


									<div class="form-row">

										<div class="form-group col-md-4">
											<label for="exampleInputEmail1">No of Items</label> <input
												type="number" name="noOfItem" class="form-control"
												id="noOfItem" aria-describedby="numberlHelp" placeholder="2"
												required>

										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputEmail1">Balance</label> <input
												type="number" name="balance" class="form-control"
												id="balance" aria-describedby="numberlHelp"
												placeholder="4000" required>

										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- end card-->

						<div class="col-md-12a">
							<a href="#" class="btn btn-primary" style="margin: 10px;align-items: flex-end;"
								role="button" aria-pressed="true">Finalize</a>



						</div>
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
