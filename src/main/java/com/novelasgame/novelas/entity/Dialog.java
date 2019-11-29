package com.novelasgame.novelas.entity;

import java.util.Arrays;

import lombok.Data;

@Data
public class Dialog {
    private  final String type="dialog";
    private String name;
    private String fullName;
    private String[] text;
    public Dialog() {}
    public Dialog(String str) {
        String[] arr=str.split(" \"");
        
        if (str.charAt(0) == '"') {
            text=str.replace("\"", "").split("<w>");
        }
        if (arr.length > 1) {
            name=arr[0];
            text=arr[1].replace("\"", "").split("<w>");
        }                    
    }
    
//  @Override
//  public String toString() {
//      return "type=" + type + "&name=" + name + "&fullName=" + fullName + "&text=" + Arrays.toString(text);
//  }
    

    public static void main(String[] args) {
        Dialog dlg;
        dlg=new Dialog("\"Я окончательно захлебнулся рыданиями и просто тихо лежал, изредка поскуливая.\"");
        System.out.println(dlg);
        dlg=new Dialog("\"Через несколько минут удалось всё-таки взять себя в руки.\"");
        System.out.println(dlg);
        dlg=new Dialog("th \"В конце концов, если бы меня хотели убить, зачем всё это?!\"");
        System.out.println(dlg);
        dlg=new Dialog("th \"На опыты тоже не похоже.\"");
        System.out.println(dlg);
    }
    @Override
    public String toString() {
        return "{\"type\":\"" + type + "\", \"name\":\"" + name + "\", \"fullName\":\"" + fullName + "\", \"text\":\""
                + Arrays.toString(text) + "\"}";
    }

}
