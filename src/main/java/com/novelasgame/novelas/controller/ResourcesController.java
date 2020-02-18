package com.novelasgame.novelas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.novelasgame.novelas.entity.Game;
import com.novelasgame.novelas.entity.ResourceItem;
import com.novelasgame.novelas.service.GameService;
import com.novelasgame.novelas.service.ResourcesItemService;

@Controller
@RequestMapping("/resources")
public class ResourcesController {

    @Autowired
    GameService gameService;
    @Autowired
    ResourcesItemService resourcesItemService;
    
    @GetMapping
    public void getResourcesPage(Model model) {
        List<Game> findAll = gameService.findAll();
        model.addAttribute("games", findAll);
    }
}
