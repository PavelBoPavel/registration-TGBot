package com.github.pavelbo.registrationbot.service;

import com.github.pavelbo.registrationbot.keyboard.InlineKeyboardSource;
import com.github.pavelbo.registrationbot.keyboard.ReplayKeyboardService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseProcessor {

    @Autowired
    MessageService messageService;
    @Autowired
    InlineKeyboardSource inlineKeyboardSource;
    @Autowired
    ReplayKeyboardService replayKeyboardService;
}
