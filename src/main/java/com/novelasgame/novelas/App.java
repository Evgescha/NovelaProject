package com.novelasgame.novelas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.novelasgame.novelas.entity.Command;
import com.novelasgame.novelas.entity.Game;
import com.novelasgame.novelas.entity.Label;
import com.novelasgame.novelas.service.CommandService;
import com.novelasgame.novelas.service.GameService;
import com.novelasgame.novelas.service.LabelService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {

    private static GameService gameService;

    private static LabelService labelService;

    private static CommandService commandService;

    @Autowired
    private GameService gameService0;
    @Autowired
    private LabelService labelService0;
    @Autowired
    private CommandService commandService0;

    static Logger logger = Logger.getLogger(App.class.getName());

    @PostConstruct
    public void init() {
        this.gameService = this.gameService0;
        this.labelService = this.labelService;
        this.commandService = this.commandService0;
    }

    public static void main(String[] args) {
        logger.info("Start application");
        SpringApplication.run(App.class, args);

        System.out.println("Hello World!");
    }
}
