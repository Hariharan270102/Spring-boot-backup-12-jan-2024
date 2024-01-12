package edu.capstone_project.EmailSending.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail, String otp) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(toEmail);
		message.setText("Your otp code is "+otp);
		message.setSubject("Your Otp Code");
		
		mailSender.send(message);
		System.out.println("Mail sent successfully! ");
	}

}
