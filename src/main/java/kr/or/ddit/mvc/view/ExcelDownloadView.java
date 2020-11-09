package kr.or.ddit.mvc.view;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.servlet.view.AbstractView;


public class ExcelDownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<String> header = (List<String>) model.get("header");
		List<Map<String, String>> data = (List<Map<String, String>>)model.get("data");
		
		// excel 파일 contentType : application/vnd.ms-excel; UTF-8
		response.setContentType("application/vnd.ms-excel; utf-8");
		
		// 첨부파일임을 암시(다운로드기능)
		response.setHeader("Content-Dispotition", "attachment; filename=test.xlsx");
		
		// poi 라이브러리를 이용해서 엑셀파일을 생성
		Workbook workbook = new XSSFWorkbook();
		
		// 시트생성
		Sheet sheet = workbook.createSheet("lineFriends");
		
		//행설정
		int rownum = 0;
		int colnum = 0;
		Row row = sheet.createRow(rownum++);
		
		// 헤더 설정
		for(String h : header) {
			
			row.createCell(colnum++).setCellValue(h);
		} 
		
		// 데이터 설정
		for(Map<String, String> map : data) {
			row = sheet.createRow(rownum++);
			
			colnum=0;
			row.createCell(colnum++).setCellValue(map.get("userid"));
			row.createCell(colnum++).setCellValue(map.get("usernm"));
		}
		
		OutputStream os = response.getOutputStream();
		workbook.write(os);
		
		os.flush();
		os.close();
		
	
	}

}
