package com.example.socketnoti.controller;

import com.example.socketnoti.dto.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class WriteController {

    @GetMapping(value = "/write")
    public String write(){
        return "write";
    }

    @GetMapping(value = "/writeAction")
    public String writeAction(BoardDTO dto, Model model){
        System.out.println("writeActionController 진입");
        System.out.println(dto.toString());

        model.addAttribute("test",dto.toString());
        return "afterWrite";
    }



}
