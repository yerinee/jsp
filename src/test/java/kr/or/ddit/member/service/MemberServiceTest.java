package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberServiceTest extends ModelTestConfig{

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@Test
	public void insertMember_SUCCESS_Test() {
		/***Given***/
		MemberVO memberVo = new MemberVO("temp", "dditpass", "대덕인재", "개발원", "", "", "", "", "");

		/***When***/
		int insertCnt = memberService.inserMember(memberVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	//@Test
//	public void insertMember_FAIL_Test() {
//		/***Given***/
//		MemberVO memberVo = new MemberVO("ddit", "dditpass", "대덕인재", "개발원", "", "", "", "", "");
//		
//		/***When***/
//		int insertCnt = memberService.inserMember(memberVo);
//		
//		/***Then***/
//		assertEquals(1, insertCnt);
//	}
	
	@Test
	public void getMembertest() {
		
		/***Given***/
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		/***When***/
		MemberVO memberVo = memberService.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
		//assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void getAllpage() {
		/***Given***/
		
		PageVO pageVo = new PageVO(1,7);
		
		
		/***When***/
		//memberList확인
		Map<String, Object> map2 = memberService.selectMemberPageList(pageVo);
//		/Map<String, Object> map2 = memberService.getAllpage(pageVo) vo를 사용할 경우
		List<MemberVO> memlist = (List<MemberVO>)map2.get("memberList");
		
		//생성해야할 page 수 
		int pages = (int)map2.get("pages");
		
		/***Then***/

		
		assertEquals(7, memlist.size());
		assertEquals(6, pages);
	}
	
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		

		/***When***/
		List<MemberVO> memberlist= memberService.selectAllMember();
		
		
		/***Then***/
		assertEquals(38,memberlist.size());
	}
	

	@Test
	public void deleteMemberTest() {
		/***Given***/
		
		String userid = "ddit";
		
		/***When***/
		int delCnt = memberService.deleteMember(userid);
	
		/***Then***/
		assertEquals(1, delCnt);
	}

	@Test
	public void updateMember_SUCCESS_Test() {
		/***Given***/		
		MemberVO memberVo = new MemberVO("ddit", "dditpass", "대덕", "개발원", "", "", "", "", "");

		
		/***When***/
		int updateCnt = memberService.updateMember(memberVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}

	
}
