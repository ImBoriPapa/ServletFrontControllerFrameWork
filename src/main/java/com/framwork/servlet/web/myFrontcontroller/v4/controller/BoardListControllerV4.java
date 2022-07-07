package com.framwork.servlet.web.myFrontcontroller.v4.controller;

import com.framwork.servlet.domain.board.Board;
import com.framwork.servlet.domain.board.BoardRepository;
import com.framwork.servlet.web.myFrontcontroller.v4.MyControllerV4;

import java.util.List;
import java.util.Map;

public class BoardListControllerV4 implements MyControllerV4 {

    BoardRepository boardRepository = BoardRepository.getInstance();
    
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Board> boards = boardRepository.findAll();

        model.put("boards", boards);

        return "boardList";
    }
}
