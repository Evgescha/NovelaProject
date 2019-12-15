package com.novelasgame.novelas.entity;

import java.util.ArrayList;
import java.util.logging.Logger;

import lombok.Data;

@Data
public class Menu {

    static Logger logger = Logger.getLogger(Menu.class.getName());
    private final String type = "menu";

    private ArrayList<MenuItem> items = new ArrayList<>();



}
