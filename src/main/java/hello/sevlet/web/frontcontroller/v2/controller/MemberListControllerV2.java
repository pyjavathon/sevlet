package hello.sevlet.web.frontcontroller.v2.controller;

import java.io.IOException;
import java.util.List;

import hello.sevlet.domain.member.Member;
import hello.sevlet.domain.member.MemberRepository;
import hello.sevlet.web.frontcontroller.MyView;
import hello.sevlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListControllerV2 implements ControllerV2{

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Member> members = memberRepository.findAll();
		
		request.setAttribute("members", members);
		
		return new MyView("/WEB-INF/views/members.jsp");
	}

}
