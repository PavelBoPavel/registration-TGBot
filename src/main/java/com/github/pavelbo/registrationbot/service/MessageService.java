package com.github.pavelbo.registrationbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageService {

    @Autowired
    TelegramBot telegramBot;

    public void sendMessage(Long actualChatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(actualChatId).setText(message);
        getRemoveKeyboard();
        executeSendMessage(sendMessage);
    }

    public void sendMessage(Long actualChatId, String message, ReplyKeyboard inlineKeyboard) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(actualChatId).setText(message).setReplyMarkup(inlineKeyboard);
        getRemoveKeyboard();
        executeSendMessage(sendMessage);
    }

    public void sendMessage(Long actualChatId, String message, ReplyKeyboard inlineKeyboard, ReplyKeyboard replyKeyboard) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(actualChatId).setText(message).setReplyMarkup(inlineKeyboard).setReplyMarkup(replyKeyboard);
        getRemoveKeyboard();
        executeSendMessage(sendMessage);
    }

    private void getRemoveKeyboard() {
        ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
        replyKeyboardRemove.getRemoveKeyboard();
    }

    private void executeSendMessage(SendMessage sendMessage) {
        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
