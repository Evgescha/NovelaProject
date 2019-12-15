package com.novelasgame.novelas.entity;

import java.util.ArrayList;
import java.util.logging.Logger;

import lombok.Data;


@Data
public class MenuItem {
    static Logger logger = Logger.getLogger(MenuItem.class.getName());
    private final String type = "menuItem";
    
    private String choose;
    private ArrayList<Object> commands = new ArrayList<>();
    public MenuItem(String choose) {
        this.choose = choose;
    }
    
}
