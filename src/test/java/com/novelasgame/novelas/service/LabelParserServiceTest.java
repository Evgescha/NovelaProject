package com.novelasgame.novelas.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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
    
    @Autowired
    private LabelParserService lps;
    
    
    @Test
    void Parse() {
        lps.Parse("summer", "prologue");
        assertNotNull(lps.list);
    }
    
    @Test
    void getMenu() {
        lps.i=0;
        List<Command> commands = lps.commands;
        
        commands.add(new Command("menu:"));
        commands.add(new Command("    \"Да, я пойду с тобой\":"));
        commands.add(new Command("        \"Каждый раз так сложно решить, что же ответить.\""));
        commands.add(new Command("        \"Ведь это просто сон...\""));
        commands.add(new Command("    \"Нет, я останусь здесь\":"));
        commands.add(new Command("        scene bg black"));
        commands.add(new Command("        window hide"));
        commands.add(new Command("\"Каждый раз так сложно решить, что же ответить.\""));
        
        Menu menu = (Menu)lps.getMenu("menu:");
        assertNotNull(menu);
        assertEquals(menu.getItems().size(), 2);
        assertEquals(menu.getItems().get(0).getCommands().size(), 2);
    }
    
    @Test
    void getCommand() {
        Dialog dlg1 = (Dialog) lps.getCommand("\"И почему от ответа на этот вопрос зависит так много в моей жизни?\"");
        Dialog dlg2 = new Dialog("\"И почему от ответа на этот вопрос зависит так много в моей жизни?\"");
        assertNotNull(dlg1);
        assertEquals(dlg1, dlg2);
        
        
        Char chr1= (Char) lps.getCommand("show dv normal pioneer2 at center");
        Char chr2 = new Char("show dv normal pioneer2 at center");
        assertNotNull(chr1);
        assertEquals(chr1, chr2);
        
        
        
        Sound snd1 = (Sound) lps.getCommand("stop music fadeout 5");
        Sound snd2 = new Sound("stop music fadeout 5");
        assertNotNull(snd1);
        assertEquals(snd1, snd2);
        
    }
    @Test
    void getCommandNull() {
        Object obj = lps.getCommand("menu");
        assertNull(obj);
    }
    


}
