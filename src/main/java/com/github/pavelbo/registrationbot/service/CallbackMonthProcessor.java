package com.github.pavelbo.registrationbot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.github.pavelbo.registrationbot.constant.StringConstant.SELECTION_OF_THE_DAY;
import static com.github.pavelbo.registrationbot.util.ChatIdExtractor.getChatId;

@Service
public class CallbackMonthProcessor extends BaseProcessor implements Processor {

    public void process(Update update) {
        switch (update.getCallbackQuery().getData()) {
            case "/month1":
                messageService.sendMessage(getChatId(update), SELECTION_OF_THE_DAY,
                        inlineKeyboardSource.getKeyboardDay(countDay(Calendar.getInstance().get(Calendar.MONTH))));
                break;
            case "/month2":
                int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
                messageService.sendMessage(getChatId(update), SELECTION_OF_THE_DAY,
                        inlineKeyboardSource.getKeyboardDay(countDay(month)));
                break;
        }
    }

    private int countDay(int month) {
        GregorianCalendar calendar = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR),
                month, Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
