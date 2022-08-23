package com.capcom.mh.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Monster's controller")
@RestController
@RequestMapping(value = "/monster")
public class MonsterController {

    @GetMapping("/nergigante")
    public String getNergigante(){

        return "Nergigante";

    }
}
