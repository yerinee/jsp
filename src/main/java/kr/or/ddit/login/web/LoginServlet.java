package kr.or.ddit.login.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

	// Login화면을 클라이언트에게 응답으로 생성
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.debug("loginServlet doGet");
		logger.debug("UNT_CD parameter :{} ", req.getParameter("UNT_CD"));
		
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
		req.getServletContext().getNamedDispatcher("default").forward(req, resp);
	}
	
	// 매번 servlet을 호출할때마다 실행 시키지 않고 한번만 생성시키기 위해 init()안에 생성시켰다.
	@Override
	public void init() throws ServletException {
		
	}
	
   
	


}
