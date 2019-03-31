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
						<h1 class="main-title float-left">Return Note</h1>
						
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!-- end row -->

			
									
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
				<div class="card mb-3">


					<div class="card-body">

						<form action=""></form>
						<div class="form-group">
							<label for="exampleInputEmail1">Bill Number</label> <input
								type="email" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" placeholder="Enter Bill Number"
								required>
							<button type="submit" class="btn btn-primary">Search</button>
						</div>

						<form>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
								<div class="card mb-3">


									<div class="card-body">

										<table class="table table-responsive-xl table-bordered">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">Item Number</th>
													<th scope="col">Quantity</th>
													<th scope="col">add to return Note</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<th scope="row">1</th>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>

											</tbody>
										</table>

									</div>
								</div>
								<!-- end card-->
							</div>

						</form>

					</div>
				</div>
				<!-- end card-->
			</div>
				<!-- end card-->
			</div>




		</div>
		<!-- END container-fluid -->
	</div>
	<!-- END content -->
</div>

<%@ include file="../includes/footer.jsp"%>