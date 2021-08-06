package com.github.pavelbo.registrationbot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.pavelbo.registrationbot.constant.StringConstant.START_MESSAGE;
import static com.github.pavelbo.registrationbot.util.ChatIdExtractor.getChatId;

@Service
public class CallbackAnotherProcessor extends BaseProcessor implements Processor {

    public void process(Update update) {
        switch (update.getCallbackQuery().getData()) {
            case "/start":
                messageService.sendMessage(getChatId(update), START_MESSAGE,
                        inlineKeyboardSource.getKeyboardMain(), replayKeyboardService.getReplayKeyboardMain());
                break;
            case "/contact":
                messageService.sendMessage(getChatId(update), "Contact!", inlineKeyboardSource.getKeyboardMain());
                break;
            default:
                messageService.sendMessage(getChatId(update), "Do no!", inlineKeyboardSource.getKeyboardMain(), replayKeyboardService.getReplayKeyboardMain());
                break;
        }
    }
}
