package com.novelasgame.novelas.entity;

import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.Data;

@Data
public class Scene {
    static Logger logger = Logger.getLogger(Scene.class.getName());
    private final String type = "scene";
    private String folder = "null";
    private String name = "null";
    private String style = "";

    public Scene(){}
    public Scene(String str) {
        logger.fine("Scene. Line constructor");
        logger.log(Level.FINE, "Arguments: ",str);
        String[] arr = str.split(" ");
        if (arr.length == 2) 
            style=arr[1];
        else {
            if (arr[2].contains("black")) {
                style=arr[2];
            } else {
                this.name = arr[2];
                this.folder = arr[1];
            }
        }
    }




}
