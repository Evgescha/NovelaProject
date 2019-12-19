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
    private String add="";

    public Variables() {
    }

    public Variables(String str) {
        logger.fine("Variables. Line constructor");
        logger.log(Level.FINE, "Arguments: ", str);
        String arr[] = str.replace("$ ", "").split(" = ");
        key = arr[0];

        if (str.contains("pause"))
            return;

        if (!arr[1].trim().contains(" "))
            value = arr[1].replace("\"", "");
        else {
            System.out.println(arr[1]);
            if (arr[1].contains(" + ")) {
                String arrr[] = arr[1].split(" ");
                System.out.println("0:" + arrr[0]);
                System.out.println("1:" + arrr[1]);
                System.out.println("2:" + arrr[2]);
                add = arrr[2];
            } else
            {
                String arrr[] = arr[1].split(" ");                
                add =arrr[2];
            }
        }
    }
}
