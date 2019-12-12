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
        Command cmd = new Command();
        cmd.setValue("NEW COMMAND");
        Game game = gameService.read(1l);
        game.getLabels().get(0).getCommands().add(cmd);
        gameService.update(game);
        // Command command = new Command();
        // Label label = new Label();
        // Game game = new Game();
        // game.setName("TEST GAME");
        // command.setValue("TEST COMMAND VALUE");
        // List<Command> cmds = new ArrayList<>();
        // List<Label> lbls = new ArrayList<>();
        // cmds.add(command);
        // label.setName("TEST NAME");
        // label.setCommands(cmds);
        // lbls.add(label);
        // game.setLabels(lbls);
        // gameService.create(game);

        System.out.println("Hello World!");
    }
}
