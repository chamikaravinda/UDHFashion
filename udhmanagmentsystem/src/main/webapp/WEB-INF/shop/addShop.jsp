
<%@ include file="../includes/menuAndSideBar.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<script>
	function validator() {

		var shopName = document.getElementById("shopName").value;
		var shopAddress = document.getElementById("shopAddress").value;
		var shopTele = document.getElementById("shopTele").value;

		if (shopName == null || shopName == "") {
			alert("Please Enter a shop name ");
			return false;
		}

		if (shopAddress == null || shopAddress == "") {
			alert("Please Enter a shop name ");
			return false;
		}

		if (shopTele == null || shopTele == "") {
			alert("Please enter a shop telephone number ");
			return false;
		}

		if (shopTele.length != 10) {
			alert("Telephone number must contain 10 characters");
			return false;
		}
	}
</script>





<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">


			<div class="row">
				<div class="col-xl-12">
					<div class="breadcrumb-holder">
						<h1 class="main-title float-left">New Supplier</h1>
						<ol class="breadcrumb float-right">
							<li class="breadcrumb-item">Home</li>
							<li class="breadcrumb-item active">Suppliers</li>
						</ol>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->

			<div class="row">
				<br>
				<div class=" col-md-12">
					<div class="card mb-3">

						<div class="card-body">

							<form method="POST" action="submitShop" modelAttribute="shop"
								onsubmit="return validator()">

								<div class="row">
									<div class="form-group col-md-5">
										<label for="exampleInputEmail1">Shop Name</label> <input
											type="text" name="shopName" class="form-control"
											id="shopName" aria-describedby="emailHelp"
											placeholder="Shop Name" required>
									</div>
									<div class="form-group offset-md-1 col-md-5">
										<label for="exampleInputEmail1">Address</label> <input
											type="text" name="shopAddress" class="form-control"
											id="shopAddress" aria-describedby="numberlHelp"
											placeholder="Shop Address" required>

									</div>
									<div class="form-group col-md-5">
										<label for="exampleInputPassword1">Telephone</label> <input
											type="number" name="shopTelephone" class="form-control"
											id="shopTele" placeholder="Telephone Number" required>
									</div>
								</div>
								<br>
								<div style="margin-left: 500px">
									<button type="submit" class="btn btn-primary">AddShop</button>
								</div>

							</form>

						</div>
					</div>
					<!-- end card-->
				</div>
			</div>
		</div>
		<!-- END container-fluid -->
	</div>
	<!-- END content -->
</div>

<%@ include file="../includes/footer.jsp"%>