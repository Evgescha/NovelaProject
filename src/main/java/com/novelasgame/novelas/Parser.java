package com.novelasgame.novelas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.novelasgame.novelas.entity.Char;
import com.novelasgame.novelas.entity.Dialog;
import com.novelasgame.novelas.entity.Hide;
import com.novelasgame.novelas.entity.Scene;
import com.novelasgame.novelas.entity.Sound;
import com.novelasgame.novelas.entity.Variables;
import com.novelasgame.novelas.entity.Window;

public class Parser {
    public static ArrayList<Object> list;

    public Scanner sc;
    public static File file;
    public static String pathToFile = "C:\\Users\\DELL\\Desktop\\scenario.txt";
    static String[] arr;
    static String line = "";

    public static ArrayList<Object> getList() {
        list = new ArrayList<>();
        list.clear();
        try {
            file = new File(pathToFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            int i=0;
            while((line=br.readLine())!=null) {
                System.out.println(i+"\t"+line);
                i++;
                arr = line.split(" ");

                if (line.charAt(0) == '"')
                    list.add(new Dialog(line));
                if (arr.length > 1 && arr[1].charAt(0) == '"') 
                    list.add(new Dialog(line));               
                if (arr[0].contains("stop") || arr[0].contains("play"))
                    list.add(new Sound(line));
                if (arr[0].contains("scene"))
                    list.add(new Scene(line));
                if (arr[0].contains("window"))
                    list.add(new Window(line));
                if (arr[0].contains("hide"))
                    list.add(new Hide(line));
                if (arr.length > 5 && arr[1].charAt(0) != '"' && arr[0].charAt(0) != '"') 
                    list.add(new Char(line));                
                if (line.charAt(0) == '$')
                    list.add(new Variables(line));
            }
        } catch (IOException ex) {
        }
        return list;
    }



}
