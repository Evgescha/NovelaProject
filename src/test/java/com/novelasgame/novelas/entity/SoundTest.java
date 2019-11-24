package com.novelasgame.novelas.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SoundTest {
    private Sound sd;
    @Test
    void testSoundMusic() {
        sd= new Sound("play music music_list[\"a_promise_from_distant_days_v2\"] fadein 3");
        assertEquals(sd.getFolder(), "music");
        assertEquals(sd.getName(), "a_promise_from_distant_days_v2");
        assertEquals(sd.getFade(), 3);
        assertTrue(sd.getPlay());
        assertFalse(sd.getSoundLoop());
    }
    @Test
    void testSoundSoundLoop() {
        sd= new Sound("play sound_loop sfx_bus_idle");
        assertEquals(sd.getFolder(), "sfx");
        assertEquals(sd.getName(), "sfx_bus_idle");
        assertEquals(sd.getFade(), 0);
        assertTrue(sd.getPlay());
        assertTrue(sd.getSoundLoop());
    }
    @Test
    void testSoundSoundLoopFade() {
        sd= new Sound("play sound_loop sfx_broom_sweep fadein 2");
        assertEquals(sd.getFolder(), "sfx");
        assertEquals(sd.getName(), "sfx_broom_sweep");
        assertEquals(sd.getFade(), 2);
        assertTrue(sd.getPlay());
        assertTrue(sd.getSoundLoop());
    }
    @Test
    void testSoundSound() {
        sd= new Sound("play sound sfx_intro_bus_stop_steps");
        assertEquals(sd.getFolder(), "sfx");
        assertEquals(sd.getName(), "sfx_intro_bus_stop_steps");
        assertEquals(sd.getFade(), 0);
        assertTrue(sd.getPlay());
        assertFalse(sd.getSoundLoop());
    }
    @Test
    void testSoundFade() {
        sd= new Sound("play sound sfx_bush_leaves fadein 0");
        assertEquals(sd.getFolder(), "sfx");
        assertEquals(sd.getName(), "sfx_bush_leaves");
        assertEquals(sd.getFade(), 0);
        assertTrue(sd.getPlay());
        assertFalse(sd.getSoundLoop());
    }
    @Test
    void testSoundAmbience() {
        sd= new Sound("play ambience ambience_camp_center_day");
        assertEquals(sd.getFolder(), "ambience");
        assertEquals(sd.getName(), "ambience_camp_center_day");
        assertEquals(sd.getFade(), 0);
        assertTrue(sd.getPlay());
        assertFalse(sd.getSoundLoop());
    }
    @Test
    void testSoundAmbienceFade() {
        sd= new Sound("play ambience ambience_cold_wind_loop fadein 3");
        assertEquals(sd.getFolder(), "ambience");
        assertEquals(sd.getName(), "ambience_cold_wind_loop");
        assertEquals(sd.getFade(), 3);
        assertTrue(sd.getPlay());
        assertFalse(sd.getSoundLoop());
    }
    @Test
    void testSoundStopMusic() {
        sd= new Sound("stop music fadeout 6");
        assertEquals(sd.getFolder(), "music");
        assertEquals(sd.getFade(), 6);
        assertFalse(sd.getPlay());
        assertFalse(sd.getSoundLoop());
    }
    @Test
    void testSoundStopSoundloop() {
        sd= new Sound("stop sound_loop");
        assertEquals(sd.getFolder(), "sound_loop");
        assertEquals(sd.getFade(), 0);
        assertFalse(sd.getPlay());
        assertFalse(sd.getSoundLoop());
    }
    @Test
    void testSoundStopSoundloopFade() {
        sd= new Sound("stop sound_loop fadeout 1");
        assertEquals(sd.getFolder(), "sound_loop");
        assertEquals(sd.getFade(), 1);
        assertFalse(sd.getPlay());
        assertFalse(sd.getSoundLoop());
    }
    @Test
    void testSoundStopAmbienceFade() {
        sd= new Sound("stop ambience fadeout 4");
        assertEquals(sd.getFolder(), "ambience");
        assertEquals(sd.getFade(), 4);
        assertFalse(sd.getPlay());
        assertFalse(sd.getSoundLoop());
    }

}
