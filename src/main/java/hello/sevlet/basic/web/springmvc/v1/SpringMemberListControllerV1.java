package hello.sevlet.basic.web.springmvc.v1;

import java.util.List;
import java.util.Map;

import hello.sevlet.domain.member.Member;
import hello.sevlet.domain.member.MemberRepository;
import hello.sevlet.web.frontcontroller.ModelView;

@Controller
public class SpringMemberListControllerV1 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping("/springmvc/v1/members")
	public ModelAndView process() {
		List<Member> members = memberRepository.findAll();
		ModelAndView mv = new ModelAndView("members");
		//mv.getModel().put("members", members);
		mv.addObject("members",members);
		return mv;
	}

}
