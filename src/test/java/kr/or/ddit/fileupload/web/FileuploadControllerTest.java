package kr.or.ddit.fileupload.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import kr.or.ddit.WebTestConfig;

public class FileuploadControllerTest extends WebTestConfig {
	
	@Test
	public void getViewTest() throws Exception {
		mockMvc.perform(get("/fileuplaod/view"))
			.andExpect(status().isOk())
//			.andExpect(view().name("fileupload/fileupload"))
			.andDo(print());
	}
	
	// 파일 테스트(응답이 왔느냐)
	@Test
	public void uploadTest() throws Exception {
		
		// 아래 fis를 간략하게 나타낸 코드
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/ryan.jpg");
				
		FileInputStream fis = new FileInputStream("E:\\A_TeachingMaterial\\6.JspSpring\\workspace\\spring\\src\\test\\resources\\kr\\or\\ddit\\upload\\ryan.jpg");
		
		MockMultipartFile file = new MockMultipartFile("file", "ryan.jpg", "image/jpg", is);
		mockMvc.perform(fileUpload("/fileupload/upload")
							.file(file)
							.param("userid", "브라운"))
				.andExpect(view().name("fileupload/fileupload"))
				.andExpect(status().isOk());
	}
}
