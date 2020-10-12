package kr.or.ddit.member.dao;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest2 {

	// 실행하려고하는 메소드의 이름뒤에 test만 붙여준다.
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		MemberDao memberDao = new MemberDao();
//		String userId = "brown";
//		
//		MemberVO answerMemberVo = new MemberVO();
//		answerMemberVo.setUserId("brown");
//		answerMemberVo.setPass("brownPass");
		
		/***When***/
		List<MemberVO> memberlist = memberDao.selectAllMember();
		
		/***Then***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("brownPass", memberVo.getPassword());
		equals(memberlist);
		//assertEquals(answerMemberVo.toString(), memberVo.toString());
	}

}
