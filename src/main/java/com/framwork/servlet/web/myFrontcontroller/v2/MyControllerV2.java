package com.framwork.servlet.web.myFrontcontroller.v2;

import com.framwork.servlet.web.myFrontcontroller.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyControllerV2 {

    View process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;
}
