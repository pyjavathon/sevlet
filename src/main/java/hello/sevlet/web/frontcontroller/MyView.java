package hello.sevlet.web.frontcontroller;

import java.io.IOException;
import java.util.Map;

public class MyView {
	
	private String viewPath;
	
	public MyView(String viewPath) {
		this.viewPath = viewPath;
	}
	
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forword(request,response);
	}
	
	public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		modelToRequestAttribute(model, request);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forword(request,response);
	}

	private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
		model.forEach((key,value)-> request.setAttribute(key,value));
	}

}
