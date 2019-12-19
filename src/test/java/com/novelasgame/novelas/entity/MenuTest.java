package com.novelasgame.novelas.entity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
class MenuTest {

    private Menu menu;
    
    @Test
    void testMenu() {
        menu = new Menu();
        
        MenuItem mItem1 = new MenuItem("Shoose 1");
        Dialog dialog1 = new Dialog("\"Всё это время Славя стояла рядом со мной и, казалось, не находила в нашем разговоре ничего такого.\"");
        mItem1.getCommands().add(dialog1);
        menu.getItems().add(mItem1);
        
        
        MenuItem mItem2 = new MenuItem("Shoose 2");
        Dialog dialog2 = new Dialog("mt \"Ладненько, я побежала тогда, а ты пока можешь познакомиться с лагерем!{w} Вечером приходи на ужин, не забудь!\"");
        mItem2.getCommands().add(dialog2);
        Hide hide2 = new Hide("hide mt");
        mItem2.getCommands().add(hide2);
        menu.getItems().add(mItem2);
        
        ArrayList<Object> list = new ArrayList<>();
        list.add(mItem1);
        list.add(mItem2);
        
        assertArrayEquals(menu.getItems().toArray(), list.toArray());
        
    }

}
