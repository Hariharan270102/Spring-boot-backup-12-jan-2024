package edu.capstone_project.EmailSending;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import edu.capstone_project.EmailSending.service.EmailSenderService;

@SpringBootApplication
public class EmailSendingApplication {

//	@Autowired
//	private EmailSenderService senderService;
	public static void main(String[] args) {
		SpringApplication.run(EmailSendingApplication.class, args);
	}
//	@EventListener(ApplicationReadyEvent.class)
//	public void sendEmail() {
//		senderService.sendEmail("gdrive05hari.com", "Hello from email sending demo spring boot", "This is body of the Email ");
//		
//	}

}
