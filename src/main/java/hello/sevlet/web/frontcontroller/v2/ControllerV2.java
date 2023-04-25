package hello.sevlet.web.frontcontroller.v2;

import hello.sevlet.web.frontcontroller.MyView;

public interface ControllerV2 {

	MyView process(HttpservletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
