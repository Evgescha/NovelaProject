package com.novelasgame.novelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RunGameController {
//    @Autowired
//    LabelParserService labelParserService;


    @GetMapping("/runGame")
    private String getRunScene(@RequestParam(value = "gameName", required = false) String gameName, Model model){
        
//        labelParserService.Parse(gameName+"_init");
        System.out.println("view scene runGame");
        return "/runGame";
    }

}
