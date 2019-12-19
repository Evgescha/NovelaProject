package com.novelasgame.novelas.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.novelasgame.novelas.entity.Char;
import com.novelasgame.novelas.entity.Command;
import com.novelasgame.novelas.entity.Dialog;
import com.novelasgame.novelas.entity.Menu;
import com.novelasgame.novelas.entity.Sound;

@RunWith(SpringRunner.class)
@SpringBootTest
class LabelParserServiceTest {
    // инициализируем переменную сервиса
    @Autowired
    private LabelParserService lps;

    // проверяем работу парсера
    @Test
    void Parse() {
        // передаем на вход парсера имя игры и имя метки, которую нужно спарсить
        lps.Parse("summer", "prologue");
        // если парсинг прошел успешно, лист комманд не будет путым, что мы и проверяем
        assertNotNull(lps.list);
    }

    // тестируем работу получения сущности меню
    @Test
    void getMenu() {
        // обнуляем комманды
        lps.i = 0;
        List<Command> commands = lps.commands;
        // передаем комманды, как если бы нужно было создать меню
        commands.add(new Command("menu:"));
        commands.add(new Command("    \"Да, я пойду с тобой\":"));
        commands.add(new Command("        \"Каждый раз так сложно решить, что же ответить.\""));
        commands.add(new Command("        \"Ведь это просто сон...\""));
        commands.add(new Command("    \"Нет, я останусь здесь\":"));
        commands.add(new Command("        scene bg black"));
        commands.add(new Command("        window hide"));
        commands.add(new Command("\"Каждый раз так сложно решить, что же ответить.\""));
        // запускаем проверяемый метод
        Menu menu = (Menu) lps.getMenu("menu:");
        // проверяем: если метод корректно отработал, возвращаемое значение не должно
        // быть нулевым
        assertNotNull(menu);
        // проверяем: если метод правильно отработал, у него должно быть 2 варианта
        // выбора
        assertEquals(menu.getItems().size(), 2);
        // проверяем: если метод правильно отработал, после первого варианта выбора
        // нужно будет отработать 2 команды
        assertEquals(menu.getItems().get(0).getCommands().size(), 2);
    }

    // тестирвание метода получение комманд
    // поскольку метод возвращает различные сущности, проверим на трех вариантах:
    // диалог, персонаж, звук
    @Test
    void getCommand() {
        // создаем сущность диалога через проверяемый метод
        Dialog dlg1 = (Dialog) lps.getCommand("\"И почему от ответа на этот вопрос зависит так много в моей жизни?\"");
        // и вручную
        Dialog dlg2 = new Dialog("\"И почему от ответа на этот вопрос зависит так много в моей жизни?\"");
        // проверяем, возвращает ли метод ненулевое значение
        assertNotNull(dlg1);
        // и сравниваем сущности созданные вручную и через метод
        assertEquals(dlg1, dlg2);

        // создаем сущность персонажа через проверяемый метод
        Char chr1 = (Char) lps.getCommand("show dv normal pioneer2 at center");
        // и вручную
        Char chr2 = new Char("show dv normal pioneer2 at center");
        // проверяем, возвращает ли метод ненулевое значение
        assertNotNull(chr1);
        // и сравниваем сущности созданные вручную и через метод
        assertEquals(chr1, chr2);

        // создаем сущность звука через проверяемый метод
        Sound snd1 = (Sound) lps.getCommand("stop music fadeout 5");
        // и вручную
        Sound snd2 = new Sound("stop music fadeout 5");
        // проверяем, возвращает ли метод ненулевое значение
        assertNotNull(snd1);
        // и сравниваем сущности созданные вручную и через метод
        assertEquals(snd1, snd2);

    }

    // тестируем метод на врзврат нулевого значения
    @Test
    void getCommandNull() {
        // создаем объект по некорректной команде
        Object obj = lps.getCommand("menu");
        // проверяем, что нам вернуло нудевое значение
        assertNull(obj);
    }

}
