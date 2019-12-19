package com.novelasgame.novelas.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.novelasgame.novelas.entity.Scene;
@RunWith(SpringRunner.class)
@SpringBootTest
class SceneServiceTest {

    
    @Autowired
    SceneService sceneService;
    @Test
    void getSceneByte() {
        Scene scn = new Scene("scene bg ext_house_of_dv_day");
        byte[] sceneByte = sceneService.getSceneByte(scn);
        assertNotNull(sceneByte);
    }
    
    @Test
    void getSceneByteNull() {
        Scene scn = new Scene("scene bg1 ext_house_of_dv_day2");
        byte[] sceneByte = sceneService.getSceneByte(scn);
        assertNull(sceneByte);
    }

}
