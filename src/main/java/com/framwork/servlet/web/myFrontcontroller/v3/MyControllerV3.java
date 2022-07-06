package com.framwork.servlet.web.myFrontcontroller.v3;

import com.framwork.servlet.web.myFrontcontroller.ModelAndView;

import java.util.Map;

public interface MyControllerV3 {

    ModelAndView process(Map<String, String> paramMap);
}
