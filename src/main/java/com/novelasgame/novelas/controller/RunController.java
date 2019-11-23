package com.novelasgame.novelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/run")
public class RunController {
    @GetMapping
    private String two(Model model) {
        return "/run";
    }
}
