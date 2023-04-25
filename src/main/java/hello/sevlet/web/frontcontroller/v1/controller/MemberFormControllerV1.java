package hello.sevlet.web.frontcontroller.v1.controller;

import hello.sevlet.web.frontcontroller.v1.ControllerV1;
import hello.sevlet.web.frontcontroller.v1.HttpServletResponse;
import hello.sevlet.web.frontcontroller.v1.HttpservletRequest;
import hello.sevlet.web.frontcontroller.v1.IOException;
import hello.sevlet.web.frontcontroller.v1.ServletException;
import hello.sevlet.web.servlet.servletmvc.RequestDispatcher;

public class MemberFormControllerV1 implements ControllerV1{
	
	@Override
	public void process(HttpservletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String viewPath = "/WEB-INF/views/new-form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

}
