package hello.sevlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
	
	/**
	 * 
	 * @param parmaMap
	 * @param model
	 * @return viewName
	 */
	String process(Map<String,String>paramMap, Map<String, Object> model);

}
