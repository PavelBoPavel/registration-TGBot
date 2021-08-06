package com.github.pavelbo.registrationbot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.pavelbo.registrationbot.constant.StringConstant.SELECTION_OF_THE_HOUR;
import static com.github.pavelbo.registrationbot.util.ChatIdExtractor.getChatId;

@Service
public class CallbackDayProcessor extends BaseProcessor implements Processor {

    public void process(Update update) {
        switch (update.getCallbackQuery().getData()) {
            case "/day1":
            case "/day2":
            case "/day3":
            case "/day4":
            case "/day5":
            case "/day6":
            case "/day7":
            case "/day8":
            case "/day9":
            case "/day10":
            case "/day11":
            case "/day12":
            case "/day13":
            case "/day14":
            case "/day15":
            case "/day16":
            case "/day17":
            case "/day18":
            case "/day19":
            case "/day20":
            case "/day21":
            case "/day22":
            case "/day23":
            case "/day24":
            case "/day25":
            case "/day26":
            case "/day27":
            case "/day28":
            case "/day29":
            case "/day30":
            case "/day31":
                messageService.sendMessage(getChatId(update), SELECTION_OF_THE_HOUR,
                        inlineKeyboardSource.getKeyboardHour());
        }
    }
}
