<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password Web Page</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

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


<script type="text/javascript">
function passwordMatch(confirmPassword) {
	if(confirmPassword.value ! = document.getElementById("password").value) {
		confirmPassword.setCustomValidity("Password do not match");
	}else {
		confirmPassword.setCustomValididty("");
	}
}
</script>

</head>
<body>
	<h1 align="center">Change Password</h1>
	<!-- Section: Design Block -->
	<section class="text-center text-lg-start">
		1


		<!-- Jumbotron -->
		<div class="container py-4">
			<div class="row g-0 align-items-center">
				<div class="col-lg-6 mb-5 mb-lg-0">
					<div class="card cascading-right bg-body-tertiary"
						style="backdrop-filter: blur(30px);">
						<div class="card-body p-5 shadow-5 text-center">
							<h2 class="fw-bold mb-5">Change Password</h2>
							<div id="errorMessage"
								class="divider d-flex align-items-center my-4 text-danger">
								<p class="text-center fw-bold mx-3 mb-0">${errorMessage}</p>
							</div>
							<form action="changePassword" method="post">



								<!-- Password input -->
								<div data-mdb-input-init class="form-outline mb-4">
									<input type="password"
										
										oninput="this.setCustomValidity('')" required="required"
										id="password" name="password" class="form-control" /> <label
										class="form-label" for="form3Example4">Password</label>
								</div>

								<div data-mdb-input-init class="form-outline mb-4">
									<input type="password"
										
										oninput="passwordMatch(this)" required="required"
										id="confirmPassword" class="form-control" /> <label
										class="form-label" for="form3Example4"> Confirm Password</label>
								</div>

<input type="hidden" name="resetPasswordToken" value="${_csrf.token}"/>

								<!-- Submit button -->
								<button type="submit" data-mdb-button-init data-mdb-ripple-init
									class="btn btn-primary btn-block mb-4">Change Password</button>

								
								<input id="csrf" name="_csrf" type="hidden"
									value="${_csrf.token}" />
							</form>
						</div>
					</div>
				</div>

				<div class="col-lg-6 mb-5 mb-lg-0">
					<img src="images/resetPassword.png" class="w-100 rounded-4 shadow-4"
						alt="" />
				</div>
			</div>
		</div>
		<!-- Jumbotron -->
	</section>
	<!-- Section: Design Block -->
</body>
</html>