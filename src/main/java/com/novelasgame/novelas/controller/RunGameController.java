package com.novelasgame.novelas.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.novelasgame.novelas.entity.Command;
import com.novelasgame.novelas.service.GameService;


@Controller("/runGame")
public class RunGameController {
    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    public GameService gameService;

    @GetMapping
    private String getRunScene(@RequestParam(value = "gameName", required = false) String gameName,Model model) throws IOException {
        
        
        
        List<Command> list = gameService.findByName(gameName).getLabels().get(0).getCommands();
        
        
       
        return "runGame";
    }

    private String toJson(Object temp) throws JsonProcessingException {
        return mapper.writeValueAsString(temp);
    }
}
