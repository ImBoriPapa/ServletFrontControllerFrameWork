package com.framwork.servlet.web.myFrontcontroller.v1.controller;

import com.framwork.servlet.domain.board.Board;
import com.framwork.servlet.domain.board.BoardRepository;
import com.framwork.servlet.web.myFrontcontroller.ViewPath;
import com.framwork.servlet.web.myFrontcontroller.v1.MyControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BoardListControllerV1 implements MyControllerV1 {

    private BoardRepository boardRepository = BoardRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Board> boards = boardRepository.findAll();

        request.setAttribute("boards",boards);

        String viewPath = ViewPath.list;
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
