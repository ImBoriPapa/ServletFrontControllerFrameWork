package com.framwork.servlet.web.myFrontcontroller.v3.controller;

import com.framwork.servlet.domain.board.Board;
import com.framwork.servlet.domain.board.BoardRepository;
import com.framwork.servlet.web.myFrontcontroller.ModelAndView;
import com.framwork.servlet.web.myFrontcontroller.v3.MyControllerV3;

import java.util.List;
import java.util.Map;

public class BoardListControllerV3 implements MyControllerV3 {

    BoardRepository boardRepository = BoardRepository.getInstance();
    
    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        List<Board> boards = boardRepository.findAll();
        ModelAndView mv = new ModelAndView("boardList");
        mv.getModel().put("boards",boards);

        return mv;
    }
}
