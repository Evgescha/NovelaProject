package com.novelasgame.novelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novelasgame.novelas.entity.Sound;

@Controller
@RequestMapping("/sound")
public class SoundController {
    private final String SPLITTER="/";
    private final String OGG=".ogg";
    
    @GetMapping("/get")
    @ResponseBody
    public String getSound(@ModelAttribute Sound sd) {
        System.out.println("ПРИШЛО УВЕДОМЛЕНИЕ "+sd);
        String path="gameResSound/summer/sound/"+sd.getFolder()+SPLITTER+sd.getName()+OGG;
        return path;
    }
    @GetMapping()
    private String sound(Model model) {        
        return "/testSound";
    }
    
}
