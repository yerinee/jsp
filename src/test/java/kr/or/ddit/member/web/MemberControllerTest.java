package kr.or.ddit.member.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.model.MemberVO;

public class MemberControllerTest extends WebTestConfig {
	

	
	@Test
	public void getMemberlistTest() throws Exception {
		mockMvc.perform(get("/member/memberlist")
					.param("page", "1"))
			.andExpect(status().is(200));
//			.andExpect(view().name("member/memberlist"));
	}
	
	@Test
	public void getMemberTest() throws Exception {
		mockMvc.perform(get("/member/member")
				.param("userid", "brown"))
			.andExpect(status().is(200))
			.andExpect(model().attributeExists("memberVo"));
//			.andExpect(view().name("member/member"));
	}
	
	@Test
	public void profileImageTest() throws Exception {
		mockMvc.perform(get("/member/profileImg")
				.param("userid", "brown"))
			.andExpect(status().is(200));
			
	}
	
	@Test
	public void ProfileDownloadTest() throws Exception {
		mockMvc.perform(get("/member/profileDownload")
				.param("userid", "brown"))
			.andExpect(status().is(200));
			
	}
	
	@Test
	public void memberRegistTest() throws Exception {
		mockMvc.perform(get("/member/memberRegist")
				.param("userid", "brown"))
			.andExpect(status().is(200));
//			.andExpect(view().name("member/memberRegist"));
			
	}
	
	///////
	@Test
	public void memberInsertTest() throws Exception {
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/ryan.jpg");
		
		MockMultipartFile realFilename = new MockMultipartFile("realFilename", "ryan.jpg", "image/jpg", is);
		
		mockMvc.perform(fileUpload("/member/memberInsert")
				.file(realFilename)
				.param("userid", "brown2")
				.param("usernm", "브라운")
				.param("pass", "1234")					
				.param("alias", "브라우니")					
				.param("addr1", "대전특별시 중구")	
				.param("addr2", "대흥동 454-12")	
				.param("zipcode", "12345"))		
			.andExpect(status().is(302));
//			.andExpect(view().name("member/memberRegist"));
		
	}
	
	@Test
	public void memberUpdategetTest() throws Exception {

		
		mockMvc.perform(get("/member/memberalter")
				.param("userid", "brown"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("memberVo"));
//		.andExpect(view().name("member/memberUpdate"));
		
	}
	
	////
	@Test
	public void memberUpdateTest() throws Exception {
		
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/ryan.jpg");
		
		MockMultipartFile realFilename = new MockMultipartFile("realFilename", "ryan.jpg", "image/jpg", is);
		
		mockMvc.perform(fileUpload("/member/memberupdate")
				.file(realFilename)
				.param("userid", "brown")
				.param("usernm", "브라운")
				.param("pass", "1234")					
				.param("alias", "브라우니")					
				.param("addr1", "대전특별시 중구")	
				.param("addr2", "대흥동 454-12")	
				.param("zipcode", "12345"))		
		.andExpect(status().is(302))
		.andExpect(model().attributeExists("userid"))
		.andExpect(view().name("redirect:/member/member"));
		
	}
	
	

}
