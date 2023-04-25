package hello.sevlet.web.frontcontroller.v2.controller;

import java.io.IOException;

import hello.sevlet.domain.member.Member;
import hello.sevlet.domain.member.MemberRepository;
import hello.sevlet.web.frontcontroller.MyView;
import hello.sevlet.web.frontcontroller.v1.controller.RequestDispatcher;
import hello.sevlet.web.frontcontroller.v2.ControllerV2;
import hello.sevlet.web.frontcontroller.v2.HttpServletResponse;
import hello.sevlet.web.frontcontroller.v2.HttpservletRequest;
import hello.sevlet.web.frontcontroller.v2.ServletException;

public class MemberSaveControllerV2 implements ControllerV2{

	private MemberRepository memberRepository = MemberRepository.getInstance();

	
	@Override
	public MyView process(HttpservletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username,age);
		memberRepository.save(member);

		//Model에 데이터를 보관한다.
		request.setAttribute("member", member);
		
		return new MyView("/WEB-INF/views/save-result.jsp");
	}

}
