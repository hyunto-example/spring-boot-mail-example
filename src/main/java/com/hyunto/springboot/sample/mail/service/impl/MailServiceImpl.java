package com.hyunto.springboot.sample.mail.service.impl;

import com.hyunto.springboot.sample.mail.model.Mail;
import com.hyunto.springboot.sample.mail.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
public class MailServiceImpl implements MailService {

	// Refercense : https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#mail

	@Autowired
	private MailSender mailSender;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendSimpleMail(Mail mail) throws MailException {
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom(mail.getFrom());
		msg.setTo(mail.getTo().stream().toArray(String[]::new));
		msg.setCc(mail.getCc().stream().toArray(String[]::new));

		msg.setSubject(mail.getSubject());
		msg.setText(mail.getContent());

		mailSender.send(msg);
	}

	@Override
	public void sendJavaMimeMail(Mail mail) throws MailException {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom(new InternetAddress(mail.getFrom()));

                // TODO: 소스코드 수정 필요
				Address[] toAddress = new Address[];

				mail.getTo().forEach(cc -> );

				for (String to : mail.getTo()) {
					toAddress
				}

				mimeMessage.setRecipients(Message.RecipientType.TO, mail.getTo().stream().toArray(Address[]::new));
				mimeMessage.setRecipients(Message.RecipientType.CC, mail.getCc().stream().toArray(Address[]::new));

				mimeMessage.setSubject(mail.getSubject());
				mimeMessage.setText(mail.getContent());
			}
		};

		javaMailSender.send(preparator);
	}

	@Override
	public void sendJavaMimeHelperMail(Mail mail) throws MailException {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();

	}

}
