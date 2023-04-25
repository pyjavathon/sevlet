package hello.sevlet.web.frontcontroller.v5;

import java.io.IOException;

import hello.sevlet.web.frontcontroller.ModelView;


public interface MyHandlerAdapter {
	
	boolean supports(Object handler);
	
	ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;

}
