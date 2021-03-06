package com.novelasgame.novelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.novelasgame.novelas.entity.Scenario;
import com.novelasgame.novelas.service.ScenarioService;

@Controller
@RequestMapping("/addScenario")
public class AddScenarioController {
    
    @Autowired
    ScenarioService scenarioService;

    @GetMapping()
    private String getAddScenario() {
        System.out.println("View add scene");
        return "addScenario";
    }

    @PostMapping()
    private void setScenario(@ModelAttribute Scenario scenario) {
        scenarioService.saveScenario(scenario);
    }
}
