package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileupload.FileUpdloadUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberRegistServlet
 */
@WebServlet("/memberRegist")
@MultipartConfig
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MemberRegistServlet.class);
    MemberServiceI service = new MemberService();
    
    @Override
	public void init() throws ServletException {
    	service = new MemberService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberRegist.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		logger.debug("parameter : {},{},{},{},{},{},{}",userid, usernm, alias, pass, addr1, addr2, zipcode );
		
		// 파일정보는 part를 통해서 확인한다.
		Part profile =  request.getPart("realFilename");
		
		logger.debug("file : {}", profile.getHeader("Content-Disposition"));
		
		String realfilename = FileUpdloadUtil.getFilename(profile.getHeader("Content-Disposition"));
		logger.debug("realfile : {}", realfilename);
		String filename = UUID.randomUUID().toString(); // db에서의 sequence와 같은 결과
		
		String extension = FileUpdloadUtil.getExtenstion(realfilename);
		String filepath ="";
		
		if(profile.getSize() > 0) {
			filepath = "E:\\profile\\" + filename +"."+ extension;
			logger.debug(filepath);
			logger.debug(extension);
			profile.write(filepath);
		}
		
		// 사용자 정보 등록
		MemberVO memberVo = new MemberVO(userid, pass, usernm, alias, addr1, addr2, zipcode, filepath, realfilename);
	
		int insertCnt = service.inserMember(memberVo);
		logger.debug("insertCnt : {}",insertCnt);
		if(insertCnt >0) { // 1건이 입력되었을때 : 정상
			
			// 서버의 상태가 바뀔경우 새로고침시 오류가 발생하므로 redirect를 써주어야한다.-> 사용자페이지 조회요청
			response.sendRedirect(request.getContextPath() + "/MemberListServlet");
			
		}else {	// 1건이 아닐때 : 비정상
			doGet(request, response);
		}
		
	}

	
}
