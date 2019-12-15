package com.novelasgame.novelas.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DialogTest {

    private Dialog dlg;

    @Test
    void testDialogOnlySimpleDialog() {
        dlg = new Dialog("\"Мне опять снился сон.\"");
        assertEquals(dlg.getText()[0],"Мне опять снился сон.");
        assertEquals(dlg.getText().length, 1);
        assertEquals(dlg.getName(), "");
    }

    @Test
    void testDialogSimpleWithName() {
        dlg = new Dialog("dreamgirl \"Ты пойдёшь со мной?\"");
        assertEquals(dlg.getText()[0],"Ты пойдёшь со мной?");
        assertEquals(dlg.getText().length, 1);
        assertEquals(dlg.getName(), "dreamgirl");
    }

    @Test
    void testDialogMultiple() {
        dlg = new Dialog("\"Но вот картинка теряет чёткость...{w} Наверное, скоро просыпаться.\"");
        assertEquals(dlg.getText()[0],"Но вот картинка теряет чёткость...");
        assertEquals(dlg.getText().length, 2);
        assertEquals(dlg.getName(), "");
    }

    @Test
    void testDialogMultipleWithName() {
        dlg = new Dialog("th \"Как?..{w} Что?..{w} Я умер?..\"");
        assertEquals(dlg.getText()[2]," Я умер?..");
        assertEquals(dlg.getName(), "th");
        assertEquals(dlg.getText().length, 3);
    }

}
