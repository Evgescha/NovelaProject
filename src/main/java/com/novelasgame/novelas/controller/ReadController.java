package com.novelasgame.novelas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novelasgame.novelas.entity.Command;
import com.novelasgame.novelas.service.GameService;

@Controller("/read")
public class ReadController {

    @Autowired
    GameService game; 
    
    @GetMapping()
    @ResponseBody
    public String getRead() {
        List<Command> cmds = game.findByName("summer").getLabels().get(0).getCommands();
        for(Command str:cmds)System.out.println(str.getValue());
        System.out.println(cmds.get(0).getValue().charAt(0));
        System.out.println(cmds.get(0).getValue().charAt(1));
        System.out.println(cmds.get(0).getValue().charAt(2));
        System.out.println(cmds.get(0).getValue().charAt(3));
        System.out.println(cmds.get(0).getValue().charAt(4));
        return "EEE";
    }
}
