package com.novelasgame.novelas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.novelasgame.novelas.Parser;

@Controller
@RequestMapping("/testrun")
public class TestRunController {
    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping
    private String getScene(Model model) {
        ArrayList<Object> list = new ArrayList<>();
        list = Parser.getList();
        
        
        String temp="";
        try {
            temp = toJson(list);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("scenario", temp);
        System.out.println(temp);
        return "testRun";
    }

    private String toJson(Object temp) throws JsonProcessingException {
        return mapper.writeValueAsString(temp);
    }

}
