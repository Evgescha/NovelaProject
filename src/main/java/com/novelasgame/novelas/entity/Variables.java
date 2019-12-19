package com.novelasgame.novelas.entity;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Variables {
    @JsonIgnore
    static Logger logger = Logger.getLogger(Variables.class.getName());
    private final String type = "variable";
    private String key;
    private String value;

    public Variables() {
    }

    public Variables(String str) {
        logger.fine("Variables. Line constructor");
        logger.log(Level.FINE, "Arguments: ", str);
        String arr[] = str.replace("$ ", "").split(" = ");
        key = arr[0];
        value = arr[1];
    }
}
