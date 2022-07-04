package com.framwork.servlet.web.myFrontcontroller.v2.controller;

import com.framwork.servlet.domain.board.Board;
import com.framwork.servlet.domain.board.BoardRepository;
import com.framwork.servlet.web.myFrontcontroller.View;
import com.framwork.servlet.web.myFrontcontroller.ViewPath;
import com.framwork.servlet.web.myFrontcontroller.v2.MyControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BoardListControllerV2 implements MyControllerV2 {

    private BoardRepository boardRepository = BoardRepository.getInstance();

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Board> boards = boardRepository.findAll();

        request.setAttribute("boards",boards);

        return new View(ViewPath.list);
    }
}
