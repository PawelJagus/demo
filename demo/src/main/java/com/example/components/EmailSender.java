package com.example.components;

import org.springframework.mail.javamail.JavaMailSender;

public class EmailSender {
	
	private final JavaMailSender mailSender;
	
	public EmailSender(final JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}
}
