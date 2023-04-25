package hello.sevlet.web.frontcontroller.v1.controller;

import java.util.List;

import hello.sevlet.domain.member.Member;
import hello.sevlet.domain.member.MemberRepository;
import hello.sevlet.web.frontcontroller.v1.ControllerV1;
import hello.sevlet.web.servlet.servletmvc.RequestDispatcher;

public class MemberListControllerV1 implements ControllerV1{
	
	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@Override
	public void process(HttpservletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		List<Member> members = memberRepository.findAll();
		
		request.setAttribute("members", members);
		
		String viewPath = "/WEB-INF/views/members.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

}
