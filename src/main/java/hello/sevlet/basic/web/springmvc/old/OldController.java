package hello.sevlet.basic.web.springmvc.old;

@Component("/springmvc/old-controller")
public class OldController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("OldController.handlerRequest");
		return new ModelAndView("new-form");
	}
}
