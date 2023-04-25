package hello.sevlet.basic.web.springmvc.v1;

import java.util.Map;

import hello.sevlet.domain.member.Member;
import hello.sevlet.domain.member.MemberRepository;
import hello.sevlet.web.frontcontroller.ModelView;
import hello.sevlet.web.frontcontroller.v5.HttpServletRequest;
import hello.sevlet.web.frontcontroller.v5.HttpServletResponse;

@Controller
public class SpringMemberSaveControllerV1 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@RequestMapping("/springmvc/v1/members/save")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		
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
