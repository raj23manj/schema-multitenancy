package com.schema.multinenancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MultinenancyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultinenancyApplication.class, args);
	}

}
