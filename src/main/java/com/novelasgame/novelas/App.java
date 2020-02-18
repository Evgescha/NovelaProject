package com.novelasgame.novelas;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.novelasgame.novelas.service.CommandService;
import com.novelasgame.novelas.service.GameService;
import com.novelasgame.novelas.service.LabelService;
import com.novelasgame.novelas.service.RoleServiceImpl;
import com.novelasgame.novelas.service.UserGameServiceImpl;
import com.novelasgame.novelas.service.UserServiceImpl;
import com.novelasgame.novelas.storage.StorageProperties;
import com.novelasgame.novelas.storage.StorageService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class App {
    static Logger logger = Logger.getLogger(App.class.getName());

    private static GameService gameService;
    private static LabelService labelService;
    private static CommandService commandService;
    private static RoleServiceImpl roleServiceImpl;
    private static UserServiceImpl userServiceImpl;
    private static UserGameServiceImpl userGameServiceImpl;

    @Autowired
    private GameService gameService0;
    @Autowired
    private LabelService labelService0;
    @Autowired
    private CommandService commandService0;
    @Autowired
    private RoleServiceImpl roleServiceImpl2;
    @Autowired
    private UserServiceImpl userServiceImpl2;
    @Autowired
    private UserGameServiceImpl userGameServiceImpl2;

    @PostConstruct
    public void init() {
        this.gameService = this.gameService0;
        this.labelService = this.labelService0;
        this.commandService = this.commandService0;
        
        this.roleServiceImpl = this.roleServiceImpl2;
        this.userServiceImpl = this.userServiceImpl2;
        this.userGameServiceImpl = this.userGameServiceImpl2;
        
    }

    public static void main(String[] args) {
        logger.info("Start application");
        SpringApplication.run(App.class, args);

        System.out.println("Hello World!");
                
    }
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
  
}
