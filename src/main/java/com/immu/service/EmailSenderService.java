package com.immu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String toEmail, String subject, String body) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setFrom("imranimmusk45@gmail.com");
		
		msg.setTo(toEmail);
		msg.setSubject(subject);
		msg.setText(body);
		
		javaMailSender.send(msg);
		
	}

}
