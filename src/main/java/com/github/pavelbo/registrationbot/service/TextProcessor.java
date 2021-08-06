package com.github.pavelbo.registrationbot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.pavelbo.registrationbot.constant.StringConstant.*;
import static com.github.pavelbo.registrationbot.util.ChatIdExtractor.getChatId;

@Service
public class TextProcessor extends BaseProcessor implements Processor {

    public void process(Update update) {
        switch (update.getMessage().getText()) {
            case "/start":
                messageService.sendMessage(getChatId(update), START_MESSAGE,
                        inlineKeyboardSource.getKeyboardMain(), replayKeyboardService.getContact());
                break;
            case "Описание":
                messageService.sendMessage(getChatId(update), DESCRIPTION_MESSAGE);
                break;
            case "Контакты":
                messageService.sendMessage(getChatId(update), CONTACT_DETAILS_MESSAGE);
                break;
            case "Начать запись!":
                messageService.sendMessage(getChatId(update), SELECTION_OF_THE_MONTH,
                        inlineKeyboardSource.getKeyboardMonth());
                break;
            case "Подтвердить!":
                messageService.sendMessage(getChatId(update), CONFIRMATION,
                        replayKeyboardService.getReplayKeyboardMain());
                break;
            case "Отмена!":
                messageService.sendMessage(getChatId(update), CANCEL,
                        replayKeyboardService.getReplayKeyboardMain());
                break;
            default:
                messageService.sendMessage(getChatId(update), "Do no!", replayKeyboardService.getReplayKeyboardMain());
                break;
        }
    }
}
