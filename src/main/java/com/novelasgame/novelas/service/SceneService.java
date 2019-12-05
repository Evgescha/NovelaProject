package com.novelasgame.novelas.service;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.novelasgame.novelas.entity.Scene;

@Service
public class SceneService {

    public byte[] getSceneByte(Scene scn) throws IOException {
        BufferedImage img;
        if (scn.getName().contains("black") || scn.getName().contains("null")) {
            img = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
            Graphics gr = img.getGraphics();
            gr.setColor(Color.BLACK);
            gr.fillRect(0, 0, 300, 300);

        } else {
            img = ImageIO.read(new File("gameRes/summer/" + scn.getFolder() + FormatVariables.SPLITTER + scn.getName()
                    + FormatVariables.JPG));
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ImageIO.write(img, "PNG", baos);
        byte[] bytes = baos.toByteArray();

        return bytes;
    }

}
