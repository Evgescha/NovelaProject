package com.novelasgame.novelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.novelasgame.novelas.entity.Sound;

@Controller
@RequestMapping("/sound")
public class SoundController {
    private final String SPLITTER="/";
    private final String OGG=".ogg";
    @GetMapping
    public String getSound(@ModelAttribute Sound sd) {
        String path="gameResSound/summer/sound/"+sd.getFolder()+SPLITTER+sd.getName()+OGG;
        return path;
        
    }
    
}
