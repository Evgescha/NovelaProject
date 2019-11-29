package com.novelasgame.novelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novelasgame.novelas.entity.Sound;
import com.novelasgame.novelas.service.SoundService;

@Controller
@RequestMapping("/sound")
public class SoundController {
    
    @Autowired
    SoundService soundService;
   
    
    @GetMapping("/get")
    @ResponseBody
    public String getSound(@ModelAttribute Sound sd) {
       return soundService.getSoundPath(sd);
    }
    @GetMapping()
    private String sound(Model model) {        
        return "/testSound";
    }
    
}
