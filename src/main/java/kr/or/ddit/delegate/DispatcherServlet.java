package kr.or.ddit.delegate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청을 다른 jsp(servlet)에게 위임하는 방법 2번째 : Dispatcher
		// request 객체의 getRequestDispatcher 메소드를 호출하여 requestDispatcher 객체를 확보
		// requestDispatcher객체의 forward메소드를 통해 다른 jsp(servlet)에게 응답 생성을 위임
		// 위임 받은 jsp, servlet에서 최종적으로 응답을 생성
		
		
		// 서블릿에서 요청을 받고 로직을 처리하여 화면에서 필요로하는 데이터를 request객체의 속성으로 저장
		// 위임받은 jsp는 같은 요청 scope에 존재하기 때문에 request 객체에서 저장된 속성을 꺼내 사용할 수 있다
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("sally");
		rangers.add("cony");
		
		request.setAttribute("rangers", rangers);
		
		
		// dispatcher로 요청을 위임할시 ContextPath를 별도로 붙여주지 않는다.
		// **서버 내에서 이루어지는 작업이기 때문에 **
		
		// contextPath : jsp ==> "jsp/delegate/redirectView.jsp"
		// contextPath : ROOT(/) ==> "/delegate/redirectView.jsp"
		RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath() + "/delegate/dispatcherView.jsp");
		rd.forward(request, response);
	}

}
