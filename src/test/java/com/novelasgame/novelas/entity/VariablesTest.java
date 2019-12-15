package com.novelasgame.novelas.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VariablesTest {
    private Variables vrbl;
    @Test
    void testVariablesInt() {
        vrbl = new Variables("$ day2_map_necessary_done = 0");
        assertEquals(vrbl.getKey(), "day2_map_necessary_done");
        assertEquals(Integer.parseInt(vrbl.getValue()), 0);
    }
    
    @Test
    void testVariablesBoolean() {
        vrbl = new Variables("$ d2_gave_keys = False");
        assertEquals(vrbl.getKey(), "d2_gave_keys");
        assertFalse(Boolean.parseBoolean(vrbl.getValue()));
    }

}
