package com.framwork.servlet.web.myFrontcontroller.v4;





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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="myFrontControllerServletV4",urlPatterns = "/myFrontController/v4/*")
public class MyFrontControllerServletV4 extends HttpServlet {

    private Map<String, MyControllerV4> controllerMap = new HashMap<>();

    public MyFrontControllerServletV4() {
        controllerMap.put("/myFrontController/v4/boards/form", new BoardFormControllerV4());
        controllerMap.put("/myFrontController/v4/boards/write", new BoardWriteControllerV4());
        controllerMap.put("/myFrontController/v4/boards", new BoardListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        MyControllerV4 controller = controllerMap.get(requestURI);
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);

        View view = viewResolver(viewName);
        view.render(model,request,response);
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
