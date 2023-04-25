package hello.sevlet.basic.web.springmvc.v2;

import java.util.List;


import hello.sevlet.domain.member.Member;
import hello.sevlet.domain.member.MemberRepository;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
	
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping
	public ModelAndView members() {
		List<Member> members = memberRepository.findAll();
		ModelAndView mv = new ModelAndView("members");
		//mv.getModel().put("members", members);
		mv.addObject("members",members);
		return mv;
	}
	
	@RequestMapping("/new-form")
	public ModelAndView newForm() {
		return new ModelAndView("new-form");
	}
	
	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username,age);
		memberRepository.save(member);
		
		ModelAndView mv = new ModelAndView("save-result");
		//mv.getModel().put("member", member);
		mv.addObject("member",member);
		return mv;
		
		
	}


}
