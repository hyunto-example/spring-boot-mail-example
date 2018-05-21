package com.hyunto.springboot.sample.mail.service.impl;

import com.hyunto.springboot.sample.mail.model.Mail;
import com.hyunto.springboot.sample.mail.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MailSender sender;

	@Override
	public void sendMail(Mail mail) throws MailException {
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom(mail.getFrom());
		msg.setTo(mail.getTo().stream().toArray(String[]::new));
		msg.setCc(mail.getCc().stream().toArray(String[]::new));
		msg.setSubject(mail.getSubject());
		msg.setText(mail.getContent());

		sender.send(msg);
	}

}
