package com.novelasgame.novelas.entity;

import lombok.Data;

@Data
public class Window {
    private final String type = "window";
    private boolean show = true;
    private String effect = "";

    public Window() {
    }

    public Window(String line) {
        if (line.contains("show"))
            show = true;
        else
            show = false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
