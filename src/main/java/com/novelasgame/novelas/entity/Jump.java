package com.novelasgame.novelas.entity;

import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
public class Jump {
    @JsonIgnore
    static Logger logger = Logger.getLogger(Jump.class.getName());
    private final String type = "jump";
    private String label;
    
    
    public Jump() {}
    public Jump(String cmd) {
        label=cmd.trim().split(" ")[1];
    }
}
