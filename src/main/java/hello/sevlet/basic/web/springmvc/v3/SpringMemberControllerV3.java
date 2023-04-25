package hello.sevlet.basic.web.springmvc.v3;

import java.util.List;

import hello.sevlet.basic.web.springmvc.v2.Controller;
import hello.sevlet.basic.web.springmvc.v2.HttpServletRequest;
import hello.sevlet.basic.web.springmvc.v2.HttpServletResponse;
import hello.sevlet.basic.web.springmvc.v2.ModelAndView;
import hello.sevlet.basic.web.springmvc.v2.RequestMapping;
import hello.sevlet.domain.member.Member;
import hello.sevlet.domain.member.MemberRepository;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
	
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@GetMapping
	public String members(Model model) {
		List<Member> members = memberRepository.findAll();
		//mv.getModel().put("members", members);
		//mv.addObject("members",members);
		model.addAttribute("members",members);
		return "members";
	}
	
	//@RequestMapping("/new-form", method = RequestMethod.GET)
	@GetMapping("/new-form")
	public String newForm() {
		return "new-form";
	}
	
	//@RequestMapping("/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String save(@RequestParam("username")String username,
					   @RequestParam("age")int age,
					   Model model) {
		
		Member member = new Member(username,age);
		memberRepository.save(member);
		
		//mv.getModel().put("member", member);
		//mv.addObject("member",member);
		model.addAttribute("member",member);
		return "save-result";
		
		
	}

}
