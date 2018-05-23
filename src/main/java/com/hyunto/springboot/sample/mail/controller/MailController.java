package com.hyunto.springboot.sample.mail.controller;

import com.hyunto.springboot.sample.mail.model.Mail;
import com.hyunto.springboot.sample.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0/mail")
public class MailController {

	@Autowired
	private MailService mailService;

	@PostMapping("/simple")
	public void sendSimpleMail(@RequestBody Mail mail) {
		mailService.sendSimpleMail(mail);
	}

	@PostMapping("/javamime")
	public void sendJavaMimeMail(@RequestBody Mail mail) {
		mailService.sendJavaMimeMail(mail);
	}

	@PostMapping("/javamimehelper")
	public void sendJavaMimeHelperMail(@RequestBody Mail mail) {
		mailService.sendJavaMimeHelperMail(mail);
	}

}
