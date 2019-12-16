package com.novelasgame.novelas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.novelasgame.novelas.service.LabelParserService;

@Controller
@RequestMapping("/runGame")
public class RunGameController {
    @Autowired
    LabelParserService labelParserService;
    


    @GetMapping
    private String getRunScene(@RequestParam(value = "gameName", required = true) String gameName, Model model){
        
        ArrayList<Object> parse = labelParserService.Parse(gameName, gameName+"_prologue");
        model.addAttribute("scenario", labelParserService.toJson(parse));
        System.out.println("view scene runGame");
        return "runGame";
    }

}
