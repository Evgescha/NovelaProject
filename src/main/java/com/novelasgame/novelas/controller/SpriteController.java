package com.novelasgame.novelas.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novelasgame.novelas.entity.Char;
import com.novelasgame.novelas.service.СharacterService;

@Controller
@RequestMapping("/images")
public class SpriteController {

    @Autowired
    private СharacterService charService;

    @ResponseBody
    @GetMapping(value = "/char", produces = MediaType.IMAGE_PNG_VALUE)
    private byte[] getChar(@ModelAttribute Char chr) throws IOException {
        return charService.getImageByte(chr);
    }
}


