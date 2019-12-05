package com.novelasgame.novelas.entity;

import lombok.Data;

@Data
public class Sound {
    private final String type = "sound";
    private String folder;
    private String name;
    private int fade = 0;
    private boolean play = false;
    private boolean sound_loop = false;

    public Sound() {
    }

    public Sound(String str) {
        String[] arr = str.split(" ");
        // play
        if (arr[0].contains("play")) {
            if (arr[1].contains("music")) {
                this.folder=arr[1];
                this.name=arr[2].split("\"")[1];
                if (arr.length>3) this.fade=Integer.parseInt( arr[4]);
                play=true;
                sound_loop=false;
            } else if (arr[1].contains("sound_loop")) {
                this.folder="sfx";
                this.name=arr[2];
                play=true;
                sound_loop=true;
                fade=arr.length==5?Integer.parseInt( arr[4]):0;
            } else if (arr[1].contains("sound")) {
                this.folder="sfx";
                this.name=arr[2];
                play=true;
                sound_loop=false;
                fade=arr.length==5?Integer.parseInt( arr[4]):0;                
            } else if (arr[1].contains("ambience")) {
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
            this.play=false;
            this.folder=arr[1];
            fade=arr.length==4?Integer.parseInt( arr[3]):0; 
        }

    }

    public static void main(String[] args) {
       Sound sd;
       sd= new Sound("play music music_list[\"a_promise_from_distant_days\"]");
       System.out.println(sd);
       sd= new Sound("play sound_loop sfx_bus_idle");
       System.out.println(sd);
       sd= new Sound("play sound_loop sfx_broom_sweep fadein 2");
       System.out.println(sd);
       sd= new Sound("play sound sfx_intro_bus_stop_steps");
       System.out.println(sd);
       sd= new Sound("play sound sfx_bush_leaves fadein 0");
       System.out.println(sd);
       sd= new Sound("play ambience ambience_camp_center_day");
       System.out.println(sd);
       sd= new Sound("play ambience ambience_cold_wind_loop fadein 3");
       System.out.println(sd);
       sd= new Sound("stop music fadeout 6");
       System.out.println(sd);
       sd= new Sound("stop sound_loop");
       System.out.println(sd);
       sd= new Sound("stop sound_loop fadeout 1");
       System.out.println(sd);
       sd= new Sound("stop ambience fadeout 4");
       System.out.println(sd);

    }

    @Override
    public String toString() {
        return "type=" + type + "&folder=" + folder + "&name=" + name + "&fade=" + fade + "&play=" + play
                + "&sound_loop=" + sound_loop;
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
