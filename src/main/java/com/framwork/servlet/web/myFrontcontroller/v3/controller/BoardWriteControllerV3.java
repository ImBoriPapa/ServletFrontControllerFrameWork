package com.framwork.servlet.web.myFrontcontroller.v3.controller;

import com.framwork.servlet.domain.board.Board;
import com.framwork.servlet.domain.board.BoardRepository;
import com.framwork.servlet.web.myFrontcontroller.ModelAndView;
import com.framwork.servlet.web.myFrontcontroller.v3.MyControllerV3;

import java.util.Map;

public class BoardWriteControllerV3 implements MyControllerV3 {

    private BoardRepository boardRepository = BoardRepository.getInstance();

    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        String title = paramMap.get("title");
        String content = paramMap.get("content");

        Board board = new Board(title, content);
        boardRepository.save(board);

        ModelAndView mv = new ModelAndView("boardResult");
        mv.getModel().put("board", board);
        return mv;
    }
}
