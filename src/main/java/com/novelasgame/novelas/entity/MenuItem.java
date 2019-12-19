package com.novelasgame.novelas.entity;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
public class MenuItem {
    @JsonIgnore
    static Logger logger = Logger.getLogger(MenuItem.class.getName());
    private final String type = "menuItem";
    
    private String choose;
    private ArrayList<Object> commands = new ArrayList<>();
    
    
    public MenuItem(String choose) {
        this.choose = choose.replace("\"", "").replace(":", "");
    }
    
}
