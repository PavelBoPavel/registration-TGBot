package com.github.pavelbo.registrationbot.util;

import com.github.pavelbo.registrationbot.constant.UpdateType;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateTypeUtil {

    public static UpdateType getType(Update update) {
        if (isTextMessage(update)) {
            return UpdateType.TEXT;
        } else if (isCallbackQuery(update)) {
            if (update.getCallbackQuery().getData().contains("/month")) {
                return UpdateType.CALLBACK_MONTH;
            } else if (update.getCallbackQuery().getData().contains("/day")) {
                return UpdateType.CALLBACK_DAY;
            } else if (update.getCallbackQuery().getData().contains("/hour")) {
                return UpdateType.CALLBACK_HOUR;
            } else {
                return UpdateType.CALLBACK_ANOTHER;
            }
        } else if (isContactMessage(update)) {
            return UpdateType.CONTACT;
        } else {
            return UpdateType.DEFAULT;
        }
    }

    public static boolean isContactMessage(Update update) {
        return update.hasMessage() && update.getMessage().hasContact();
    }

    public static boolean isCallbackQuery(Update update) {
        return update.hasCallbackQuery();
    }

    public static boolean isTextMessage(Update update) {
        return update.hasMessage() && update.getMessage().hasText();
    }
}
