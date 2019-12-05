package com.novelasgame.novelas.entity;

import lombok.Data;

@Data
public class Hide {
    private final String type = "hide";
    private String effect = "";
    private String name;
    
    public Hide() {
    }
    
    
    public Hide(String str) {
        name=str.split(" ")[1];
    }
    
 }
