package hello.sevlet.web.frontcontroller.v1;

public interface ControllerV1 {
	
	void process(HttpservletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
