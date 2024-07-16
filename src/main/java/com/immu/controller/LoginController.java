package com.immu.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping(value = {"/","/login"})
	public String login(@RequestParam(value = "error", defaultValue = "false") Boolean error,
			@RequestParam(value = "logout", defaultValue = "false") Boolean logout,
			@RequestParam(value = "userRegisterd", defaultValue = "false") Boolean userRegisterd,
			@RequestParam(value = "changePassword", defaultValue = "false") Boolean changePassword,
			Map<String, Object> model) {
		if(error == Boolean.TRUE) {
			model.put("errorMessage", "Invalid UserName and Password");
		}else if(logout == Boolean.TRUE) {
			model.put("successMessage", "You are logged out Successfully....");
		}else if(userRegisterd == Boolean.TRUE) {
			model.put("successMessage", "User Register Successfully...");
		}else if(changePassword == Boolean.TRUE) {
			model.put("successMessage", "Your Password Successfully Updated...");
		}
		
		return "login";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
}
