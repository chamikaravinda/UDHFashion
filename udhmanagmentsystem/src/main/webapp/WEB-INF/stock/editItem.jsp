<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
								
								<form method="POST" autocomplete="off" action="updateStock"
								modelAttribute="stock" onsubmit="return validator()>



								<!--div class="form-row">
							
								</div-->

								<div class="form-group">
									<label for="sel1">Shop No</label> 
									<select name = "shopId" class="form-control" id="shopId" value = "${returnItem.shopId}" required>
			
										<c:forEach var="result" items = "${shopList}">
										
											<option> ${result.shopId}</option>

										</c:forEach>
											
									</select>
								</div>
								
								<div class="form-row">
										<label for="inputEmail4">Item Description</label> <input
											name="itemDescription" type="text" class="form-control"
											id="itemDescription" placeholder="Item Description" autocomplete="off" value = "${returnItem.itemDescription}" required>
									
										<input type = "hidden" value = "${returnItem.itemCode}" name = "itemCode" >
									</div>

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="inputEmail4">Gross Price</label> <input
											name="grossPrice" type="number" class="form-control"
											id="grossPrice" placeholder="Gross Price"  value = "${returnItem.grossPrice}" autocomplete="off" required>
									</div>
									<div class="form-group col-md-4">
										<label for="inputPassword4">Price Tag Amount</label> <input
											name="price" type="number" class="form-control"
											id="tagAmount"  value = "${returnItem.price}" placeholder="Price Tag Amount"
											autocomplete="off" required>
									</div>
									<div class="form-group col-md-4">
										<label for="inputPassword4">Discount</label> <input
											name="discount" type="number" class="form-control"
											id="discount"  value = "${returnItem.discount}" placeholder="Discount"
											autocomplete="off" required>
									</div>
								</div>
								<div class="form-row">
									
									<div class="form-group col-md-4">
										<label for="inputPassword4">Qty</label> <input
											name="itemQuantity" type="number" class="form-control"
											id="quantity"  value = "${returnItem.itemQuantity}" placeholder="Quantity"
											autocomplete="off" required>
									</div>


								</div>

								<button type="submit" class="btn btn-primary">Update Stock</button>
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