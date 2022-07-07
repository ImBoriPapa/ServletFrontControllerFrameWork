package com.framwork.servlet.web.myFrontcontroller.v4;

import java.util.Map;

public interface MyControllerV4 {
    /**
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
