package kr.or.ddit.member.web;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;


@Controller
public class ProfileController {

	@Resource(name="memberService")
	private MemberServiceI memberservice;
	
	
	
	
	@RequestMapping("/profileDownload")
	public String profileDownloadView(String userid , Model model) throws IOException{
		
		MemberVO membervo = memberservice.getMember(userid);
		
		model.addAttribute("filepath", membervo.getFilename());		
		model.addAttribute("realfilename", membervo.getRealfilename());

		return "profileDownloadView";
	}
	
	
	
	
	
	
	// VIEW를 이용하여 이미지 출력
	// view와 controller 기능을 분리시키기 위해 Model객체를 사용함
	@RequestMapping("/profileImgView")
	public String profileImgView(String userid, Model model) throws IOException {
		
		// 응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream 객체에 쓰는 것
		 
		MemberVO memberVo = memberservice.getMember(userid);
		
		model.addAttribute("filepath", memberVo.getFilename());
		
		return "profileImgView";
	}
	
	// Controller에서 이미지 출력
	// view 가 없는 상태에서 controller가 처리하는것이다.
	// 멤버 정보에 이미지 표시
	@RequestMapping("/profileImg")
	public void profileImg(String userid,HttpServletResponse response) throws IOException {
		
		response.setContentType("image/");
		
		MemberVO membervo = memberservice.getMember(userid);
		
		
		String filepath = membervo.getFilename(); // 파일경로
		if(filepath != null) {
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
	}
	
}
