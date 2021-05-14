package com.hrms.karcan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class KarcanApplication extends SpringBootServletInitializer {

	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KarcanApplication.class);
	}	
	public static void main(String[] args) {
		SpringApplication.run(KarcanApplication.class, args);
	}

}
