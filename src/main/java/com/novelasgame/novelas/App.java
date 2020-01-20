package com.novelasgame.novelas;

import java.util.Arrays;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.novelasgame.novelas.entity.Role;
import com.novelasgame.novelas.entity.User;
import com.novelasgame.novelas.service.CommandService;
import com.novelasgame.novelas.service.GameService;
import com.novelasgame.novelas.service.LabelService;
import com.novelasgame.novelas.service.RoleServiceImpl;
import com.novelasgame.novelas.service.UserServiceImpl;
import com.sun.tools.javac.code.Attribute.Array;

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

    
    
    private static UserServiceImpl userServiceImpl;
    private static RoleServiceImpl roleServiceImpl;
    
    @Autowired
    private UserServiceImpl userServiceImpl2;
    @Autowired
    private RoleServiceImpl roleServiceImpl2;
    
    

    @PostConstruct
    public void init() {
        this.gameService = this.gameService0;
        this.labelService = this.labelService0;
        this.commandService = this.commandService0;
        
        this.userServiceImpl = this.userServiceImpl2;
        this.roleServiceImpl = this.roleServiceImpl2;
    }

    public static void main(String[] args) {
        logger.info("Start application");
        SpringApplication.run(App.class, args);

        System.out.println("Hello World!");
        
        
        User user = userServiceImpl.findByLogin("FirstUser");
        Role role = roleServiceImpl.findByName("ROLE_ADMIN");
        System.out.println(role);
        user.getRoles().add(role);
        userServiceImpl.update(user);
        //        userServiceImpl.userRegistration(user);
        
        
        
        
        
        System.out.println("Users added");
    }
}
