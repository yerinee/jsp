package kr.or.ddit.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@WebServlet 혹은 web.xml url-mapping을 통해 url 등록

@RequestMapping("/login")
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	// 만약 사용자가 localhost/login/view 를 요청하면 이 메소드에서 처리하는것이다.
	@RequestMapping("/view.do")
	public String getView() {
		
		logger.debug("LoginController.getView()");
		return "login/view";
	}
}
