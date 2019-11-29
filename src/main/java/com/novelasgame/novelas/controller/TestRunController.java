package com.novelasgame.novelas.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.novelasgame.novelas.entity.Dialog;

@Controller
@RequestMapping("/testrun")
public class TestRunController {
    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping
    private String getScene(Model model) throws IOException {
        
        ArrayList<String> list= new ArrayList<>();
        list.add(new Dialog("dreamgirl \"Ты пойдёшь со мной?\"").toString());
        list.add(new Dialog("\"Пойду?..\"").toString());
        list.add(new Dialog("\"Но куда?\"").toString());
        list.add(new Dialog("\"И зачем?..\"").toString());
        list.add(new Dialog("\"Но это – всего лишь сон.{w} Тот самый, который я вижу каждую ночь.\"").toString());
        list.add(new Dialog("\"Но вот картинка теряет чёткость...{w} Наверное, скоро просыпаться.\"").toString());
        String temp= mapper.writeValueAsString(list);
        System.out.println(temp);
        model.addAttribute("scenario", temp);
        return "testRun";
    }
}
