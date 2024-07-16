<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User_Registration</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		console.log("ready!");
		
		$("#email").blur(function(){
			$.ajax({
				  type: "POST",
				  url: "findByEmail",
				  data: {"email": $("#email").val(), "csrf": $("#csrf").val()},
				  success: function(emailExists){
					  
					  if(emailExists) {
						  $("errorMessage").html("User Already Exists...");
					  } else {
						  $("errorMessage").html("");
					  }
					  
				  },
				 
				});
			});
		
	});
</script>
</head>
<body>
	<h1 align="center">User Registration</h1>
	<!-- Section: Design Block -->
	<section class="text-center text-lg-start">
		1
		<style>
.cascading-right {
	margin-right: -50px;
}

@media ( max-width : 991.98px) {
	.cascading-right {
		margin-right: 0;
	}
}
</style>

		<!-- Jumbotron -->
		<div class="container py-4">
			<div class="row g-0 align-items-center">
				<div class="col-lg-6 mb-5 mb-lg-0">
					<div class="card cascading-right bg-body-tertiary"
						style="backdrop-filter: blur(30px);">
						<div class="card-body p-5 shadow-5 text-center">
							<h2 class="fw-bold mb-5">Sign up now</h2>
							<div id="errorMessage" class="divider d-flex align-items-center my-4 text-danger">
								<p class="text-center fw-bold mx-3 mb-0">${errorMessage}</p>
							</div>
							<form action="registerUser" method="post">
								<!-- 2 column grid layout with text inputs for the first and last names -->
								<div class="row">
									<div class="col-md-6 mb-4">
										<div data-mdb-input-init class="form-outline">
											<input type="text"
												oninvalid="setCustomValidity('Please enter the firstName')"
												oninput="this.setCustomValidity('')" required="required"
												id="form3Example1" name="firstName" class="form-control" />
											<label class="form-label" for="form3Example1">First
												name</label>
										</div>
									</div>
									<div class="col-md-6 mb-4">
										<div data-mdb-input-init class="form-outline">
											<input type="text"
												oninvalid="setCustomValidity('Please enter lastName')"
												oninput="this.setCustomValidity('')" required="required"
												id="form3Example2" name="lastName" class="form-control" />
											<label class="form-label" for="form3Example2">Last
												name</label>
										</div>
									</div>
								</div>

								<!-- Email input -->
								<div data-mdb-input-init class="form-outline mb-4">
									<input type="email"
										oninvalid="setCustomValidity('Please enter Email')"
										oninput="this.setCustomValidity('')" required="required"
										id="email" name="email" class="form-control" /> <label
										class="form-label" for="form3Example3">Email address</label>
								</div>

								<!-- Password input -->
								<div data-mdb-input-init class="form-outline mb-4">
									<input type="password"
										oninvalid="setCustomValidity('Please enter Valid Password')"
										oninput="this.setCustomValidity('')" required="required"
										id="form3Example4" name="password" class="form-control" /> <label
										class="form-label" for="form3Example4">Password</label>
								</div>



								<!-- Submit button -->
								<button type="submit" data-mdb-button-init data-mdb-ripple-init
									class="btn btn-primary btn-block mb-4">Sign up</button>

								<!-- Register buttons -->
								<div class="text-center">
									<p>or sign up with:</p>
									<button type="button" data-mdb-button-init data-mdb-ripple-init
										class="btn btn-link btn-floating mx-1">
										<i class="fab fa-facebook-f"></i>
									</button>

									<button type="button" data-mdb-button-init data-mdb-ripple-init
										class="btn btn-link btn-floating mx-1">
										<i class="fab fa-google"></i>
									</button>

									<button type="button" data-mdb-button-init data-mdb-ripple-init
										class="btn btn-link btn-floating mx-1">
										<i class="fab fa-twitter"></i>
									</button>

									<button type="button" data-mdb-button-init data-mdb-ripple-init
										class="btn btn-link btn-floating mx-1">
										<i class="fab fa-github"></i>
									</button>
								</div>
								<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}" />
							</form>
						</div>
					</div>
				</div>

				<div class="col-lg-6 mb-5 mb-lg-0">
					<img src="images/registration.jpg" class="w-100 rounded-4 shadow-4"
						alt="" />
				</div>
			</div>
		</div>
		<!-- Jumbotron -->
	</section>
	<!-- Section: Design Block -->
</body>
</html>