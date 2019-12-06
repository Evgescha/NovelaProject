package com.novelasgame.novelas.entity;

import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.Data;

@Data
public class Sound {
    Logger logger = Logger.getLogger(Sound.class.getName());
    private final String type = "sound";
    private String folder;
    private String name;
    private int fade = 0;
    private boolean play = false;
    private boolean sound_loop = false;

    public Sound() {
    }

    public Sound(String str) {
        logger.fine("Sound. Line constructor");
        logger.log(Level.FINE, "Arguments: ",str);
        String[] arr = str.split(" ");
        // play
        if (arr[0].contains("play")) {
            if (arr[1].contains("music")) {
                logger.log(Level.FINE, "Parse play music");
                this.folder=arr[1];
                this.name=arr[2].split("\"")[1];
                if (arr.length>3) this.fade=Integer.parseInt( arr[4]);
                play=true;
                sound_loop=false;
            } else if (arr[1].contains("sound_loop")) {
                logger.log(Level.FINE, "Parse play sfx");
                this.folder="sfx";
                this.name=arr[2];
                play=true;
                sound_loop=true;
                fade=arr.length==5?Integer.parseInt( arr[4]):0;
            } else if (arr[1].contains("sound")) {
                logger.log(Level.FINE, "Parse play sound");
                this.folder="sfx";
                this.name=arr[2];
                play=true;
                sound_loop=false;
                fade=arr.length==5?Integer.parseInt( arr[4]):0;                
            } else if (arr[1].contains("ambience")) {
                logger.log(Level.FINE, "Parse play ambience");
                this.folder=arr[1];
                this.name=arr[2];
                play=true;
                sound_loop=false;
                fade=arr.length==5?Integer.parseInt( arr[4]):0;   
            }
            this.name=name.replace("ambience_", "").replace("sfx_", "");
        }
        // stop
        else {
            logger.log(Level.FINE, "Parse stop music");
            this.play=false;
            this.folder=arr[1];
            fade=arr.length==4?Integer.parseInt( arr[3]):0; 
        }

    }

    public boolean getPlay() {
        return play;
    }
    public boolean getSoundLoop() {
        return sound_loop;
    }
    public void setPlay(boolean play) {
        this.play = play;
    }
    public void setSoundLoop(boolean sound_loop) {
        this.sound_loop = sound_loop;
    }

}
