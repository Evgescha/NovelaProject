package com.novelasgame.novelas.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.novelasgame.novelas.entity.Command;

@RunWith(SpringRunner.class)
@SpringBootTest
class CommandRepositoryTest {

    @Autowired
    CommandRepository repository;
    
    @Test
    void SaveAndGet() {
        Command cmd = new Command("th \"Получается, я ещё не самый ленивый и неаккуратный человек в мире – раз уж всего за одну смену в лагере можно развести такой бардак.\"");
        cmd.setId(999l);
        repository.save(cmd);
        
        boolean isExist =repository.existsById(1l);
        assertTrue(isExist);
      
    }

}
