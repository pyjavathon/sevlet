package hello.sevlet.basic.web.springmvc.old;

import hello.sevlet.web.frontcontroller.v1.controller.IOException;
import hello.sevlet.web.frontcontroller.v1.controller.ServletException;

@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("MyHttpRequestHandler.handleRequest");
	}
}
