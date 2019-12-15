package com.novelasgame.novelas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novelasgame.novelas.entity.Char;
import com.novelasgame.novelas.entity.Command;
import com.novelasgame.novelas.entity.Dialog;
import com.novelasgame.novelas.entity.Game;
import com.novelasgame.novelas.entity.Hide;
import com.novelasgame.novelas.entity.Label;
import com.novelasgame.novelas.entity.Menu;
import com.novelasgame.novelas.entity.MenuItem;
import com.novelasgame.novelas.entity.Scene;
import com.novelasgame.novelas.entity.Sound;
import com.novelasgame.novelas.entity.Window;


@Service
public class LabelParserService {

    public ArrayList<Object> list = new ArrayList<>();

    @Autowired
    public GameService gameService;

    public void Parse(String labelName) {
        
        System.out.println("HELPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
//        labelName = "prologue";
//        list.clear();
//        System.out.println("search: "+labelName);
//        Game game = gameService.findByName("summer");
//        Label label = null;
//        for(Label lbl:game.getLabels()) {
//            if(lbl.getName().contains(labelName))label=lbl;
//        }
//        List<Command> commands = label.getCommands();
//        String cmd = "";
//        for (int i = 0; i < commands.size(); i++) {
////            System.out.println("cmd: "+cmd);
//            cmd = commands.get(i).getValue().trim();
//            String[] arr = cmd.split(" ");
//
//            if (arr[0].contains("menu")) {
//                i++;
//                Menu menu = new Menu();
//
//                while (cmd.charAt(0) == ' ') {
//                    cmd = commands.get(i).getValue();
//                    if (cmd.charAt(3) != ' ') {
//                        menu.getItems().add(new MenuItem(cmd));
//                    } else {
//                        menu.getItems().get(menu.getItems().size() - 1).getCommands().add(getCommand(cmd));
//                    }
//                    i++;
//                }
//                i--;
//                list.add(menu);
//
//            } else
//                list.add(getCommand(cmd));
//
//        }
//        for(Object o:list)System.out.println(o);
    }

    public Object getCommand(String cmd) {
        String[] arr = cmd.split(" ");

        if (cmd.charAt(0) == '"')
            return new Dialog(cmd);

        if (arr.length > 1 && arr[1].charAt(0) == '"')
            return new Dialog(cmd);

        if (arr[0].contains("stop") || arr[0].contains("play"))
            return new Sound(cmd);

        if (arr[0].contains("scene"))
            return new Scene(cmd);

        if (arr[0].contains("window"))
            return new Window(cmd);

        if (arr[0].contains("hide"))
            return new Hide(cmd);

        if (arr.length > 5 && arr[1].charAt(0) != '"' && arr[0].charAt(0) != '"')
            return new Char(cmd);

        return null;
    }

}
