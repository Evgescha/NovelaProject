package com.novelasgame.novelas.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novelasgame.novelas.entity.Scene;

@Controller
@RequestMapping("/scene")
public class SceneController {
    private final String JPG = ".jpg";
    private final String SPLITTER = "/";

    @ResponseBody
    @GetMapping(value = "/get", produces = MediaType.IMAGE_JPEG_VALUE)
    private byte[] getScene(@ModelAttribute Scene scn) throws IOException {
        // if(!scn.getName().contains("null")&&!scn.getFolder("null")&&!scn.getStyle().get("background").contains("black"))
        BufferedImage img;
        if (scn.getName().contains("black")||scn.getName().contains("null")) {// && scn.getStyle().get("background").contains("black")) {
            img = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
            Graphics gr =  img.getGraphics();
            gr.setColor(Color.BLACK);
            gr.fillRect(0, 0, 300, 300);

        } else {
            img = ImageIO.read(new File("gameRes/summer/" + scn.getFolder() + SPLITTER + scn.getName() + JPG));
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ImageIO.write(img, "PNG", baos);
        byte[] bytes = baos.toByteArray();

        return bytes;
    }
}
