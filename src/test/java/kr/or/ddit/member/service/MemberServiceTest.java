package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest extends ModelTestConfig{

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@Test
	public void insertMember_SUCCESS_Test() {
		/***Given***/
		MemberVO memberVo = new MemberVO("ddit", "dditpass", "대덕인재", "개발원", "", "", "", "", "");

		/***When***/
		int insertCnt = memberService.inserMember(memberVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	//@Test
	public void insertMember_FAIL_Test() {
		/***Given***/
		MemberVO memberVo = new MemberVO("ddit", "dditpass", "대덕인재", "개발원", "", "", "", "", "");
		
		/***When***/
		int insertCnt = memberService.inserMember(memberVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}

	
}
