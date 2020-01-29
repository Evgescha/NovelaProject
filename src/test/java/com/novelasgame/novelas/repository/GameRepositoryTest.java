package com.novelasgame.novelas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.novelasgame.novelas.entity.Game;
@RunWith(SpringRunner.class)
@SpringBootTest
class GameRepositoryTest {
    //инициализируем переменную нашего репозитория
    @Autowired
    GameRepository repository;
    // проверяем работу метода поиска сущности по имени
    @Test
    void findByName() {
        //ищем сущность Game, передав методу имя
        Game game = repository.findByNameIgnoreCase("summer");
        //проверяем, нашли ли мы сущность с нужным нам именем
        assertEquals(game.getName(), "summer");
    }

}
