package com.github.pavelbo.registrationbot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.pavelbo.registrationbot.util.ChatIdExtractor.getChatId;

@Service
public class ContactProcessor extends BaseProcessor implements Processor{

    public void process(Update update) {
        messageService.sendMessage(getChatId(update),"Авторизация прошла успешно!", replayKeyboardService.getReplayKeyboardMain());
    }
}
