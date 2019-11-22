package com.novelasgame.novelas.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/images")
public class SpriteController {

//http://localhost:8080/images/gamename?name=um&emotion=emotion&dresname=dress&thing1=thing1&thing2=thing2
    @ResponseBody
    @GetMapping(value = "/char", produces = MediaType.IMAGE_PNG_VALUE)
    private byte[] three(Model model, @RequestParam("name") String name,
            @RequestParam(value = "dresname") String dresname, @RequestParam("emotion") String emotionname,
            @RequestParam(value = "thing1", required = false) String thing1,
            @RequestParam(value = "thing2", required = false) String thing2
//     
    ) throws IOException {
        BufferedImage img1 = ImageIO.read(new File("gameRes/summer/char/" + name + "/body.png"));
        BufferedImage img2 = ImageIO.read(new File("gameRes/summer/char/" + name + "/" + dresname + ".png"));
        BufferedImage img3 = ImageIO.read(new File("gameRes/summer/char/" + name + "/" + emotionname + ".png"));
        System.out.println(name);
        System.out.println(thing1);
        System.out.println(thing2);
        BufferedImage img4 = null;
        BufferedImage img5 = null;
            
        BufferedImage im = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        im.getGraphics().drawImage(img1, 0, 0, null);
        im.getGraphics().drawImage(img2, 0, 0, null);
        im.getGraphics().drawImage(img3, 0, 0, null);
        if (thing1 != null) {
            im.getGraphics().drawImage(img4, 0, 0, null);
            img4 = ImageIO.read(new File("char/" + name + "/" + thing1 + ".png"));
        }
        if (thing2 != null) {
            im.getGraphics().drawImage(img5, 0, 0, null);
            img5 = ImageIO.read(new File("char/" + name + "/" + thing2 + ".png"));
        }

        // ImageIO.write(im,"png",new File("big.png"));

        // Save as new image
        ImageIO.write(im, "PNG", baos);
        byte[] bytes = baos.toByteArray();

        return bytes;
    }
}
