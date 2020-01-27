package com.novelasgame.novelas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novelasgame.novelas.entity.Game;
import com.novelasgame.novelas.service.GameService;

@Controller
@RequestMapping("/addGame")
public class addGameController {

    @Autowired
    GameService gameService;

    @GetMapping
    public String getGameController(Model model, @RequestParam(name = "isCreate", required = false) String isCreate) {
        List<Game> games = gameService.findAll();
        if (!games.isEmpty())
            model.addAttribute("games", games);
        if (isCreate != null)
            model.addAttribute("isCreate", isCreate);
        return "addGame";
    }

    @PostMapping()
    private String postGameController(@ModelAttribute Game game, RedirectAttributes ra) {
        boolean isCreate = gameService.create(game);
        ra.addAttribute("isCreate", "Success added - " + isCreate);
        return "redirect:/addGame";
    }

}
