
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Item delete success message -->
<script type="text/javascript">
	function deletesuccesfully() {
		swal("Successful","Item Deleted Succesfully","success");
	}
</script>

<c:if test="${success == 1}">
	<script type="text/javascript">
		window.onload = deletesuccesfully;
	</script>
</c:if>

<!-- Item edit success message -->
<script type="text/javascript">
	function updateSuccesfully() {
		swal("Successful","Item Updated Succesfully","success");
	}
</script>

<c:if test="${success == 2}">
	<script type="text/javascript">
		window.onload = updateSuccesfully;
	</script>
</c:if>

<!-- Returned Items added successful message -->
<script type="text/javascript">
	function returnItemsAddedSuccesfully() {
		swal("Successful","Retruned Items Added Succesfully","success");
	}
</script>

<c:if test="${success == 3}">
	<script type="text/javascript">
		window.onload = returnItemsAddedSuccesfully;
	</script>
</c:if>

<!--  Items added successful message -->
<script type="text/javascript">
	function ItemsAddedSuccesfully() {
		swal("Successful","Item Added Succesfully","success");
	}
</script>

<c:if test="${success == 4}">
	<script type="text/javascript">
		window.onload = ItemsAddedSuccesfully;
	</script>
</c:if>

<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">

			<div class="breadcrumb-holder">
				<h1 class="main-title float-left">Stocks</h1>
				<ol class="breadcrumb float-right">
					<li class="breadcrumb-item">Home</li>
					<li href="addStock" class="breadcrumb-item active">Stocks</li>
				</ol>
				<div class="clearfix"></div>
			</div>

			<div class="row">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="col-md-12a">
							<a href="addStock" class="btn btn-primary" Style="margin: 10px"
								role="button" aria-pressed="true">Add</a> <a href="return"
								class="btn btn-primary" Style="margin: 10px" role="button"
								aria-pressed="true">Add Return Item</a> <a
								href="barcodeGenerateView" class="btn btn-primary"
								Style="margin: 10px" role="button" aria-pressed="true">Generate
								Barcodes</a>
						</div>


						<div class="card-body">
							<div class="table-responsive">
								<table id="example1"
									class="table table-bordered table-hover display">
									<thead>
										<tr>
											<th>Item Code</th>
											<th>Description</th>
											<th>Gross Price</th>
											<th>Price (Tag Amount)</th>
											<th>Discount</th>
											<th>Net Price</th>
											<th>Quantity</th>
											<th>Net Profit</th>
											<th>Estimated Net Profit</th>
											<th>Shop Id</th>
											<td><span><i class="fa fa-pencil-square"
													aria-hidden="true"></i></span></td>
											<td><span><i class="fa fa-trash"
													aria-hidden="true"></i></span></td>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="result" items="${stockList}">
											<tr>
												<td>${result.itemCode}</td>
												<td>${result.itemDescription}</td>
												<td>Rs.<fmt:formatNumber type="number" pattern="###.##" value="${result.grossPrice}" /></td>
												<td>Rs.<fmt:formatNumber type="number" pattern="###.##" value="${result.price}" /></td>
												<td>Rs.<fmt:formatNumber type="number" pattern="###.##" value="${result.discount}" /></td>
												<td>Rs.<fmt:formatNumber type="number" pattern="###.##" value="${result.netPrice}" /></td>
												<td>${result.itemQuantity}</td>
												<td>Rs.<fmt:formatNumber type="number" pattern="###.##" value="${result.netProfit}" /></td>
												<td>Rs.<fmt:formatNumber type="number" pattern="###.##" value="${result.estimatedNetProfit}" /></td>
												<td>${result.shopId}</td>
												<td><form method="POST" action="editItem"
														modelAttribute="item">
														<input name="itemCode" type="hidden"
															value="${result.itemCode}">
														<button type="submit" al class="btn btn-link">Edit</button>
													</form></td>
												<td>
													<form method="POST" action="deleteItem"
														modelAttribute="item">
														<input name="itemCode" type="hidden"
															value="${result.itemCode}">
														<button type="submit" al class="btn btn-link">Delete</button>
													</form>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>

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
<%@ include file="../includes/footer.jsp"%>