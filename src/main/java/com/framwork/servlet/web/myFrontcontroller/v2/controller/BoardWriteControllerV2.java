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

public class BoardWriteControllerV2 implements MyControllerV2 {

    BoardRepository boardRepository = BoardRepository.getInstance();

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Board board = new Board(title, content);
        boardRepository.save(board);

        request.setAttribute("board",board);

        return new View(ViewPath.result);
    }
}
