package com.novelasgame.novelas.entity;

import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.Data;

@Data
public class Window {
    static Logger logger = Logger.getLogger(Window.class.getName());
    private final String type = "window";
    private boolean show = true;
    private String effect = "";

    public Window() {
    }

    public Window(String line) {
        logger.fine("Window. Line constructor");
        logger.log(Level.FINE, "Arguments: ",line);
        if (line.contains("show"))
            show = true;
        else
            show = false;
    }

}
