<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login_page</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
	<h1 align="center">Welcome to Web Application</h1>
	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-9 col-lg-6 col-xl-5">
					<img src="images/technology.jpg" class="img-fluid"
						alt="Sample image">
				</div>
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
					<form action="/login" method="post">


						<div class="divider d-flex align-items-center my-4">
							<p class="text-center fw-bold mx-3 mb-0">Login</p>
						</div>
						
						
						<div class="divider d-flex align-items-center my-4 text-danger">
							<p class="text-center fw-bold mx-3 mb-0">${errorMessage}</p>
						</div>
						
						<div class="divider d-flex align-items-center my-4 text-success">
							<p class="text-center fw-bold mx-3 mb-0">${successMessage}</p>
						</div>

						<!-- Email input -->
						<div data-mdb-input-init class="form-outline mb-4">
							<input type="text" id="form3Example3" name="username"
								class="form-control form-control-lg"
								placeholder="Enter a valid UserName" /> <label
								class="form-label" for="form3Example3">UserName</label>
						</div>

						<!-- Password input -->
						<div data-mdb-input-init class="form-outline mb-3">
							<input type="password" id="form3Example4" name="password"
								class="form-control form-control-lg"
								placeholder="Enter password" /> <label class="form-label"
								for="form3Example4">Password</label>
						</div>

						<div class="d-flex justify-content-between align-items-center">
							<!-- Checkbox -->
							<div class="form-check mb-0">
								<input class="form-check-input me-2" type="checkbox" value=""
									id="form2Example3" /> <label class="form-check-label"
									for="form2Example3"> Remember me </label>
							</div>
							<a href="viewForgotPassword" class="text-body">Forgot password?</a>
						</div>

						<div class="text-center text-lg-start mt-4 pt-2">
							<button type="Submit" data-mdb-button-init data-mdb-ripple-init
								class="btn btn-primary btn-lg"
								style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
							<p class="small fw-bold mt-2 pt-1 mb-0">
								Don't have an account? <a href="/userRegistration"
									class="link-danger">Register</a>
							</p>
						</div>

						<input name="_csrf" type="hidden" value="${_csrf.token}" />

					</form>
				</div>
			</div>
		</div>
		<div
			class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
			<!-- Copyright -->
			<div class="text-white mb-3 mb-md-0">Find Your Job....</div>
			<!-- Copyright -->

			<!-- Right -->
			<div>
				<a href="#!" class="text-white me-4"> <i
					class="fab fa-facebook-f"></i>
				</a> <a href="#!" class="text-white me-4"> <i class="fab fa-twitter"></i>
				</a> <a href="#!" class="text-white me-4"> <i class="fab fa-google"></i>
				</a> <a href="#!" class="text-white"> <i class="fab fa-linkedin-in"></i>
				</a>
			</div>
			<!-- Right -->
		</div>
	</section>
</body>
</html>