
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StockView</title>
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
							<div class="card-body">
								<table id="example1"
									class="table table-bordered table-hover display">
									<thead>
										<tr>
											<th>Item Code</th>
											<th>Price</th>
											<th>Quantity</th>


											<td><span><i class="fa fa-trash"
													aria-hidden="true"></i></span></td>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="result" items="${barcodeList}">
											<tr>
												<td>${result.itemCode}</td>
												<td>${result.price}</td>
												<td>${result.quantity}</td>

												<td>
													<form method="POST" action="deleteBarcodeItem"
														modelAttribute="barcode">
														<input name="itemCode" type="hidden"
															value="${result.itemCode}">
														<button type="submit" al class="btn btn-primary">Delete</button>
													</form>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<a href="generateBarcodePdf"
								class="btn btn-primary btn-lg active" role="button"
								aria-pressed="true">Generate Pdf </a>
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
<%@ include file="../includes/footer.jsp"%>