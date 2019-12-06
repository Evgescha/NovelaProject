package com.novelasgame.novelas.entity;

import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.Data;

@Data
public class Hide {
    static Logger logger = Logger.getLogger(Hide.class.getName());
    private final String type = "hide";
    private String effect = "";
    private String name;
    
    public Hide() {
    }
    
    
    public Hide(String str) {
        logger.fine("Hide. Line constructor");
        logger.log(Level.FINE, "Arguments: ",str);
        name=str.split(" ")[1];
        logger.log(Level.FINE, "Name: ",name);
    }
    
 }
