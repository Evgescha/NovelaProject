package com.novelasgame.novelas.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import lombok.Data;


//http://localhost:8080/images/char.png?type=char&name=sl&body=sl_1_body&dress=sl_1_pioneer&emotion=sl_1_normal&position=right&location=normal&behind=null&thing=null
@Data
public class Char {
    private final String type = "char";
    private String name;
    private String body;
    private String dress;
    private String emotion;
    // left, cleft, center, cright, right.
    private String position;
    // близко, далеко/ far/close
    private String location = "normal";
    // за спиной кого-то
    private String behind = "null";
    //с какой-то вещью в руках
    private String thing = "null";

    public Char() {};
    public Char(String line) {
        //часть имени до картинки, отвечающая за позу
        String namePrev="";
        //получаем эмоцию и имя
        String[] split = line.split(" ");
        this.name = split[1];
        this.emotion = split[2];
        
        // ищем позу по эмоции
        try (Stream<Path> paths = Files.walk(Paths.get("gameRes/summer/char/" + name + "/"))) {
            Path path = paths.filter(Files::isRegularFile).filter(file -> file.toString().contains(this.emotion + ".png"))
                    .findFirst().get();
            namePrev=path.getName(path.getNameCount()-1).toString();
            namePrev=namePrev.substring(0,namePrev.indexOf(emotion));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
       //если персонаж стоит за кем-то, получаем имя впередистоящего, команду удаляем
        if (line.contains(" behind ")) {
            this.behind = line.substring(line.lastIndexOf(" ") + 1);
            line = line.substring(0, line.lastIndexOf(" behind "));
        }
        //получаем позицию по горизонтали экрана
        this.position = line.substring(line.lastIndexOf(" ") + 1);
        line = line.substring(0, line.lastIndexOf(" at "));

        //получаем дальность от экрана
        if (line.contains(" far") || line.contains(" close")) {
            this.location = line.substring(line.lastIndexOf(" ") + 1);
            line = line.substring(0, line.lastIndexOf(" "));
        }
        //получаем польное название одежды
        this.dress = namePrev+line.substring(line.lastIndexOf(" ") + 1);
        line = line.substring(0, line.lastIndexOf(" "));
        //получаем голое тело
        this.body = namePrev+"body";
        //дополняем эмоцию полным названием
        split = line.split(" ");
        this.emotion = namePrev+split[2];
        //если есть еще какая-то вещь(панама), указываем ссылку на ее картинку
        if (split.length > 3) {
            this.thing = namePrev+split[3];
        }

    }

    public static void main(String[] args) {
        Char char1 = new Char("show sl normal pioneer at right");
        System.out.println(char1);
         char1 = new Char("show dv smile pioneer close at center");
        System.out.println(char1);
         char1 = new Char("show sl sad pioneer far at center");
        System.out.println(char1);
         char1 = new Char("show el normal pioneer at left behind sl");
        System.out.println(char1);
         char1 = new Char("show mt normal panama pioneer far at cright");
        System.out.println(char1);
    }
    @Override
    public String toString() {
        return "type=" + type + "&name=" + name + "&body=" + body + "&dress=" + dress + "&emotion=" + emotion
                + "&position=" + position + "&location=" + location + "&behind=" + behind + "&thing=" + thing;
    }

}
