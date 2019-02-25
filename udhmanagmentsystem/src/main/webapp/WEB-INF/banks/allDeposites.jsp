
<%@ include file="../includes/menuAndSideBar.jsp"%>
	<br><br>
	<!-- added success message -->
	<script type="text/javascript">
		function addedsuccesfully() {	
			swal("Deposite Added Succesfully");	
		}
	</script>

	<c:if test="${success == 1}">
		<script type="text/javascript">
			window.onload = addedsuccesfully;
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
								<a href="addDeposites" class="btn btn-primary"
									style="margin: 10px" role="button" aria-pressed="true">Add</a>

							</div>

							<div class="card-body">
								<div class="table-responsive">
									<table id="example1" class="table table-bordered table-hover display">
										<thead>
											<tr>
												<th>Date</th>
												<th>Bank Name</th>
												<th>Account Number</th>
												<th>Deposited Amount</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="result" items="${deposites}">
												<tr>
													<td>${result.date}</td>
													<td>${result.bank}</td>
													<td>${result.accountNumber}</td>
													<td>Rs.<fmt:formatNumber type="number" pattern="###.##" value="${result.amount}" /></p></td>
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
