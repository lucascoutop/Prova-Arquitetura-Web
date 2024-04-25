package com.example.RestAPI.controller;

import com.example.RestAPI.model.UserEntity;
import com.example.RestAPI.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/noticias")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/noticiasreleases")
    public String consultarTudo(){
        return service.consultarTudo();
    }

    @GetMapping("/noticias")
    public String consultarNoticia(){
        return service.consultarNoticia();
    }

    @GetMapping("/releases")
    public String consultarReleases(){
        return service.consultarRelease();
    }

    @GetMapping("/noticias")
    public String salvarNoticiaRelease(){
        return service.salvarNoticia();
    }

    @GetMapping("/release")
    public String salvarRelease(){
        return service.salvarRelease();
    }
}
