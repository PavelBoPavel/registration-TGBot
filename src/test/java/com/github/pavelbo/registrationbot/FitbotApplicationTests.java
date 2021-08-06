package com.github.pavelbo.registrationbot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pavelbo.registrationbot.service.MessageService;
import com.github.pavelbo.registrationbot.service.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class, ObjectMapper.class, MessageService.class})
public class FitbotApplicationTests {

	@Test
	void contextLoads() {
	}

}
