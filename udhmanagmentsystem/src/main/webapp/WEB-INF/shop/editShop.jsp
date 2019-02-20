
 <%@ include file="../includes/menuAndSideBar.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



  <div class="content-page">
	
		<!-- Start content -->
        <div class="content">
            
			<div class="container-fluid">

					
										<div class="row">
					<div class="col-xl-12">
							<div class="breadcrumb-holder">
                                    <h1 class="main-title float-left">Update Whole Sale Shop</h1>
                                    <ol class="breadcrumb float-right">
										<li class="breadcrumb-item">Home</li>
										<li class="breadcrumb-item active">Forms</li>
                                    </ol>
                                    <div class="clearfix"></div>
                            </div>
					</div>
			</div>
            <!-- end row -->

            <div class="row">
			
                    <div class=" col-md-12">						
						<div class="card mb-3">
							
							<div class="card-body">
								
								<form>
								  <div class="form-group">
									<label for="exampleInputEmail1">Shop Name</label>
									<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter ShopName" required>
									<small id="emailHelp" class="form-text text-muted">Whole sales</small>
								  </div>
								  <div class="form-group">
									<label for="exampleInputEmail1">Address</label>
									<input type="number" class="form-control" id="exampleInputNumber1" aria-describedby="numberlHelp" placeholder="Enter number" required>
									
								  </div>
								  <div class="form-group">
									<label for="exampleInputPassword1">Telephone</label>
									<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
								  </div>
						<button type="submit" al class="btn btn-primary">Update</button>
								  
								</form>
																
							</div>														
						</div><!-- end card-->					
                    </div>
				</div>
        </div>
			<!-- END container-fluid -->
        </div>
		<!-- END content -->
      </div>

</body>
</html>
 <%@ include file="../includes/footer.jsp" %>