package com.care.root;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired 
	private JavaMailSender mailSender;
	
	public void send(String to, String subject, String body) {
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mailSender.send(msg);
	}
	


}
