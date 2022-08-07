package com.example.socketnoti.controller;

import com.example.socketnoti.dto.BoardDTO;
import com.example.socketnoti.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SelectBoardController {
    @Autowired
    BoardMapper mapper;

    @GetMapping(value = "/selectBoard")
    public String selectBoard(Model model){
        BoardDTO boardDTO = mapper.selectBoard();
        System.out.println(boardDTO.toString());
        model.addAttribute("board",boardDTO);

        return "boardDetail";
    }



}
