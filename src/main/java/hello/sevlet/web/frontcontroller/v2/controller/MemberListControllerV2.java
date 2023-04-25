package hello.sevlet.web.frontcontroller.v2.controller;

import java.util.List;

import hello.sevlet.domain.member.Member;
import hello.sevlet.domain.member.MemberRepository;
import hello.sevlet.web.frontcontroller.MyView;
import hello.sevlet.web.frontcontroller.v2.ControllerV2;
import hello.sevlet.web.frontcontroller.v2.HttpServletResponse;
import hello.sevlet.web.frontcontroller.v2.HttpservletRequest;
import hello.sevlet.web.frontcontroller.v2.IOException;
import hello.sevlet.web.frontcontroller.v2.ServletException;

public class MemberListControllerV2 implements ControllerV2{

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public MyView process(HttpservletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Member> members = memberRepository.findAll();
		
		request.setAttribute("members", members);
		
		return new MyView("/WEB-INF/views/members.jsp");
	}

}
