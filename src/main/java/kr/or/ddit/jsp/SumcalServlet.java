package kr.or.ddit.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class SumcalServlet
 */
@WebServlet("/SumcalServlet")
public class SumcalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 인자로 입력한 클래스의 패키지 정보를 확인 : kr.or.ddit.delegate.RedirectServlet
	private static final Logger logger = LoggerFactory.getLogger(SumcalServlet.class);
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cal/sumInput.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end =  Integer.parseInt(request.getParameter("end"));
		int sumResult = 0;
		for(int i = start ; i<=end ;i++) {
			sumResult += i;
		}
		
		logger.debug("{} {} {} {}" ,start, end,"사이값의 합: ", sumResult);
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sumResult);
		session.setAttribute("start", start);
		session.setAttribute("end", end);
		
		request.getRequestDispatcher("cal/sumresult.jsp").forward(request, response);
	}

}
