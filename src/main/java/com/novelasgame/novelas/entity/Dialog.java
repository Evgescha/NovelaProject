package com.novelasgame.novelas.entity;

import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.Data;

@Data
public class Dialog {
    static Logger logger = Logger.getLogger(Dialog.class.getName());
    private  final String type="dialog";
    private String name="";
    private String fullName="";
    private String[] text;
    public Dialog() {}
    public Dialog(String str) {
        logger.fine("Dialog. Line constructor");
        logger.log(Level.FINE, "Arguments: ",str);
        String[] arr=str.split(" \"");
        
        if (str.charAt(0) == '"') {
            text=str.replace("\"", "").split("\\{w\\}");
        }
        if (arr.length > 1) {
            name=arr[0];
            text=arr[1].replace("\"", "").split("\\{w\\}");
        }        
        logger.log(Level.FINE, "Text for dialog: ",text);
    }

}
