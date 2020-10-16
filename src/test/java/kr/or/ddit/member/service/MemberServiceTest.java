package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	// 실행하려고하는 메소드의 이름뒤에 test만 붙여준다.
	@Test
	public void getMembertest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserId("brown");
		answerMemberVo.setPass("brownPass");
		
		/***When***/
		MemberVO memberVo = memberService.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserId());
		assertEquals("brownPass", memberVo.getPass());
		
		//assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void getAllpage() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		
		//PageVO pageVo = new PageVO(1,7)
		Map<String, Integer> map = new HashMap<>();
		map.put("page", 1);
		map.put("pageSize", 7);
		
		/***When***/
		//memberList확인
		Map<String, Object> map2 = memberService.getAllpage(map);
//		/Map<String, Object> map2 = memberService.getAllpage(pageVo) vo를 사용할 경우
		List<MemberVO> memlist = (List<MemberVO>)map2.get("memberList");
		
		//생성해야할 page 수 
		int pages = (int)map2.get("pages");
		
		/***Then***/

		
		assertEquals(7, memlist.size());
		assertEquals(3, pages);
	}
	
	@Test
	public void localeListTest() {
		
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale locale : locales) {
			logger.debug(locale.toString());
			logger.debug("{}", locale); //위와 동일
			
		}
	}
	
	
	
	

}
