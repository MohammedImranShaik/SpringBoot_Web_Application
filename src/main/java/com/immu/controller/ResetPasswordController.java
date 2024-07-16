package com.immu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.immu.service.UserService;

@Controller
public class ResetPasswordController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/seeResetWeb")
	public String seeResetPasswordWeb() {
		return "changePassword";
	}

	@GetMapping("/resetPassword")
	public String resetPasswordWebPage(@RequestParam String token) {

		// validate the reset password token
		Boolean tokenValid = userService.validateResetPasswordToken(token);

		if (tokenValid) {
			// if token is valid, then we have to display change password page.
			return "changePassword";
		} else {
			// If token is not valid, then we have to display error message to end user
			return "message";
		}
		
		
	}

}
