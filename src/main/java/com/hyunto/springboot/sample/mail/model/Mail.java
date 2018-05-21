package com.hyunto.springboot.sample.mail.model;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "subject")
@ToString
public class Mail {

	private String from;

	private List<String> to;

	private List<String> cc;

	private String subject;

	private String content;

}
