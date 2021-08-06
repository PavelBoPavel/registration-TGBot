package com.github.pavelbo.registrationbot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.pavelbo.registrationbot.constant.StringConstant.CONFIRM_ENTRY_MESSAGE;
import static com.github.pavelbo.registrationbot.util.ChatIdExtractor.getChatId;

@Service
public class CallbackHourProcessor extends BaseProcessor implements Processor {

    public void process(Update update) {
        switch (update.getCallbackQuery().getData()) {
            case "/hour900":
            case "/hour930":
            case "/hour1000":
            case "/hour1030":
            case "/hour1100":
            case "/hour1130":
            case "/hour1200":
            case "/hour1230":
            case "/hour1300":
            case "/hour1330":
            case "/hour1400":
            case "/hour1430":
            case "/hour1500":
            case "/hour1530":
            case "/hour1600":
            case "/hour1630":
            case "/hour1700":
            case "/hour1730":
            case "/hour1800":
            case "/hour1830":
            case "/hour1900":
            case "/hour1930":
            case "/hour2000":
            case "/hour2030":
            case "/hour2100":
            case "/hour2130":
            case "/hour2200":
                //saveFile(update);
                messageService.sendMessage(getChatId(update), CONFIRM_ENTRY_MESSAGE + "15 июля в 17:00-17:30 ",
                        replayKeyboardService.getYesOrNo());
                break;
        }
    }
}
