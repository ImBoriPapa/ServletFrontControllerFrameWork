package com.framwork.servlet.web.myFrontcontroller.v2;

import com.framwork.servlet.web.myFrontcontroller.View;
import com.framwork.servlet.web.myFrontcontroller.v2.controller.BoardFormControllerV2;
import com.framwork.servlet.web.myFrontcontroller.v2.controller.BoardListControllerV2;
import com.framwork.servlet.web.myFrontcontroller.v2.controller.BoardWriteControllerV2;
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
@WebServlet(name = "myFrontControllerServletV2", urlPatterns = "/myFrontController/v2/*")
public class MyFrontControllerServletV2 extends HttpServlet {

    private Map<String, MyControllerV2> controllerMap = new HashMap<>();

    public MyFrontControllerServletV2() {
        controllerMap.put("/myFrontController/v2/boards/form", new BoardFormControllerV2());
        controllerMap.put("/myFrontController/v2/boards/write", new BoardWriteControllerV2());
        controllerMap.put("/myFrontController/v2/boards", new BoardListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        MyControllerV2 myControllerV2 = controllerMap.get(requestURI);
        if(myControllerV2 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        View view = myControllerV2.process(request,response);
        view.render(request,response);
    }
}
