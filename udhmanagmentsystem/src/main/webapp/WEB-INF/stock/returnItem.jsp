<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../includes/menuAndSideBar.jsp"%>


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

<div class="content-page">

	<!-- Start content -->
	<div class="content">

		<div class="container-fluid">


			<div class="row">
				<div class="col-xl-12">
					<div class="breadcrumb-holder">
						<h1 class="main-title float-left">Return Item</h1>
						
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->

			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
				<div class="card mb-3">

					<div class="card-body">

						<form method="POST" action="returnItem" modelAttribute="Item">

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="exampleInputEmail1">Item No</label> <input
											list="hosting-plan" type="text" name="itemCode"
											class="form-control" id="itemCode"
											aria-describedby="numberlHelp" placeholder="" required>

										<datalist id="hosting-plan">
											<c:forEach var="result" items="${itemList}">

												<option value="${result.itemCode}" />
											</c:forEach>
										</datalist>

									</div>
									<div class="form-group col-md-4">
										<label for="inputPassword4">Quantity</label> <input
											name="itemQuantity" type="number" class="form-control"
											id="itemQuantity" placeholder="Quntity"
											autocomplete="off" required>
									</div>
									
								</div>
								
								<div style="margin-left: 500px">
									<button type="submit" class="btn btn-primary">Submit</button>

								</div>


							

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

<%@ include file="../includes/footer.jsp"%>