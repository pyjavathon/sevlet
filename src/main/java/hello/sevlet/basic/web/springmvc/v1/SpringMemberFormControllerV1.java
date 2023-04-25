package hello.sevlet.basic.web.springmvc.v1;

@Controller
public class SpringMemberFormControllerV1 {
	
	@RequestMapping("/springmvc/v1/members/new-form")
	public ModelAndView process() {
		return new ModelAndView("new-form");
	}

}
