package com.novelasgame.novelas.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.novelasgame.novelas.entity.Char;
import com.novelasgame.novelas.entity.Dialog;
import com.novelasgame.novelas.entity.Scene;
import com.novelasgame.novelas.entity.Sound;

@Controller
@RequestMapping("/testrun")
public class TestRunController {
    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping
    private String getScene(Model model) throws IOException {
        ArrayList<Object> list = new ArrayList<>();
//        list.add(new Char("show dv smile pioneer close at center"));
//        list.add(new Char("show dv smile pioneer close at left"));
//        list.add(new Char("show sl normal pioneer at right"));
//        list.add(new Char("show sl sad pioneer far at cright"));
//        list.add(new Char("show el normal pioneer at left behind sl"));
//        list.add(new Char("show mt normal panama pioneer far at cleft"));

//        list.add(new Dialog("\"Последние несколько лет я просто целыми днями сидел за компьютером.\""));
//        list.add(new Dialog("\"На улицу я практически не выхожу, а всё моё общение с людьми сводится к интернет-переписке с {i}анонимами{/i}, у которых нет ни реального имени, ни пола, ни возраста.\""));
//        list.add(new Dialog("th \"Конечно, страшно.\""));
//        list.add(new Dialog("th \"Судя по статуям пионеров, наверное, детский лагерь.{w} Причем лагерь действующий!\""));
//        list.add(new Dialog("th \"Но вряд ли я найду разгадку в полях и лесах, а это чёртово ведро с гайками – единственное, что хоть как-то связывает меня с реальным миром.\""));
        
        
//        list.add(new Scene("scene bg ext_road_day"));
//        list.add(new Scene("scene bg ext_houses_day"));
//        list.add(new Scene("scene cg d1_rena_sunset"));
//        list.add(new Scene("scene cg d1_grasshopper"));
//        list.add(new Scene("scene anim intro_16"));
        
        list.add(new Sound("play music music_list[\"a_promise_from_distant_days_v2\"] fadein 10"));
        list.add(new Sound("stop music fadeout 6"));
        list.add(new Sound("play sound sfx_intro_bus_stop_steps"));
        list.add(new Sound("play ambience ambience_camp_center_day"));
        list.add(new Sound("play ambience ambience_cold_wind_loop fadein 3"));
        
        String temp = toJson(list);
        System.out.println(temp);
        model.addAttribute("scenario", temp);
        return "testRun";
    }

    private String toJson(Object temp) throws JsonProcessingException {
        return mapper.writeValueAsString(temp);
    }
    // @GetMapping("/get")
    // @ResponseBody
    // private String getJsonData() throws JsonProcessingException {
    // return mapper.writeValueAsString(list);
    // }
}
