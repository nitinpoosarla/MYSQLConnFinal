package com.ApplicationRun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing
@EnableAutoConfiguration

public class EmployeeApplication {

	public static void main(String args[])
	{
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
}
