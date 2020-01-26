package com.novelasgame.novelas;

import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.novelasgame.novelas.entity.User;
import com.novelasgame.novelas.entity.UserGame;
import com.novelasgame.novelas.service.CommandService;
import com.novelasgame.novelas.service.GameService;
import com.novelasgame.novelas.service.LabelService;
import com.novelasgame.novelas.service.RoleServiceImpl;
import com.novelasgame.novelas.service.UserGameServiceImpl;
import com.novelasgame.novelas.service.UserServiceImpl;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
    static Logger logger = Logger.getLogger(App.class.getName());

    private static GameService gameService;

    private static LabelService labelService;

    private static CommandService commandService;

    @Autowired
    private GameService gameService0;
    @Autowired
    private LabelService labelService0;
    @Autowired
    private CommandService commandService0;

    
    
    private static RoleServiceImpl roleServiceImpl;
    private static UserServiceImpl userServiceImpl;
    private static UserGameServiceImpl userGameServiceImpl;
    
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
        
//        User user = userServiceImpl.findByUsername("3");
//        UserGame game = new UserGame();
//        game.setName("summer");
//        
//        HashMap<String,String> map = new HashMap();
//        map.put("first", "1");
//        map.put("second", "22");
//        map.put("third", "333");
//        game.setKeyVal(map);
//        userGameServiceImpl.create(game);
//        game.setUser(user);
//        
//        user.getUserGames().add(game);
//        userServiceImpl.update(user);
        
        
        
//        User user = new User();
//        user.setEmail("MyMail");
//        user.setUsername("2222");
//        user.setPassword("2222");
//        userServiceImpl.userRegistration(user);
//        System.out.println("Users added");
        
        
    }
}
