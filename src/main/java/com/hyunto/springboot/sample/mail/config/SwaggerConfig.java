package com.hyunto.springboot.sample.mail.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Value("${swagger.title:springfox-swagger2}")
	private String title;

	@Value("${swagger.description:springfox-swagger2}")
	private String description;

	@Value("${swagger.version:v1.0}")
	private String version;

	@Value("${swagger.termsOfServiceUrl:Terms of Service")
	private String termsOfServiceUrl;

	@Value("${swagger.contact.name:hyunto}")
	private String contactName;

	@Value("${swagger.contact.url:https://www.example.com}")
	private String contactUrl;

	@Value("${swagger.contact.email:email@company.com}")
	private String contactEmail;

	@Value("${swagger.license:License of API}")
	private String licesnse;

	@Value("${swagger.license.url:API License URL}")
	private String licenseUrl;

	private Collection<VendorExtension> vendorExtensions = Collections.emptyList();

	@Value("#{'${swagger.path}'.split(',')}")
	private List<String> patterns;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.any())
					.paths(paths())
					.build()
				.apiInfo(this.apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				title,
				description,
				version,
				termsOfServiceUrl,
				this.contact(),
				licesnse,
				licenseUrl,
				vendorExtensions
		);
	}

	private Predicate<String> paths() {

		System.out.println();

		return or(
				patterns.stream().map(PathSelectors::regex).collect(Collectors.toList())
		);
	}

	private Contact contact() {
		return new Contact(
				this.contactName,
				this.contactUrl,
				this.contactEmail
		);
	}

}
