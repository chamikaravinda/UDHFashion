<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../includes/menuAndSideBar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StockView</title>

<script>
	function validator(){
		
		var grossPrice = document.getElementById("grossPrice").value;
		var tagAmount = document.getElementById("tagAmount").value;
		var discount = document.getElementById("discount").value;
		var netPrice = document.getElementById("netPrice").value;
		var quantity = document.getElementById("quantity").value;
		
		if( grossPrice == null || grossPrice == "" ){
			alert("You cannot keep the gross price value "))
		}
		
		}		
	}
</script>
</head>
<body>
	<div class="content-page">

		<!-- Start content -->
		<div class="content">

			<div class="container-fluid">


				<div class="row">
					<div class="col-xl-12">
						<div class="breadcrumb-holder">
							<h1 class="main-title float-left">Add Stock</h1>
							<ol class="breadcrumb float-right">
								<li class="breadcrumb-item">Home</li>
								<li class="breadcrumb-item active">Forms</li>
							</ol>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<!-- end row -->

				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
					<div class="card mb-3">

						<div class="card-body">

							<form method="POST" autocomplete="off" action="submitStock"
								modelAttribute="stock"
								onsubmit="return validator()>



								<!--div class="form-row">

								</div-->
								<section>

									<div class="form-group">
										<label for="sel1">Shop Name</label> <select name="shopId"
											class="form-control" id="shopId" required>

											<c:forEach var="result" items="${shopList}">

												<option>${result.shopName}</option>

											</c:forEach>

										</select>
									</div>

									<div class="form-row">
										<label for="inputEmail4">Item Description</label> <input
											name="itemDescription" type="text" class="form-control"
											id="itemDescription" placeholder="Item Description"
											autocomplete="off" required>
									</div>

									<div class="form-row">
										<div class="form-group col-md-4">
											<label for="inputEmail4">Gross Price</label> <input
												name="grossPrice" type="number" class="form-control"
												id="grossPrice" placeholder="Gross Price" autocomplete="off"
												required>
										</div>
										<div class="form-group col-md-4">
											<label for="inputPassword4">Price Tag Amount</label> <input
												name="price" type="number" class="form-control"
												id="tagAmount" placeholder="Price Tag Amount"
												autocomplete="off" required>
										</div>
										<div class="form-group col-md-4">
											<label for="inputPassword4">Discount</label> <input
												name="discount" type="number" class="form-control"
												id="discount" placeholder="Discount" autocomplete="off"
												required>
										</div>
									</div>
									<div class="form-row">

										<div class="form-group col-md-4">
											<label for="inputPassword4">Quantity</label> <input
												name="itemQuantity" type="number" class="form-control"
												id="quantity" placeholder="Quantity" autocomplete="off"
												required>
										</div>


									</div>
									<div style="margin-left: 500px">
										<button type="submit" class="btn btn-primary">Add
											Stock</button>

									</div>


								</section>


							</form>

						</div>
					</div>
					<!-- end card-->
				</div>




			</div>
			<!-- END container-fluid -->
		</div>
		<!-- END content -->
	</div>
</body>


</html>
<%@ include file="../includes/footer.jsp"%>