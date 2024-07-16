package com.immu.controller;

import java.util.Map;

import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.immu.service.EmailSenderService;
import com.immu.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ForgotPasswordController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailSenderService emailSenderService;

	@GetMapping("/viewForgotPassword")
	public String viewForgotPassword() {
		return "forgotpassword";
	}

	@PostMapping("/sendEmail")
	public String sendEmail(String email, Map<String, Object> model, HttpServletRequest request) {
		Boolean emailExist = userService.findByEmail(email);
		if (emailExist) {
			// Generate reset password token and reset password link
			String token = RandomString.make(25);

			String webURL = request.getRequestURI().toString(); // http://localhost:8080/sendEmail

			String link = webURL.replace(request.getServletPath(), ""); // http://localhost:8080/

			String restPasswordLink = link + "/resetPassword?token=" + token;
			// http://localhost:8080/resetPassword?token=randomstring

			// update reset password token into the database

			userService.updateResetPasswordToken(email, token);

			// send a email to end user with rest password link
			String emailSubject = "click on the link to reset your password";
			emailSenderService.sendEmail(email, link, restPasswordLink);
			model.put("successMessage", "Reset Password link send to your email successfully...");
		} else {

			model.put("errorMessage", "User does not Exist...");

		}
		return "forgotpassword";
	}

}
