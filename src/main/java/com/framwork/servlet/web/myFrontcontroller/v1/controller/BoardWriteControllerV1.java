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

public class BoardWriteControllerV1 implements MyControllerV1{

    private BoardRepository boardRepository = BoardRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Board board = new Board(title, content);
        boardRepository.save(board);

        request.setAttribute("board",board);

        String viewPath = ViewPath.result;
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);


    }
}
