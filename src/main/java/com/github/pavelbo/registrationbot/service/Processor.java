package com.github.pavelbo.registrationbot.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Processor {
    void process(Update update);
}
