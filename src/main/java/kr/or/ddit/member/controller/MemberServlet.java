package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class Member
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberServiceI service;
	
    @Override
	public void init() throws ServletException {
    	service = new MemberService();
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		  userid 파라미터 받기
		  service 객체 준비 - 호출
		  화면 담당 jsp로 위임 
		 
		 */
		
		String userid = request.getParameter("userid");
		MemberVO  memberVo = service.getMember(userid);
		
		request.setAttribute("memberVo", memberVo);
		
		request.getRequestDispatcher("/member/member.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
