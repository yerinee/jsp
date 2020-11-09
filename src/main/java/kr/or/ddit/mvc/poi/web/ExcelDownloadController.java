package kr.or.ddit.mvc.poi.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ExcelDownloadController {
	
	@RequestMapping("/excelDown")
	public String excelDown(Model model) {
		
		
		// Model 객페에 header, data
		List<String> header = new ArrayList<String>();
		header.add("userid");
		header.add("usernm");
		
		
//		List<MemberVO> data = new ArrayList<MemberVO>();	
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();		
		Map<String, String > map = new HashMap<String, String>();
		map.put("userid", "brown");
		map.put("usernm", "브라운");
		
		Map<String, String > map2 = new HashMap<String, String>();
		map2.put("userid", "sally");
		map2.put("usernm", "샐리");
		
//		data.add(new MemberVO("brown","브라운"));
//		data.add(new MemberVO("sally","샐리"));
//		data.add(new MemberVO("cony","코니"));
		
		data.add(map);
		data.add(map2);
		
		model.addAttribute("header", header);
		model.addAttribute("data", data);
		
		
		return "excelView";
	}
}
