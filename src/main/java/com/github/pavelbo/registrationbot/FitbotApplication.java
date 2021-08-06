package com.github.pavelbo.registrationbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class FitbotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(FitbotApplication.class, args);
	}
}
