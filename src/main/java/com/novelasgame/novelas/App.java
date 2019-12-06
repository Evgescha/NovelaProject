package com.novelasgame.novelas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.*;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    static Logger logger = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        logger.info("Start application");
        SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );
    }
}
