package com.novelasgame.novelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.novelasgame.novelas.entity.Sound;

@Controller
@RequestMapping("/sound")
public class SoundController {
    
    public String getSound(@ModelAttribute Sound sd) {
        String path="";
        
        return "";
        
    }
    
}
