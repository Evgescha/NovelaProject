package com.novelasgame.novelas.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.novelasgame.novelas.entity.Char;

@RunWith(SpringRunner.class)
@SpringBootTest
class СharacterServiceTest {

    @Autowired
    @MockBean
    СharacterService characterService;
    
//    @Test
//    public void getImageByte(){
//        Char chr = new Char("show el normal pioneer at cleft");
//        byte[] imageByte = characterService.getImageByte(chr);
//        
//        
//        Mockito.verify(characterService,Mockito.times(1)).getImageByte(chr);
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        System.out.println(imageByte[0]);
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        assertNotNull(imageByte);    
//    }
    @Test
    public void getImageByteNull(){
        Char chr = new Char("show dvv smile pioneer close at center");
        byte[] imageByte = characterService.getImageByte(chr);
        
        assertNull(imageByte);    
    }

}
