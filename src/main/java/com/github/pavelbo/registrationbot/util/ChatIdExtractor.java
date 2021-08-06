package com.github.pavelbo.registrationbot.util;

import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.pavelbo.registrationbot.util.UpdateTypeUtil.isCallbackQuery;
import static com.github.pavelbo.registrationbot.util.UpdateTypeUtil.isTextMessage;

public class ChatIdExtractor {

    public static Long getChatId(Update update) {
        if (isTextMessage(update))
            return update.getMessage().getChatId();
        else if (isCallbackQuery(update))
            return update.getCallbackQuery().getMessage().getChatId();
        else if (update.getMessage().hasContact()){
            return update.getMessage().getChatId();
        }
        return null;
    }
}
