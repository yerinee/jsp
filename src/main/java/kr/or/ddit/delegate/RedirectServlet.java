package kr.or.ddit.delegate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 인자로 입력한 클래스의 패키지 정보를 확인 : kr.or.ddit.delegate.RedirectServlet
	private static final Logger logger = LoggerFactory.getLogger(RedirectServlet.class);

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// servlet은 응답을 만들어 내는 역할이 아니라 요청을 받고 로직을 처리한 후
		// jsp에게 화면을 응답 생성을 위임한다.
		
		
//		System.out.println("redirectServlet.doGet()");
		// 문자열 결합만 조심하자 "redirectServlet" "doGet()"
		// "redirectServlet" + "doGet()" 문자열 결합연산이 들어간다. => 동시 사용자가 많으면 큰 문제가 된다.
		logger.debug("redirectServlet {}", "doGet()"); //=> 문자열 결합연산 피하기위해
		logger.debug("redirectServlet {} {}", "doGet()" , "test"); //=> 여러개의 문자열 결합연산 피하기위해
		
		logger.debug("redirectServlet.doGet()");
		
		// 응답을 다른 jsp에게 위임하는 첫번째 방법 : redirect
		// response 객체의 sendRedirect 메소드를 통해
		// 클라이언트에게 재 요청을 보낼 주소를 알려준다.
		
		// 클라이언트 최초 요청 : http://localhost/redirectServlet
		// 서버에서 RedirectServlet의 service 메소드 호출
		// 			클라이언트가 보낸 요청이 GET 방식이기때문에 service ==> doGet() 호출
		//			response객체를 이용하여 다른 jsp파일로 클라이언트에게 재요청 보내줄 것을 안내
		// 클라이언트가 최초 요청에 대한 응답(redirect 응답)을 받고서 서버의 안내대로
		// http://localhost/delegate/redirectView.jsp로 재요청
		// 그래서 최종적으로 클라이언트의 주소줄에는 jsp 요청에 대한 주소가 남는다.
		// 클라이언트 입장에서는 서버로 요청을 총 두번 보낵게 된다.
		
		// 아래 데이터를 db에서 조회한 데이터라고 생각하자.
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("sally");
		rangers.add("cony");
		
		request.setAttribute("rangers", rangers);
		
		// 서버가 redirect로 응답을 할 경우 클라이언트는 해당 주소로
		// 새로운 요청을 보내기 때문에 servlet에서 request 스코프에 설정한 속성은
		// 사용할 수 없기 때문에 redirectView.jsp에서는 에러가 발생한다.
		
		response.sendRedirect("/delegate/redirectView.jsp");
		
	
	}


}
