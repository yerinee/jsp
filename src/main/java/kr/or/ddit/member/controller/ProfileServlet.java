package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profileImg")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private MemberServiceI memberservice;
	
	@Override
	public void init() throws ServletException {
		memberservice = new MemberService();
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// response content-type 설정
		response.setContentType("image/png");
		//response.setContentType("image/"); 이미지이지만 확장자를 모를경우 이렇게 사용해도된다.
		
		// 사용자 아이디 파라미터 확인하고
		String userid = request.getParameter("userid");
		
		// db에서 사용자 filename 확인
		MemberVO membervo = memberservice.getMember(userid);
		
		// 경로 확인 후 파일 입출력을 통해 응답 생성
		// 1. 파일 읽기   
		// 2. 응답 생성
		String filepath = membervo.getFilename(); // 파일경로
		FileInputStream fis = new FileInputStream(filepath);
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		while(fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush(); // 혹시 응답이 안간것이 있으면 마지막으로 보내라
		sos.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
