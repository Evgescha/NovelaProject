package com.novelasgame.novelas.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
class SceneTest {
    private Scene scene;

    @Test
    void SceneBlac() {
        scene = new Scene("scene black");
        assertEquals(scene.getFolder(), "null");
        assertEquals(scene.getName(), "null");
        assertEquals(scene.getStyle(), "black");
    }

    @Test
    void SceneBgBlack() {
        scene = new Scene("scene bg black");
        assertEquals(scene.getFolder(), "null");
        assertEquals(scene.getName(), "null");
        assertEquals(scene.getStyle(), "black");       
    }

    @Test
    void SceneBg() {
        scene = new Scene("scene bg ext_road_day");
        assertEquals(scene.getFolder(), "bg");
        assertEquals(scene.getName(), "ext_road_day");
        assertEquals(scene.getStyle(), "");
    }

    @Test
    void SceneCg() {
        scene = new Scene("scene cg d1_rena_sunset");
        assertEquals(scene.getFolder(), "cg");
        assertEquals(scene.getName(), "d1_rena_sunset");
        assertEquals(scene.getStyle(), "");       
    }

    @Test
    void SceneAmin() {
        scene = new Scene("scene anim intro_15");
        assertEquals(scene.getFolder(), "anim");
        assertEquals(scene.getName(), "intro_15");
        assertEquals(scene.getStyle(), "");      
    }

}
