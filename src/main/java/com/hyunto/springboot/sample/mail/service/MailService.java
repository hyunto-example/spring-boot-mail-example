package com.hyunto.springboot.sample.mail.service;

import com.hyunto.springboot.sample.mail.model.Mail;
import org.springframework.mail.MailException;

public interface MailService {

	public void sendMail(Mail mail) throws MailException;

}
