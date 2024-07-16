package com.immu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.immu.dto.UserDTO;
import com.immu.entity.UserEntity;
import com.immu.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/userRegistration")
	public String userRegistrationPage() {
		return "userRegistration";
	}

	@PostMapping("/registerUser")
	public String registerUser(UserDTO userDTO, Map<String, Object> model) {
		Boolean userExists = userService.findByEmail(userDTO.getEmail());
		if (userExists) {
			model.put("errorMessage", "User Already Exists...");
			return "userRegistration";
		} else {
			userService.registerUser(userDTO);
			return "redirect:login?userRegisterd=true";
		}
	}

	@PostMapping("/findByEmail")
	@ResponseBody
	public Boolean findByEmail(String email) {
		Boolean userExists = userService.findByEmail(email);
		if (userExists) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

}
