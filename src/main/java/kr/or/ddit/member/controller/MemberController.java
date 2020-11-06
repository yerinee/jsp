package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.fileupload.FileUpdloadUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="memberService")
	private MemberServiceI memberservice;
	
	
	// 멤버리스트 출력
	@RequestMapping(path ="/memberlist" , method = {RequestMethod.GET})
	public String getMemberlist(String page ,Model model) {
		// String은 primitive타입이 아니어서 
		// @RequestParam(name="파라미터명", required=false , defaultValue="")으로 쓰지 않아도 된다.
		int curpage = page == null? 1 :Integer.parseInt(page); //처음 페이지는 무조건 1페이지가 나올수있게 만들었다.
	
		int pageSize = 7; // pagesize == null? 7 :Integer.parseInt(pagesize); //처음에는 무조건 5개씩 나오게 만들었다.
		
		model.addAttribute("page", curpage);//현재 페이지 번호
		model.addAttribute("pageSize", pageSize); //화면에 나올 리스트 개수

		
		PageVO pagevo = new PageVO();
		pagevo.setPage(curpage);
		pagevo.setPageSize(pageSize);
		
		Map<String , Object> maps = memberservice.selectMemberPageList(pagevo);
		model.addAttribute("memberList", maps.get("memberList")); //페이지에 따른 멤버리스트
		model.addAttribute("pages", maps.get("pages")); // 총 페이지수
		
		logger.debug("memberList : {} , pages : {}", maps.get("memberList"), maps.get("pages"));
		
		return "member/memberlist";
	}
	
	// 각 멤버 정보
	@RequestMapping(path ="/member", method = {RequestMethod.GET})
	public String getMember(String userid, Model model,
			 HttpServletRequest request, HttpServletResponse response) {
		
		MemberVO membervo = memberservice.getMember(userid);
		model.addAttribute("memberVo", membervo);

		return "member/member";
	}
	
	// 이미지 출력
	@RequestMapping(path ="/profileImg", method = {RequestMethod.GET})
	public void profileImge(String userid, HttpServletResponse response) throws IOException {
		
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
	

	
	// 파일 다운로드
	@RequestMapping(path ="/profileDownload")
	public void ProfileDownload(String userid, HttpServletResponse response) throws IOException {
			
		
		// db에서 사용자 filename 확인
		MemberVO membervo = memberservice.getMember(userid);
		
		// response content-type 설정
		response.setContentType("image/png");
		response.setHeader("Content-Disposition", "attachment; filename=\""+membervo.getRealfilename()+"\"");
		response.setContentType("application/octet-stream");//파일을 다운로드할때는 octet-stream을 사용한다.
	
		// 경로 확인 후 파일 입출력을 통해 응답 생성
		// 1. 파일 읽기   
		// 2. 응답 생성
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
	
	
	// 멤버 등록버튼
	@RequestMapping(path ="/memberRegist", method = {RequestMethod.GET})
	public String memberRegist() {

		return "member/memberRegist";
	}
	
	// 멤버 등록
	@RequestMapping(path ="/memberInsert", method = {RequestMethod.POST})
	public String memberInsert(MemberVO memberVo ,@RequestPart("realFilename")MultipartFile file) throws IOException, ServletException {		
		
		logger.debug("userid : {}", memberVo.getUserid());
		logger.debug("name : {} / filename : {} / size : {}",
						file.getName(), file.getOriginalFilename(), file.getSize());
		
		
		String filepath ="";
		if(file.getSize()>0) {
			String filename = UUID.randomUUID().toString();
			String extension = FileUpdloadUtil.getExtenstion(file.getOriginalFilename());
			filepath = "E:\\profile\\" + filename +"."+ extension;
			File uploadFile = new File(filepath);
			file.transferTo(uploadFile);
			
			memberVo.setRealfilename(file.getOriginalFilename());
			memberVo.setFilename(filepath);
		}
		
		logger.debug("memberVo: {}", memberVo);
		int insertCnt = memberservice.inserMember(memberVo);
		logger.debug("insertCnt : {}",insertCnt);
		
		if(insertCnt >0) { // 1건이 입력되었을때 : 정상
			
			// 서버의 상태가 바뀔경우 새로고침시 오류가 발생하므로 redirect를 써주어야한다.-> 사용자페이지 조회요청
			return "redirect:/member/memberlist";
			
		}else {	// 1건이 아닐때 : 비정상
			
			return "member/memberRegist";
		}
		
		
	}
	
	
	// 멤버 정보 수정버튼
	@RequestMapping(path ="/memberalter", method = {RequestMethod.GET})
	public String memberUpdateget(String userid, Model model) {
		
		MemberVO memberVo = memberservice.getMember(userid);		
		model.addAttribute("memberVo", memberVo);
				
		return "member/memberUpdate";
	}
	
	
	// 멤버 정보 수정버튼
	@RequestMapping(path ="memberupdate", method = {RequestMethod.POST})
	public String memberUpdate(MemberVO memberVo, @RequestPart("realFilename")MultipartFile file,
								Model model, RedirectAttributes ra) throws IllegalStateException, IOException {
		
		String filepath ="";
		if(file.getSize()>0) {
			String filename = UUID.randomUUID().toString();
			String extension = FileUpdloadUtil.getExtenstion(file.getOriginalFilename());
			filepath = "E:\\profile\\" + filename +"."+ extension;
			File uploadFile = new File(filepath);
			file.transferTo(uploadFile);
			
			memberVo.setRealfilename(file.getOriginalFilename());
			memberVo.setFilename(filepath);
		}
		ra.addAttribute("userid", memberVo.getUserid());
		int updateCnt = memberservice.updateMember(memberVo);	
		
		if(updateCnt>0) {			
			return "redirect:/member/member";
		}else {
//			model.addAttribute("memberVo", memberVo);
			return "member/memberUpdate";		
		}
						
	}
	
}
