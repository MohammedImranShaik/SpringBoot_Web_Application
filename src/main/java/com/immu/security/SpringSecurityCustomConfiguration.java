package com.immu.security;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ch.qos.logback.classic.Logger;

@Configuration
public class SpringSecurityCustomConfiguration {

	// Static InMemoryUserDetails Credentials
/*	@Bean
	InMemoryUserDetailsManager userDetails() {
		UserDetails details = User.withUsername("meera").password(passwordEncoder().encode("shaik")).build();
		UserDetails details1 = User.withUsername("rasheed").password(passwordEncoder().encode("shaik")).build();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(details, details1);
		return manager;
	} */

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	Logger logger = (Logger) LoggerFactory.getLogger(SpringSecurityCustomConfiguration.class);

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		logger.info("___Spring Security Custom Configuration_____");
		return httpSecurity
				
				.authorizeHttpRequests(
						authorize -> authorize.requestMatchers("/home").authenticated().anyRequest().permitAll())

				.formLogin(login -> 
				login.loginPage("/login")
				.defaultSuccessUrl("/home")
				.failureUrl("/login?error=true"))
				
				.logout(logout
						-> logout.invalidateHttpSession(true)
						.clearAuthentication(true)
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/login?logout=true"))
				
				.build();

	}

}
