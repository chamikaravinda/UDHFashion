<%@ include file="../includes/menuAndSideBar.jsp"%>
<!-- added success message -->
<script type="text/javascript">
	function addedsuccesfully() {
		swal("Successful", "Account Added Succesfully", "success");

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
		swal("Successful", "Account updated Succesfully", "success");

	}
</script>

<c:if test="${success == 2}">
	<script type="text/javascript">
		window.onload = updatesuccesfully;
	</script>
</c:if>

<!-- delete success message -->
<script type="text/javascript">
	function deleteSuccesfully() {
		swal("Successful", "Account Deleted Succesfully", "success");

	}
</script>

<c:if test="${success == 3}">
	<script type="text/javascript">
		window.onload = deleteSuccesfully;
	</script>
</c:if>

<!-- delete Unsuccessfull message -->
<script type="text/javascript">
	function deleteUnSuccesful() {
		swal("Unsuccessful", "Account Deleted Succesfully", "error");

	}
</script>

<c:if test="${error == 3}">
	<script type="text/javascript">
		window.onload = deleteUnSuccesful;
	</script>
</c:if>

<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">
			<div class="row">
				<div class="col-xl-12">
					<div class="breadcrumb-holder">
						<h1 class="main-title float-left">Bank Accounts</h1>
						<ol class="breadcrumb float-right">
							<li class="breadcrumb-item">Home</li>
							<li class="breadcrumb-item active">Bank Account</li>
						</ol>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->

			<div class="row">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="col-md-12a">
							<a href="addBanks" class="btn btn-primary" style="margin: 10px"
								role="button" aria-pressed="true">Add</a>

						</div>

						<div class="card-body">
							<div class="table-responsive">
								<table id="example1"
									class="table table-bordered table-hover display">
									<thead>
										<tr>
											<th>Bank Name</th>
											<th>Account Number</th>
											<th>Account Type</th>
											<th>Current Balance</th>
											<td><span><i class="fa fa-pencil-square"
													aria-hidden="true"></i></span></td>
											<td><span><i class="fa fa-trash"
													aria-hidden="true"></i></span></td>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="result" items="${accounts}">
											<tr>
												<td>${result.bankName}</td>
												<td>${result.accountNumber}</td>
												<td>${result.accountType}</td>
												<td>Rs.<fmt:formatNumber type="number" pattern="###.##"
														value="${result.currentBalance}" /></td>
												<td><a class="btn btn-link"
													href="<c:url value='/editBanks?id=${result.id}' />">Edit</a></td>
												<td>
													<a class="btn btn-link"
													href="<c:url value='/deleteBank?id=${result.id}' />">Delete</a></td>
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
