package com.immu.service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.immu.dto.UserDTO;
import com.immu.entity.RoleEntity;
import com.immu.entity.UserEntity;
import com.immu.mapper.LoginModelMapper;
import com.immu.repository.RoleRepository;
import com.immu.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LoginModelMapper loginModelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	public void registerUser(UserDTO userDTO) {

		RoleEntity roleEntity = roleRepository.findByName("ROLE_USER");

		UserEntity userEntity = loginModelMapper.convertDTOtoEntity(userDTO);
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		userEntity.setRoles(Arrays.asList(roleEntity));
		userRepository.save(userEntity);

	}

	@Override
	public Boolean findByEmail(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if (null != userEntity)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException(username + "not found..");
		}
		return User.withUsername(userEntity.getEmail()).password(userEntity.getPassword()).build();

	}

	@Override
	public void updateResetPasswordToken(String email, String token) {
		UserEntity userEntity = userRepository.findByEmail(email);
		userEntity.setResetPasswordToken(token);
		userEntity.setTokenGeneratedDate(new Timestamp(System.currentTimeMillis()));
		userRepository.save(userEntity);

	}

	@Override
	public Boolean validateResetPasswordToken(String token) {
		UserEntity userEntity = userRepository.findByResetPasswordToken(token);
		Long inMin = null;
		if(userEntity != null) 
		 inMin = validateResetPasswordExpiryTime(userEntity);
		// Invalidate reset password link after 5 minutes
		if (inMin != null && inMin <= 5) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}

	}

	private Long validateResetPasswordExpiryTime(UserEntity userEntity) {
		Timestamp tokenGeneratedTimestamp = userEntity.getTokenGeneratedDate();
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		Long diffInMillisec = currentTimestamp.getTime() - tokenGeneratedTimestamp.getTime();

		return diffInMillisec / (60 * 1000);

	}

	@Override
	public void updateChangePassword(String resetPasswordToken, String password) {
	UserEntity userEntity =	userRepository.findByResetPasswordToken(resetPasswordToken);
	
	userEntity.setPassword(passwordEncoder.encode(password));
	userRepository.save(userEntity);
		
	}

}
