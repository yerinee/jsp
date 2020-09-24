package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class gobServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=utf-8");
		// writer 객체를 통해 html문서를 생성해준다
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<head><style> td{border : 1px solid black; padding : 10px;}");
		writer.println("</style></head>");
		writer.println("<body>");
		
		
		writer.print("<table>");
		for(int i = 1; i<10;i++) {
			writer.print("<tr>");
			for(int j =2; j<10;j++) {
				writer.print("<td>");
				writer.print(j +" * " +i + " = " + i*j);
				writer.print("</td>");
			}
			writer.print("</tr>");
		}
		writer.print("</table>");
		
		
		writer.println("</body>");
		writer.println("</html>");
		writer.flush();
		writer.close();
	}
}
