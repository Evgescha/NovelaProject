package com.novelasgame.novelas.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.novelasgame.novelas.entity.Char;

@Service
public class СharacterService {

    public byte[] getImageByte(Char chr) {
        try {
            BufferedImage img1 = ImageIO.read(new File("gameRes/summer/char/" + chr.getName() + FormatVariables.SPLITTER
                    + chr.getBody() + FormatVariables.PNG));
            BufferedImage img2 = ImageIO.read(new File("gameRes/summer/char/" + chr.getName() + FormatVariables.SPLITTER
                    + chr.getDress() + FormatVariables.PNG));
            BufferedImage img3 = ImageIO.read(new File("gameRes/summer/char/" + chr.getName() + FormatVariables.SPLITTER
                    + chr.getEmotion() + FormatVariables.PNG));

            BufferedImage img4 = null;

            BufferedImage im = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            im.getGraphics().drawImage(img1, 0, 0, null);
            im.getGraphics().drawImage(img2, 0, 0, null);
            im.getGraphics().drawImage(img3, 0, 0, null);

            if (!chr.getThing().contains("null")) {
                img4 = ImageIO.read(new File("gameRes/summer/char/" + chr.getName() + FormatVariables.SPLITTER
                        + chr.getThing() + FormatVariables.PNG));
                im.getGraphics().drawImage(img4, 0, 0, null);
            }

            // Save as new image
            // String name = System.currentTimeMillis()+"";
            ImageIO.write(im, "PNG", baos);
            byte[] bytes = baos.toByteArray();

            return bytes;
        } 
        catch (Exception ex) {
            return null;
        }
    }

}
