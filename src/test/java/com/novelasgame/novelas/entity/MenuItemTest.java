package com.novelasgame.novelas.entity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
class MenuItemTest {
    
    private MenuItem mItem;
    @Test
    void testMenuItem() {
        mItem = new MenuItem("Shoose 1");
        assertEquals(mItem.getChoose(), "Shoose 1");
        assertEquals(mItem.getCommands().size(), 0);
    }

    @Test
    void testGetCommands() {
        mItem = new MenuItem("Shoose 2");
        Dialog dialog = new Dialog("th \"Не имею ровным счётом никакого желания наряжаться в пионерские шортики и завязывать нелепый красный галстук!\"");
        mItem.getCommands().add(dialog);
        
        ArrayList<Object> list = new ArrayList<>();
        list.add(dialog);
        
        assertArrayEquals(mItem.getCommands().toArray(), list.toArray());
        
    }

}
