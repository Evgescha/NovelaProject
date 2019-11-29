package com.novelasgame.novelas.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novelasgame.novelas.entity.Scene;
import com.novelasgame.novelas.service.SceneService;

@Controller
@RequestMapping("/scene")
public class SceneController {

    @Autowired
    SceneService sceneService;

    @ResponseBody
    @GetMapping(value = "/get", produces = MediaType.IMAGE_JPEG_VALUE)
    private byte[] getScene(@ModelAttribute Scene scn) throws IOException {
        return sceneService.getSceneByte(scn);
    }
}
