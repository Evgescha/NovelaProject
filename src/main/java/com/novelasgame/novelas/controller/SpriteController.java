package com.novelasgame.novelas.controller;

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

import com.novelasgame.novelas.entity.Char;

@Controller
@RequestMapping("/images")
public class SpriteController {
    private final String PNG=".png";
    private final String SPLITTER="/";
    //http://localhost:8080/images/char?type=char&body=dv_1_body&name=dv&emotion=dv_1_scared&dress=dv_1_pioneer2&position=right&location=normal&behind=null&thing=null
    @ResponseBody
    @GetMapping(value = "/char.png", produces = MediaType.IMAGE_PNG_VALUE)
    private byte[] getChar(@ModelAttribute Char chr) throws IOException {
        
    
        BufferedImage img1 = ImageIO.read(new File("gameRes/summer/char/" + chr.getName() + SPLITTER + chr.getBody()+PNG));
        BufferedImage img2 = ImageIO.read(new File("gameRes/summer/char/" + chr.getName() + SPLITTER + chr.getDress()+PNG));
        BufferedImage img3 = ImageIO.read(new File("gameRes/summer/char/" + chr.getName() + SPLITTER + chr.getEmotion()+PNG));
        
        BufferedImage img4 = null;
        
            
        BufferedImage im = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        im.getGraphics().drawImage(img1, 0, 0, null);
        im.getGraphics().drawImage(img2, 0, 0, null);
        im.getGraphics().drawImage(img3, 0, 0, null);
        
        if (!chr.getThing().contains("null")) {
            img4 = ImageIO.read(new File("gameRes/summer/char/" + chr.getName() + SPLITTER + chr.getThing()+PNG));
            im.getGraphics().drawImage(img4, 0, 0, null);
        }

        // Save as new image
//        String name = System.currentTimeMillis()+""; 
        ImageIO.write(im, "PNG", baos);
        byte[] bytes = baos.toByteArray();

        return bytes;
    }
}






/*
    @ResponseBody
    @GetMapping(value = "/char", produces = MediaType.IMAGE_PNG_VALUE)
    private byte[] three(Model model, 
            @RequestParam("name") String name,
            @RequestParam("emotion") String emotion,
            @RequestParam("dres") String dres,
            @RequestParam("position") String position,
            @RequestParam("location") String location,
            @RequestParam(value = "behind", required = false) String behind,
            @RequestParam(value = "thing", required = false) String thing
*/
