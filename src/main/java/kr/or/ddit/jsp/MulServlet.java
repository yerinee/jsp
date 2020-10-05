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
 * Servlet implementation class MulServlet
 */
@WebServlet("/MulServlet")
public class MulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(SumcalServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cal/mulinput.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end =  Integer.parseInt(request.getParameter("end"));
		int mulResult = start * end;
		
		logger.debug("{} {} {} {}" ,start, end,"사이값의 곱: ", mulResult);
		
		HttpSession session = request.getSession();
		session.setAttribute("mulResult", mulResult);
		session.setAttribute("start", start);
		session.setAttribute("end", end);
		
		request.getRequestDispatcher("cal/mulresult.jsp").forward(request, response);
	}

}
