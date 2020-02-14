package com.novelasgame.novelas.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping()
    public String getGameController(Model model, @RequestParam(name = "isCreate", required = false) String isCreate) {
        List<Game> games = gameService.findAll();
        if (!games.isEmpty())
            model.addAttribute("games", games);
        if (isCreate != null)
            model.addAttribute("notification", isCreate);
        return "addGame";
    }

    @PostMapping("/addGame")
    private String postGameController(@ModelAttribute Game game, RedirectAttributes ra, Principal principal) {
        System.out.println("gamSer:"+gameService);
        boolean isCreate = gameService.addGame(game, principal.getName());
        ra.addAttribute("notification", "Success added - " + isCreate);
        return "redirect:/games";
    }

    @GetMapping("/deleteGame")
//    @PreAuthorize("hasPermission(#gameId, hasRole('ROLE_ADMIN'))")
    private String getDeleteGame(@RequestParam(name = "gameId", required = true) long gameId, RedirectAttributes ra) {
        boolean delete = gameService.delete(gameId);
        ra.addAttribute("notification", "Success: " + delete);
        return "redirect:/games";
    }

}
