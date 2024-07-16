<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forgot Password</title>
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


</head>
<body>

	<!-- Section: Design Block -->
	<section class="text-center text-lg-start">



		<!-- Jumbotron -->
		<div class="container py-4">
			<div class="row g-0 align-items-center">
				<div class="col-lg-6 mb-5 mb-lg-0">
					<div class="card cascading-right bg-body-tertiary"
						style="backdrop-filter: blur(30px);">
						<div class="card-body p-5 shadow-5 text-center">
							<h2 class="fw-bold mb-5">Forgot Password</h2>
							<div id="errorMessage"
								class="divider d-flex align-items-center my-4 text-danger">
								<p class="text-center fw-bold mx-3 mb-0">${errorMessage}</p>
							</div>
							
							<div id="errorMessage"
								class="divider d-flex align-items-center my-4 text-success">
								<p class="text-center fw-bold mx-3 mb-0">${successMessage}</p>
							</div>

							<div id="errorMessage"
								class="divider d-flex align-items-center my-4">
								<p class="text-center fw-bold mx-3 mb-0">we will be sending
									an email to reset the password. Please enter your email
									address..</p>
							</div>



							<form action="sendEmail" method="post">


								<!-- Email input -->
								<div data-mdb-input-init class="form-outline mb-4">
									<input type="email"
										oninvalid="setCustomValidity('Please enter Email')"
										oninput="this.setCustomValidity('')" required="required"
										id="email" name="email" class="form-control" /> <label
										class="form-label" for="form3Example3">Email address</label>
								</div>





								<!-- Submit button -->
								<button type="submit" data-mdb-button-init data-mdb-ripple-init
									class="btn btn-primary btn-block mb-4">Send</button>


								<input id="csrf" name="_csrf" type="hidden"
									value="${_csrf.token}" />
							</form>
						</div>
					</div>
				</div>

				<div class="col-lg-6 mb-5 mb-lg-0">
					<img src="images/forgot1.jpg" class="w-100 rounded-4 shadow-4"
						alt="" />
				</div>
			</div>
		</div>
		<!-- Jumbotron -->
	</section>
	<!-- Section: Design Block -->
</body>
</html>