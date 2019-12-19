package com.novelasgame.novelas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.novelasgame.novelas.entity.Sound;
@RunWith(SpringRunner.class)
@SpringBootTest
class SoundServiceTest {
    @Autowired
    SoundService soundService;
    
    @Test
    void getSoundPath() {
        Sound snd = new Sound("play music music_list[\"always_ready\"] fadein 1");
        String soundPath = soundService.getSoundPath(snd);
        assertEquals(soundPath, "gameResSound/summer/sound/music/always_ready.ogg");
        
    }

}
