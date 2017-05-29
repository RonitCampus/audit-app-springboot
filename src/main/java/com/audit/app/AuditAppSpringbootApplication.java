package com.audit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ("com.audit.app")
public class AuditAppSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditAppSpringbootApplication.class, args);
	}
}
