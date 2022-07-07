package com.framwork.servlet.web.myFrontcontroller.v4.controller;

import com.framwork.servlet.web.myFrontcontroller.v4.MyControllerV4;

import java.util.Map;

public class BoardFormControllerV4 implements MyControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "boardForm";
    }
}
