package com.github.pavelbo.registrationbot.keyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReplayKeyboardService {
    public ReplyKeyboardMarkup getReplayKeyboardMain() {
        ReplyKeyboardMarkup keyBoardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        row.add("Начать запись!");
        keyboard.add(row);
        row2.add("Описание");
        row2.add("Контакты");
        keyboard.add(row2);
        keyBoardMarkup.setKeyboard(keyboard);
        keyBoardMarkup.setResizeKeyboard(true);
        return keyBoardMarkup;
    }

    public ReplyKeyboardMarkup getContact() {
        ReplyKeyboardMarkup keyBoardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText("Отправить контакт!").setRequestContact(true);
        row.add(keyboardButton);
        keyboard.add(row);
        keyBoardMarkup.setKeyboard(keyboard);
        keyBoardMarkup.setResizeKeyboard(true);
        return keyBoardMarkup;
    }

    public ReplyKeyboardMarkup getYesOrNo() {
        ReplyKeyboardMarkup keyBoardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Подтвердить!");
        row.add("Отмена!");
        keyboard.add(row);
        keyBoardMarkup.setKeyboard(keyboard);
        keyBoardMarkup.setResizeKeyboard(true);
        return keyBoardMarkup;
    }
}
