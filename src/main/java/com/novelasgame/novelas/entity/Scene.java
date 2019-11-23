package com.novelasgame.novelas.entity;

import java.util.HashMap;

import com.acme.novela.Showable;

import lombok.Data;

@Data
public class Scene implements Showable {
    private final String type = "scene";
    private String path;
    private HashMap<String, String> style;

    public Scene(String path) {
        super();
        this.path = path.replace("\"", "").concat(".jpg");
    }

    public Scene(String path, HashMap<String, String> style) {
        super();
        this.path = path.concat(".jpg");
        this.style = style;
    }

}
