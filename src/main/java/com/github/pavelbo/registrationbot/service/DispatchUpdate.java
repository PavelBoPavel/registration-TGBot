package com.github.pavelbo.registrationbot.service;

import com.github.pavelbo.registrationbot.util.UpdateTypeUtil;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class DispatchUpdate {

    public void choiceOfAnswer(Update update) {
        getProcessor(update).process(update);
        }

    private Processor getProcessor(Update update) {
        return UpdateTypeUtil.getType(update).getProcessor();
    }
}
