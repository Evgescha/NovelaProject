package com.novelasgame.novelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.novelasgame.novelas.service.LabelParserService;

@Controller
@RequestMapping("/runGame")
public class RunGameController {
    @Autowired
    LabelParserService labelParserService;


    @GetMapping
    private String getRunScene(@RequestParam(value = "gameName", required = false) String gameName, Model model){
        
        labelParserService.Parse(gameName+"_init");
        System.out.println("view scene runGame");
        return "runGame";
    }
    
//    @GetMapping()
//    private String oneGet(Model model) {     
//        System.out.println("view index scene");
//        return "runGame";
//    }

}
