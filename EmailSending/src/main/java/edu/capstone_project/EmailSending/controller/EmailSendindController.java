package edu.capstone_project.EmailSending.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.capstone_project.EmailSending.service.EmailSenderService;

@RestController

public class EmailSendindController {
	@Autowired
	private EmailSenderService emailService;
	
	@PostMapping("/sendOtp")
	public String sendOtp(@RequestBody String email) {
		try {
			ObjectMapper objectMapper=new ObjectMapper();
			JsonNode jsonNode=objectMapper.readTree(email);
			String emailgmail=jsonNode.get("email").asText();
			System.out.println("email"+email);
			String otp=generateOtp();
			
			System.out.println(emailgmail);
			
			emailService.sendEmail(emailgmail, otp);
			
			return "Email Sent Succesfully";
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return "Email to successfully";
		
	}
	
	private String generateOtp() {
		return String.valueOf((int)((Math.random()*900000)+100000));
	}

}
