package com.novelasgame.novelas.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import lombok.Data;


@Data
public class Char {
    static Logger logger = Logger.getLogger(Char.class.getName());
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
        logger.fine("Char. Line constructor");
        logger.log(Level.FINE, "Arguments: ",line);
        
        line=line.trim();
        //часть имени до картинки, отвечающая за позу
        String namePrev="";
        //получаем эмоцию и имя
        String[] split = line.split(" ");
        this.name = split[1];
        this.emotion = split[2];
        
        logger.fine("Char. Find pose.");
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
        
        
        
        logger.fine("Char. Find behind.");
       //если персонаж стоит за кем-то, получаем имя впередистоящего, команду удаляем
        if (line.contains(" behind ")) {
            this.behind = line.substring(line.lastIndexOf(" ") + 1);
            line = line.substring(0, line.lastIndexOf(" behind "));
        }
        
        
        logger.fine("Char. Find position.");
        //получаем позицию по горизонтали экрана
        this.position = line.substring(line.lastIndexOf(" ") + 1);
        line = line.substring(0, line.lastIndexOf(" at "));

        
        
        logger.fine("Char. Find location.");
        //получаем дальность от экрана
        if (line.contains(" far") || line.contains(" close")) {
            this.location = line.substring(line.lastIndexOf(" ") + 1);
            line = line.substring(0, line.lastIndexOf(" "));
        }
        
        
        
        logger.fine("Char. Find dress.");
        //получаем польное название одежды
        this.dress = namePrev+line.substring(line.lastIndexOf(" ") + 1);
        line = line.substring(0, line.lastIndexOf(" "));
        
        
        
        logger.fine("Char. Find body.");
        //получаем голое тело
        this.body = namePrev+"body";
        
        
        
        logger.fine("Char. Find emotion.");
        //дополняем эмоцию полным названием
        split = line.split(" ");
        this.emotion = namePrev+split[2];
        
        
        
        logger.fine("Char. Find thing.");
        //если есть еще какая-то вещь(панама), указываем ссылку на ее картинку
        if (split.length > 3) {
            this.thing = namePrev+split[3];
        }

    }




}
