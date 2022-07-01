package com.framwork.servlet.web.myFrontcontroller.v1;

import com.framwork.servlet.web.myFrontcontroller.v1.controller.BoardFormControllerV1;
import com.framwork.servlet.web.myFrontcontroller.v1.controller.BoardListControllerV1;
import com.framwork.servlet.web.myFrontcontroller.v1.controller.BoardWriteControllerV1;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@WebServlet(name = "myFrontControllerServletV1", urlPatterns = "/myFrontController/v1/*")
public class MyFrontControllerServletV1 extends HttpServlet {

    private Map<String, MyControllerV1> controllerMap = new HashMap<>();

    public MyFrontControllerServletV1() {
        controllerMap.put("/myFrontController/v1/boards/form", new BoardFormControllerV1());
        controllerMap.put("/myFrontController/v1/boards/write", new BoardWriteControllerV1());
        controllerMap.put("/myFrontController/v1/boards", new BoardListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("myFrontControllerServletV1 실행");

        String requestURI = request.getRequestURI();

        MyControllerV1 myControllerV1 = controllerMap.get(requestURI);
        if(myControllerV1 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        myControllerV1.process(request,response);
    }
}
