package com.github.pavelbo.registrationbot.constant;

import com.github.pavelbo.registrationbot.service.*;

public enum UpdateType {
    TEXT(new TextProcessor()),
    CONTACT(new ContactProcessor()),
    CALLBACK_MONTH(new CallbackAnotherProcessor()),
    CALLBACK_DAY(new CallbackAnotherProcessor()),
    CALLBACK_HOUR(new CallbackAnotherProcessor()),
    CALLBACK_ANOTHER(new CallbackAnotherProcessor()),
    DEFAULT(new DefaultProcessor());

    private final Processor processor;

    UpdateType(Processor processor) {
        this.processor = processor;
    }

    public Processor getProcessor() {
        return this.processor;
    }
}
