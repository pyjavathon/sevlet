package hello.sevlet.web.frontcontroller.v3;

import java.util.Map;

import hello.sevlet.web.frontcontroller.ModelView;

public interface ControllerV3 {

	ModelView process(Map<String,String> paramMap);
}
