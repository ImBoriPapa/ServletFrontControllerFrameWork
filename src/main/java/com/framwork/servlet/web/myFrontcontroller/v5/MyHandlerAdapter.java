package com.framwork.servlet.web.myFrontcontroller.v5;

import com.framwork.servlet.web.myFrontcontroller.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    boolean supports(Object handler);

    ModelAndView handle(HttpServletRequest request, HttpServletResponse response,Object handler) throws ServletException, IOException;
}
