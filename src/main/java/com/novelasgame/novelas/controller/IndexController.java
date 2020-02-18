package com.novelasgame.novelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/")
public class IndexController {
    @GetMapping()
    private String one(Model model) {     
        System.out.println("view index scene");
        return "index";
    }
}
