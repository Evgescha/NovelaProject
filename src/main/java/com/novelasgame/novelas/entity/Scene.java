package com.novelasgame.novelas.entity;

import java.util.HashMap;

import lombok.Data;

@Data
public class Scene {
    private final String type = "scene";
    private String folder = "null";
    private String name = "null";
//    private HashMap<String, String> style = new HashMap<>();

    public Scene(){}
    public Scene(String str) {
        String[] arr = str.split(" ");
        if (arr.length == 2) {}
//            style.put("background", arr[1]);
        else {
            if (arr[2] != "black") {
                this.folder = arr[1];
                this.name = arr[2];
            } else {
//                style.put("background", arr[2]);
            }
        }
    }
    public static void main(String[] args) {
        
        Scene sc;
        sc = new Scene("scene black");
        System.out.println(sc.toString());
        sc = new Scene("scene bg black");
        System.out.println(sc.toString());
        sc = new Scene("scene bg ext_road_day");
        System.out.println(sc.toString());
        sc = new Scene("scene bg ext_houses_day");
        System.out.println(sc.toString());
        sc = new Scene("scene cg d1_rena_sunset");
        System.out.println(sc.toString());
        sc = new Scene("scene cg d1_grasshopper");
        System.out.println(sc.toString());
        sc = new Scene("scene anim intro_16");
        System.out.println(sc.toString());
        sc = new Scene("scene anim intro_15");
        System.out.println(sc.toString());
        sc = new Scene("scene anim prolog_1");
        System.out.println(sc.toString());
    }

    @Override
    public String toString() {
        return "type=" + type + "&folder=" + folder + "&name=" + name;// + "&style=" + style;
    }

}
