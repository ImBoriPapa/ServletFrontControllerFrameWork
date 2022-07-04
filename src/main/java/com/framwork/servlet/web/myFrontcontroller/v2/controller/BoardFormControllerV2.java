package com.framwork.servlet.web.myFrontcontroller.v2.controller;

import com.framwork.servlet.web.myFrontcontroller.View;
import com.framwork.servlet.web.myFrontcontroller.ViewPath;
import com.framwork.servlet.web.myFrontcontroller.v2.MyControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardFormControllerV2 implements MyControllerV2 {

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return new View(ViewPath.form);
    }
}
