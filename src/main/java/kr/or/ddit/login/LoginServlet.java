package kr.or.ddit.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    private MemberServiceI memberservice;
    
    
	// Login화면을 클라이언트에게 응답으로 생성
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.debug("loginServlet doGet");
		logger.debug("UNT_CD parameter :{} ", req.getParameter("UNT_CD"));
		
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	// 매번 servlet을 호출할때마다 실행 시키지 않고 한번만 생성시키기 위해 init()안에 생성시켰다.
	@Override
	public void init() throws ServletException {
		// service 객체 생성
		memberservice = new MemberService();	
	}
	
   
	// Login 화면에서 사용자가 보낸 아이디 비밀번호를 사용하여 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		
		MemberVO membervo = memberservice.getMember(userid);
		
		// 디비에 등록된 회원이 없거나, 비밀번호가 틀린경우 (로그인 페이지)
		if(membervo == null || !membervo.getPass().equals(password)) {
			request.getRequestDispatcher("/login.jsp").forward(request, response); 
			
		}else if (membervo.getPass().equals(password)){ //비밀번호가 일치하는 경우(메인페이지 이동)
			request.getSession().setAttribute("S_MEMBER", membervo);
			request.getRequestDispatcher("/main.jsp").forward(request, response); 
		}
		
		logger.debug("userId : {}, password : {}", userid, password);
		
		// 쿠키정보
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies) {
			logger.debug("name : {}, value : {}", cookie.getName(), cookie.getValue());
			
			cookie.getName();
			cookie.getValue();
		}
		
		Cookie cookie = new Cookie("SERVERCOOKIE", "COOKIEVALUE");
		cookie.setMaxAge(60*60*24);// 하루로 쿠키의 지속 날짜 설정
		
		response.addCookie(cookie);
	}
	


}
