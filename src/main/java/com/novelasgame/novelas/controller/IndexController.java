package com.novelasgame.novelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller("/")
public class IndexController {
    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/")
    private String init(Model model) {
        return "/index";
    }

}
