package com.framwork.servlet.web.myFrontcontroller.v5;

import com.framwork.servlet.web.myFrontcontroller.ModelAndView;
import com.framwork.servlet.web.myFrontcontroller.View;
import com.framwork.servlet.web.myFrontcontroller.ViewPath;
import com.framwork.servlet.web.myFrontcontroller.v3.MyControllerV3;
import com.framwork.servlet.web.myFrontcontroller.v3.controller.BoardFormControllerV3;
import com.framwork.servlet.web.myFrontcontroller.v3.controller.BoardListControllerV3;
import com.framwork.servlet.web.myFrontcontroller.v3.controller.BoardWriteControllerV3;
import com.framwork.servlet.web.myFrontcontroller.v4.controller.BoardFormControllerV4;
import com.framwork.servlet.web.myFrontcontroller.v4.controller.BoardListControllerV4;
import com.framwork.servlet.web.myFrontcontroller.v4.controller.BoardWriteControllerV4;
import com.framwork.servlet.web.myFrontcontroller.v5.adapter.MyControllerV3HandlerAdapter;
import com.framwork.servlet.web.myFrontcontroller.v5.adapter.MyControllerV4HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="myFrontControllerServletV5",urlPatterns ="/font-controller/v5/*" )
public class MyFrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public MyFrontControllerServletV5() {
        intiHandlerMappingMap();
        initHandlerAdapters();
    }


    private void intiHandlerMappingMap() {
        handlerMappingMap.put("/myFrontController/v5/v3/boards/form", new BoardFormControllerV3());
        handlerMappingMap.put("/myFrontController/v5/v3/boards/write", new BoardWriteControllerV3());
        handlerMappingMap.put("/myFrontController/v5/v3/boards", new BoardListControllerV3());

        handlerMappingMap.put("/myFrontController/v5/v4/boards/form", new BoardFormControllerV4());
        handlerMappingMap.put("/myFrontController/v5/v4/boards/write", new BoardWriteControllerV4());
        handlerMappingMap.put("/myFrontController/v5/v4/boards", new BoardListControllerV4());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new MyControllerV3HandlerAdapter());
        handlerAdapters.add(new MyControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request);

        if(handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        MyHandlerAdapter adapter = getHandlerAdapter(handler);

        ModelAndView mv = adapter.handle(request, response, handler);

        String viewName = mv.getViewName();

        View view = viewResolver(viewName);

        view.render(mv.getModel(),request,response);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=" + handler);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private View viewResolver(String viewName) {
        return new View(ViewPath.board + viewName + ".jsp");
    }
}
