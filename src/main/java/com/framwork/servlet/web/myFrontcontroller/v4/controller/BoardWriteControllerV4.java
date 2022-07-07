package com.framwork.servlet.web.myFrontcontroller.v4.controller;

import com.framwork.servlet.domain.board.Board;
import com.framwork.servlet.domain.board.BoardRepository;
import com.framwork.servlet.web.myFrontcontroller.v4.MyControllerV4;

import java.util.Map;

public class BoardWriteControllerV4 implements MyControllerV4 {

    private BoardRepository boardRepository = BoardRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String title = paramMap.get("title");
        String content = paramMap.get("content");

        Board board = new Board(title, content);
        boardRepository.save(board);

        model.put("board", board);

        return "boardResult";
    }
}
