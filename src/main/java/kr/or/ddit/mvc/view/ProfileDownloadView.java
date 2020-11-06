package kr.or.ddit.mvc.view;

import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class ProfileDownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String realfilename = (String)model.get("realfilename");
		String filepath = (String)model.get("filepath");
		
		// response content-type 설정
		response.setContentType("image/png");
		response.setHeader("Content-Disposition", "attachment; filename=\""+realfilename+"\"");
		response.setContentType("application/octet-stream");//파일을 다운로드할때는 octet-stream을 사용한다.
	
		// 경로 확인 후 파일 입출력을 통해 응답 생성
		// 1. 파일 읽기   
		// 2. 응답 생성
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
