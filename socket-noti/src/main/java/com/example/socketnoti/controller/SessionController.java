package com.example.socketnoti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {


    @ResponseBody
    @GetMapping(value = "/giveSession")
    public String giveSession(HttpSession httpSession){
        httpSession.setAttribute("admin","admin");
        return "giveSession";
    }

    @ResponseBody
    @GetMapping(value = "/getSession")
    public String getSession(HttpSession httpSession){
        return httpSession.getAttribute("admin").toString();
    }

}
