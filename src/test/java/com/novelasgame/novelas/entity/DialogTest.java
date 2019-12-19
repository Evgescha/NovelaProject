package com.novelasgame.novelas.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

// сам класс тестирования
class DialogTest {
    // создаем переменную для проверки работоспособности приложепия
    private Dialog dlg;

    // тестирования простого диалога диалога. На вход передаем лишь фразу
    @Test
    void testDialogOnlySimpleDialog() {
        dlg = new Dialog("\"Мне опять снился сон.\"");
        // проверяем, что конструктор разобрал фразу как простую, а не составную
        assertEquals(dlg.getText()[0], "Мне опять снился сон.");
        // проверяем, что был создан диалог с одной фразой
        assertEquals(dlg.getText().length, 1);
        // проверяем, что говорящему не было присвоено имя
        assertEquals(dlg.getName(), "");
    }

    // тестирование простого диалога с именем говорящего
    @Test
    void testDialogSimpleWithName() {
        // передаем на вход имя говорящего и фразу
        dlg = new Dialog("dreamgirl \"Ты пойдёшь со мной?\"");
        // проверяем, что фразу распознали верно
        assertEquals(dlg.getText()[0], "Ты пойдёшь со мной?");
        // проверяем, что фразу, переданную с именем, распознали как простую
        assertEquals(dlg.getText().length, 1);
        // проверяем, присвоили ли имя говорящему
        assertEquals(dlg.getName(), "dreamgirl");
    }

    // тестирование составной фразы без имени говорящего
    @Test
    void testDialogMultiple() {
        // передаем на вход составную фразу без имени говорящего
        dlg = new Dialog("\"Но вот картинка теряет чёткость...{w} Наверное, скоро просыпаться.\"");
        // проверяем, что фраза распозналась как составная
        assertEquals(dlg.getText().length, 2);
        // проверяем, правильно ли сложную фразу разбили на простую
        assertEquals(dlg.getText()[0], "Но вот картинка теряет чёткость...");
        // проверяем, не присвоилось ли имя говорящего, передавая составную фразу
        assertEquals(dlg.getName(), "");
    }

    // тестирование составной фразы с именем говорящего
    @Test
    void testDialogMultipleWithName() {
        // передаем на вход составную фразу с именем говорящего
        dlg = new Dialog("th \"Как?..{w} Что?..{w} Я умер?..\"");
        // проверяем, правильно ли сложную фразу разбили на простую
        assertEquals(dlg.getText()[2], " Я умер?..");
        // проверяем, присвоилось ли имя говорящего, передавая составную фразу
        assertEquals(dlg.getName(), "th");
        // проверяем, что фраза распозналась как составная
        assertEquals(dlg.getText().length, 3);
    }

}
