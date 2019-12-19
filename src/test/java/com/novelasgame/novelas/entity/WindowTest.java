package com.novelasgame.novelas.entity;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
class WindowTest {
    private Window wndw;
    
    @Test
    void testWindowStringShow() {
      wndw = new Window("window show");
      assertTrue(wndw.isShow());
    }
    @Test
    void testWindowStringHide() {
      wndw = new Window("window hide");
      assertFalse(wndw.isShow());
    }

}
