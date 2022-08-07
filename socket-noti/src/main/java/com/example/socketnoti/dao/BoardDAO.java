package com.example.socketnoti.dao;


import com.example.socketnoti.dto.BoardDTO;
import com.example.socketnoti.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
    @Autowired
    BoardMapper boardMapper;

    public BoardDTO selectBoard(){
        return boardMapper.selectBoard();
    }

}
