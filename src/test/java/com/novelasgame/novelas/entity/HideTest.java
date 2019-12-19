package com.novelasgame.novelas.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
class HideTest {
private Hide hide;
    @Test
    void testHideString() {
        hide = new Hide("hide mt");
        assertEquals(hide.getName(), "mt");
    }

}
