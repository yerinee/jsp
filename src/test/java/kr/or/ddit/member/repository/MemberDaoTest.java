package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;


public class MemberDaoTest extends ModelTestConfig{

	@Resource(name="memberRepository")
	private MemberDaoI memberDao;
	
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		

		/***When***/
		List<MemberVO> memberlist = memberDao.selectAllMember();
		
		
		/***Then***/
		assertEquals(38, memberlist.size());
	}
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userid = "ddit";

		/***When***/
		MemberVO memberVo = memberDao.getMember(userid);
		
		
		/***Then***/
		assertEquals("ddit", memberVo.getUserid());
		assertEquals("dditpass", memberVo.getPass());
	}
	
	@Test
	public void getAllpage() {
		/***Given***/	
		PageVO pageVo = new PageVO(1,7);
		
		
		/***When***/
		List<MemberVO> memlist = memberDao.selectAllMemberPage(pageVo);
		
		/***Then***/
		assertEquals(7, memlist.size());
	}
	
	@Test
	public void selectMemberCountTest() {
		/***Given***/	
		
		
		
		/***When***/
		int memberCnt = memberDao.selectMemberCount();
		
		/***Then***/
		assertEquals(38, memberCnt);
	}
	
	@Test
	public void insertMember_SUCCESS_Test() {
		/***Given***/
		MemberVO memberVo = new MemberVO("temp2", "dditpass", "대덕인재", "개발원", "", "", "", "", "");

		/***When***/
		int insertCnt = memberDao.inserMember(memberVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	
	@Test
	public void deleteMemberTest() {
		/***Given***/
		
		String userid = "ddit";
		
		/***When***/
		int delCnt = memberDao.deleteMember(userid);
	
		/***Then***/
		assertEquals(1, delCnt);
	}

	@Test
	public void updateMember_SUCCESS_Test() {
		/***Given***/		
		MemberVO memberVo = new MemberVO("ddit", "dditpass", "대덕", "개발원", "", "", "", "", "");

		
		/***When***/
		int updateCnt = memberDao.updateMember(memberVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}

}
