
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StockView</title>
<style>
.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
	background-color: #3e8e41;
}

#myInput {
	border-box: box-sizing;
	background-image: url('searchicon.png');
	background-position: 14px 12px;
	background-repeat: no-repeat;
	font-size: 16px;
	padding: 14px 20px 12px 45px;
	border: none;
	border-bottom: 1px solid #ddd;
}

#myInput:focus {
	outline: 3px solid #ddd;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f6f6f6;
	min-width: 230px;
	overflow: auto;
	border: 1px solid #ddd;
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown a:hover {
	background-color: #ddd;
}

.show {
	display: block;
}
</style>
<script>
	/* When the user clicks on the button,
	 toggle between hiding and showing the dropdown content */
	function myFunction() {
		document.getElementById("myDropdown").classList.toggle("show");
	}

	function filterFunction() {
		var input, filter, ul, li, a, i;
		input = document.getElementById("myInput");
		filter = input.value.toUpperCase();
		div = document.getElementById("myDropdown");
		a = div.getElementsByTagName("a");
		for (i = 0; i < a.length; i++) {
			txtValue = a[i].textContent || a[i].innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				a[i].style.display = "";
			} else {
				a[i].style.display = "none";
			}
		}
	}
</script>

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


								<h3 style = "color : red" > ${errorMessage} </h3>
								<h4 style = "" > Barcode Amount : ${count}</h4>
								<form method="POST" action="generateBarcode"
									modelAttribute="barcode">
									<div class="form-group">

										<label for="sel1">Item Code</label> </br>
										
										<input list="hosting-plan"
											type="text" name="itemCode" required>

										<datalist id="hosting-plan">
											<c:forEach var="result" items="${itemList}">

												<option value="${result.itemCode}" />
											</c:forEach>
										</datalist>


									</div>

									<label for="inputEmail4">Barcode Amount</label> <input
										name="quantity" type="number" class="form-control"
										id="inputEmail4" placeholder="Barcode Quantity"
										autocomplete="off" required>

									<button type="submit" class="btn btn-primary">Add Data</button>
								</form>
							</div>

							<a href="viewBarcodeList" class="btn btn-primary btn-lg active"
								role="button" aria-pressed="true" onclick="test()">Print
								Barcode Sheet </a>
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
</body>


</html>
<%@ include file="../includes/footer.jsp"%>