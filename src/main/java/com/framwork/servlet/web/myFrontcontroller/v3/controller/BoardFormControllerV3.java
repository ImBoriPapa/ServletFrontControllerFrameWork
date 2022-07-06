package com.framwork.servlet.web.myFrontcontroller.v3.controller;

import com.framwork.servlet.web.myFrontcontroller.ModelAndView;
import com.framwork.servlet.web.myFrontcontroller.v3.MyControllerV3;

import java.util.Map;

public class BoardFormControllerV3 implements MyControllerV3 {

    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        return new ModelAndView("boardForm");
    }
}
