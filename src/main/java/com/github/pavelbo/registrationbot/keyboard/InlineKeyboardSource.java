package com.github.pavelbo.registrationbot.keyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.github.pavelbo.registrationbot.constant.StringConstant.buttonText;
import static com.github.pavelbo.registrationbot.constant.StringConstant.buttonName;
import static com.github.pavelbo.registrationbot.constant.StringConstant.monthNames;

@Component
public class InlineKeyboardSource {
    public InlineKeyboardMarkup getKeyboardMain() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton descriptionButton = new InlineKeyboardButton()
                .setText("Описание")
                .setCallbackData("/description");
        InlineKeyboardButton contactButton = new InlineKeyboardButton()
                .setText("Контакты")
                .setCallbackData("/contact");

        List<InlineKeyboardButton> firstKeyboard = new ArrayList<>();
        firstKeyboard.add(descriptionButton);
        firstKeyboard.add(contactButton);

        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        keyboardRows.add(firstKeyboard);

        inlineKeyboardMarkup.setKeyboard(keyboardRows);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup getKeyboardMonth() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton firstButton = new InlineKeyboardButton()
                .setText(monthNames[Calendar.getInstance().get(Calendar.MONTH)])
                .setCallbackData("/month1");
        InlineKeyboardButton secondButton = new InlineKeyboardButton()
                .setText(monthNames[Calendar.getInstance().get(Calendar.MONTH) + 1])
                .setCallbackData("/month2");

        List<InlineKeyboardButton> firstKeyboard = new ArrayList<>();
        firstKeyboard.add(firstButton);
        firstKeyboard.add(secondButton);

        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        keyboardRows.add(firstKeyboard);

        inlineKeyboardMarkup.setKeyboard(keyboardRows);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup getKeyboardHour() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        InlineKeyboardButton[] buttons = new InlineKeyboardButton[buttonName.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new InlineKeyboardButton();
            buttons[i].setText(buttonText[i] + i).setCallbackData(buttonName[i]);
            List<InlineKeyboardButton> keyboard = new ArrayList<>();
            keyboard.add(buttons[i]);
            keyboardRows.add(keyboard);
        }

        inlineKeyboardMarkup.setKeyboard(keyboardRows);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup getKeyboardDay(int countDays) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        createKeyboardRows(countDays, keyboardRows);
        inlineKeyboardMarkup.setKeyboard(keyboardRows);
        return inlineKeyboardMarkup;
    }

    private void createKeyboardRows(int countDays, List<List<InlineKeyboardButton>> keyboardRows) {
        for(int j = 0; j < 7; j++) {
            List<InlineKeyboardButton> keyboardRow = new ArrayList<>();
            for (int i = 1; i <= countDays; i++) {
                if (i < 6) {
                    addButtonInKeyboardRow(keyboardRow, i);
                    if (i == 5){
                        keyboardRows.add(keyboardRow);
                    }
                } else if (i < 11) {
                    addButtonInKeyboardRow(keyboardRow, i);
                    if (i == 10) {
                        keyboardRows.add(keyboardRow);
                    }
                } else if (i < 16) {
                    addButtonInKeyboardRow(keyboardRow, i);
                    if (i == 15){
                        keyboardRows.add(keyboardRow);
                    }
                } else if (i < 21) {
                    addButtonInKeyboardRow(keyboardRow, i);
                    if (i == 20){
                        keyboardRows.add(keyboardRow);
                    }
                } else if (i < 26) {
                    addButtonInKeyboardRow(keyboardRow, i);
                    if (i == 25){
                        keyboardRows.add(keyboardRow);
                    }
                } else if (i < 31) {
                    addButtonInKeyboardRow(keyboardRow, i);
                    if (i == 30){
                        keyboardRows.add(keyboardRow);
                    }
                } else {
                    addButtonInKeyboardRow(keyboardRow, i);
                    keyboardRows.add(keyboardRow);
                }
            }
        }
    }

    private void addButtonInKeyboardRow(List<InlineKeyboardButton> keyboard, int i) {
        keyboard.add(new InlineKeyboardButton().setText(String.valueOf(i))
                .setCallbackData("/day" + i));
    }
}
