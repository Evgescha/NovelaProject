package com.novelasgame.novelas.service;

import org.springframework.stereotype.Service;

import com.novelasgame.novelas.entity.Sound;

@Service
public class SoundService {

    public String getSoundPath(Sound sd) {
        System.out.println("ПРИШЛО УВЕДОМЛЕНИЕ "+sd);
        String path="gameResSound/summer/sound/"+sd.getFolder()+FormatVariables.SPLITTER+sd.getName()+FormatVariables.OGG;
        return path;
    }
    
}
