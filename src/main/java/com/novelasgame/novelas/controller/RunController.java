package com.novelasgame.novelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/run")
public class RunController {
    @GetMapping()
    private String init(Model model) {
        return "/run";
    }
}
