package hello.sevlet.web.frontcontroller.v4;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.sevlet.web.frontcontroller.MyView;
import hello.sevlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.sevlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.sevlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "frontControllerServletV4" , urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet{

	private Map<String, ControllerV4> controllerMap = new HashMap<>();
	
	public FrontControllerServletV4() {
		controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV4());
		controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV4());
		controllerMap.put("/front-controller/v3/members/members", new MemberListControllerV4());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("FrontControllerServletV3.service");
		
		String requestURI = request.getRequestURI();
		
		ControllerV4 controller = controllerMap.get(requestURI);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		//paramMap
		Map<String, String> paramMap = createParamMap(request);
		Map<String, Object> model = new HashMap<>();//추가
		String viewName = controller.process(paramMap, model);
		
		
		MyView view = viewResolver(viewName);
		
		view.render(model,request, response);
	}

	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/"+viewName+".jsp");
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
	
}
