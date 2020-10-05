package kr.or.ddit.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.ranger.service.RangerService;
import kr.or.ddit.ranger.service.RangerServiceI;

/**
 * Servlet implementation class Outservlet
 */
@WebServlet("/outServlet")
public class Outservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ranger 정보 조회
		RangerServiceI rangerService = new RangerService();
		
		
		// ranger 정보를 화면에 표현해줄 out.jsp 파일로 응답 생성을 위임
		// ranger 정보가 어딘가에 담겨야함
		// servlet에서는 3가지 scope가 사용가능
		// request < session < application
		// 해당요청을 일회성으로만 처리해주면 레인저 이름 정보를 보관할 필요가 없고 
		// 다른 요청과 관련이 없으므로 request 적당한다.
		
		// servlet 상에서 작성할 코드
		// request 객체에 rangers라는 속성이름으로 레인저 정보를 저장
		
		// out.jsp(아직 안만들었다 webapp/jsp/out.jsp에 생성)로 요청 위임(forward)
		
		// out.jsp에서는 rangers라는 속성을 꺼내 loop를 돌며 화면에 출력
		// ***out 객체를 이용
		
	 	List<String> rangerlist = rangerService.getRangers();
	 	
	 	request.setAttribute("rangerlist", rangerlist);
	 	
	 	request.getRequestDispatcher("/jsp/out.jsp").forward(request, response);
	}

	
}
