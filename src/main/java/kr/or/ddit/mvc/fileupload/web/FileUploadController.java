package kr.or.ddit.mvc.fileupload.web;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/fileupload")
//@Controller
public class FileUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	// localhost/fileupload/view 요청시
	// jsp로 응답 생성
	// jsp에서는 파일을 선택할 수 있는 input 태그 1개
	// userid 파라미터를 보낼수 있는 input 태그 1개
	// 전송을 담당하는 submit input 태그 1개를 작성
	// jsp : /WEB-INF/views/fileupload/fileupload.jsp
	// 테스트 코드까지 작성
	
	
	@RequestMapping("/view")
	public String getView() {
		return "fileupload/fileupload";
	}
	
	// MemberVO에서도 MultiparFile타입의 변수를 선언해서 사용할수 있다.
	// 따라서 파라미터를 여러개 선언하지 않고 MemberVO만 선언하여 한번에 가져올 수 있다.
	// 파일 업로드 처리 메소드0
	@RequestMapping(path="/upload")
	public String process(String userid, @RequestPart("file")MultipartFile file) {
		
		logger.debug("userid : {}", userid);
		logger.debug("name : {} / filename : {} / size : {}",
						file.getName(), file.getOriginalFilename(), file.getSize());
		
		File uploadFile = new File("e:\\upload\\" + file.getOriginalFilename());
		try {
			// 실제 파일로 변경시켜준다.
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "fileupload/fileupload";
	}
}
