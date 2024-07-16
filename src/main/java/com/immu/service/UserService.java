package com.immu.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.immu.dto.UserDTO;

public interface UserService extends UserDetailsService {
	
	void registerUser(UserDTO userDTO);

	Boolean findByEmail(String email);
	
	void updateResetPasswordToken(String email, String token);
	
	Boolean validateResetPasswordToken(String token);
	
	void updateChangePassword(String resetPasswordToken, String password);

}
