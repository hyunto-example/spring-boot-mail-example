package com.hyunto.springboot.sample.mail.service;

import com.hyunto.springboot.sample.mail.model.Mail;
import org.springframework.mail.MailException;

public interface MailService {

	public void sendSimpleMail(Mail mail) throws MailException;

	public void sendJavaMimeMail(Mail mail) throws MailException;

	public void sendJavaMimeHelperMail(Mail mail) throws MailException;

}
