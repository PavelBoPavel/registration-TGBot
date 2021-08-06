package com.github.pavelbo.registrationbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.IOException;

@Component
@PropertySource("application.properties")
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

    final ObjectMapper objectMapper;

    public TelegramBot(ObjectMapper objectMapper, DispatchUpdate dispatchUpdate) {
       this.objectMapper = objectMapper;
       this.dispatchUpdate = dispatchUpdate;
    }

    final DispatchUpdate dispatchUpdate;

    @Override
    public void onUpdateReceived(Update update) {
        dispatchUpdate.choiceOfAnswer(update);
    }

    private void saveJson(Update update) {
        try{
            objectMapper.writeValue(new File("src/test/resources/contact.json"), update);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
