package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberServiceI service = new MemberService();
		
		
		String curpage = request.getParameter("page");
		int page = curpage == null? 1 :Integer.parseInt(curpage); //처음 페이지는 무조건 1페이지가 나올수있게 만들었다.
		
		//String pagesize = request.getParameter("pageSize");
		int pageSize = 7; // pagesize == null? 7 :Integer.parseInt(pagesize); //처음에는 무조건 5개씩 나오게 만들었다.
		
		request.setAttribute("page", page);//현재 페이지 번호
		request.setAttribute("pageSize", pageSize); //화면에 나올 리스트 개수
		
		Map<String, Integer> map = new HashMap<>(); 
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		PageVO pagevo = new PageVO();
		pagevo.setPage(page);
		pagevo.setPageSize(pageSize);
		
		//Map<String , Object> maps = service.getAllpage(map);
		Map<String , Object> maps = service.selectMemberPageList(pagevo);
		request.setAttribute("memberList", maps.get("memberList")); //페이지에 따른 멤버리스트
		request.setAttribute("pages", maps.get("pages")); // 총 페이지수
		
		request.getRequestDispatcher("/member/memberlist.jsp").forward(request, response);
	}	

}
