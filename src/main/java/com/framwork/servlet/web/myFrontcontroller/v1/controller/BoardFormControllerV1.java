package com.framwork.servlet.web.myFrontcontroller.v1.controller;

import com.framwork.servlet.web.myFrontcontroller.ViewPath;
import com.framwork.servlet.web.myFrontcontroller.v1.MyControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardFormControllerV1 implements MyControllerV1 {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = ViewPath.form;
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);

    }
}
