package kr.or.ddit.fileupload;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// maxFileSize : 파일 하나당 최대 허용 크기
// maxRequestSize : 요청에 담긴 모든 사이즈
// 단위 : byte
// 1MB = 1024KB = 1024 * 1024
// 10MB = 1024 * 1024 * 15

@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize =1024 *1024*26 )
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static final Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("get request.getcontentType() : {} " , request.getContentType());
		request.getRequestDispatcher("/fileupload/uploadView.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("post request.getcontentType() : {} " , request.getContentType());
		
		String userid = request.getParameter("userid");
		String img = request.getParameter("img");
		
//		request.getInputStream()
//		BufferedReader br = request.getReader();
//		char[] buffer = new char[512];
//		while(br.read(buffer) != -1) {
//			for(int i =0; i< buffer.length;i++) {
//				System.out.print(buffer[i]);
//			}
//		}
		
		logger.debug("userid : {}", userid );
		logger.debug("img : {}" , img);
		
		Part imgPart = request.getPart("img");
	 	logger.debug("getName() : {}", imgPart.getName());
	 	logger.debug("getSize() : {}", imgPart.getSize());
	 	logger.debug("getContentType() : {}", imgPart.getContentType());
	 	logger.debug("Content-Disposition : {}", imgPart.getHeader("Content-Disposition"));
	 	String fileName =FileUpdloadUtil.getFilename(imgPart.getHeader("Content-Disposition"));
	 	
	 	imgPart.write("e:\\upload\\" + fileName);
	 	imgPart.delete();//불필요하게 사용한 부분에대한 제거
	 	
	}

}
