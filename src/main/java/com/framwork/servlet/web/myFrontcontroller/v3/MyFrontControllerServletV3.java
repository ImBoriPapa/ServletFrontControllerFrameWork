package com.framwork.servlet.web.myFrontcontroller.v3;





import com.framwork.servlet.web.myFrontcontroller.ModelAndView;
import com.framwork.servlet.web.myFrontcontroller.View;
import com.framwork.servlet.web.myFrontcontroller.ViewPath;
import com.framwork.servlet.web.myFrontcontroller.v3.controller.BoardFormControllerV3;
import com.framwork.servlet.web.myFrontcontroller.v3.controller.BoardListControllerV3;
import com.framwork.servlet.web.myFrontcontroller.v3.controller.BoardWriteControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="myFrontControllerServletV3",urlPatterns = "/myFrontController/v3/*")
public class MyFrontControllerServletV3 extends HttpServlet {

    private Map<String, MyControllerV3> controllerMap = new HashMap<>();

    public MyFrontControllerServletV3() {
        controllerMap.put("/myFrontController/v3/boards/form", new BoardFormControllerV3());
        controllerMap.put("/myFrontController/v3/boards/write", new BoardWriteControllerV3());
        controllerMap.put("/myFrontController/v3/boards", new BoardListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        MyControllerV3 controller = controllerMap.get(requestURI);
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);

        ModelAndView mv = controller.process(paramMap);

        String viewName = mv.getViewName();

        View view = viewResolver(viewName);

        view.render(mv.getModel(),request,response);
        }

    private View viewResolver(String viewName) {
        return new View(ViewPath.board + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName->paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

}
