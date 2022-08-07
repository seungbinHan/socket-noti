package com.example.socketnoti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NotiController {

    @ResponseBody
    @GetMapping(value = "/getNoti")
    public String getNoti(){

        return "giveSession";
    }


}
