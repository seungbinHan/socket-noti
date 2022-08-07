package com.example.socketnoti.mapper;

import com.example.socketnoti.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    BoardDTO selectBoard();
}
