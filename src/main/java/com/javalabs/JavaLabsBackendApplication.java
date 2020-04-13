package com.javalabs;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaLabsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaLabsBackendApplication.class, args);
	}

	@Bean
	public DozerBeanMapper mapper() {
		return new DozerBeanMapper();
	}
}
