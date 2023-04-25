package hello.sevlet.web.frontcontroller.v2.controller;

import java.io.IOException;

import hello.sevlet.web.frontcontroller.MyView;
import hello.sevlet.web.frontcontroller.v2.ControllerV2;

public class MemberFormControllerV2 implements ControllerV2{

	@Override
	public MyView process() throws ServletException, IOException{
		return new MyView("/WEB-INF/views/new-form.jsp");
	}
}
