package com.novelasgame.novelas.entity;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class CharTest {
    private Char chr;

    
    @Test
    void testCharSimple() {
        chr = new Char("show sl normal pioneer at right");
        assertEquals(chr.getName(), "sl");
        assertEquals(chr.getPosition(), "right");
        assertEquals(chr.getLocation(), "normal");
        assertEquals(chr.getEmotion(), "sl_1_normal");
        assertEquals(chr.getDress(), "sl_1_pioneer");
        assertEquals(chr.getThing(), "null");
        assertEquals(chr.getBehind(), "null");
        
    }
    @Test
    void testCharClose() {
         chr = new Char("show dv smile pioneer close at center");
         assertEquals(chr.getName(), "dv");
         assertEquals(chr.getPosition(), "center");
         assertEquals(chr.getLocation(), "close");
         assertEquals(chr.getEmotion(), "dv_4_smile");
         assertEquals(chr.getDress(), "dv_4_pioneer");
         assertEquals(chr.getThing(), "null");
         assertEquals(chr.getBehind(), "null");
    }
    @Test
    void testCharFar() {
         chr = new Char("show sl sad pioneer far at left");
         assertEquals(chr.getName(), "sl");
         assertEquals(chr.getPosition(), "left");
         assertEquals(chr.getLocation(), "far");
         assertEquals(chr.getEmotion(), "sl_3_sad");
         assertEquals(chr.getDress(), "sl_3_pioneer");
         assertEquals(chr.getThing(), "null");
         assertEquals(chr.getBehind(), "null");
    }
    @Test
    void testCharBehing() {
         chr = new Char("show el normal pioneer at cleft behind sl");
         assertEquals(chr.getName(), "el");
         assertEquals(chr.getPosition(), "cleft");
         assertEquals(chr.getLocation(), "normal");
         assertEquals(chr.getEmotion(), "el_1_normal");
         assertEquals(chr.getDress(), "el_1_pioneer");
         assertEquals(chr.getThing(), "null");
         assertEquals(chr.getBehind(), "sl");
    }
    @Test
    void testCharPanama() {
         chr = new Char("show mt smile panama pioneer at center");
         assertEquals(chr.getName(), "mt");
         assertEquals(chr.getPosition(), "center");
         assertEquals(chr.getLocation(), "normal");
         assertEquals(chr.getEmotion(), "mt_1_smile");
         assertEquals(chr.getDress(), "mt_1_pioneer");
         assertEquals(chr.getThing(), "mt_1_panama");
         assertEquals(chr.getBehind(), "null");
    }
    @Test
    void testCharPanamaFarCright() {
         chr = new Char("show mt normal panama pioneer far at cright");
         assertEquals(chr.getName(), "mt");
         assertEquals(chr.getPosition(), "cright");
         assertEquals(chr.getLocation(), "far");
         assertEquals(chr.getEmotion(), "mt_1_normal");
         assertEquals(chr.getDress(), "mt_1_pioneer");
         assertEquals(chr.getThing(), "mt_1_panama");
         assertEquals(chr.getBehind(), "null");
    }

}
