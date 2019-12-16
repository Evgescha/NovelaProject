package com.novelasgame.novelas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.novelasgame.novelas.entity.Game;
@RunWith(SpringRunner.class)
@SpringBootTest
class GameRepositoryTest {

    @Autowired
    GameRepository repository;
    @Test
    void findByName() {
        Game game = repository.findByName("summer");
        
        assertEquals(game.getName(), "summer");
    }

}
