package kr.or.ddit.member.dao;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberDaoTest {

	// 실행하려고하는 메소드의 이름뒤에 test만 붙여준다.
	@Test
	public void getMembertest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserId("brown");
		answerMemberVo.setPass("brownPass");

		
		/***When***/
		MemberVO memberVo = memberDao.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserId());
		assertEquals("brownPass", memberVo.getPass());
		
		//assertEquals(answerMemberVo.toString(), memberVo.toString());
	}
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
	
		/***When***/
		List<MemberVO> memberlist = memberDao.selectAllMember();
		
		/***Then***/
		assertEquals(15, memberlist.size());

	}
	
	@Test
	public void getAllpageTest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		//PageVO pageVo = new PageVO(1,7) // vo로 사용한 경우
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Map<String, Integer> map = new HashMap<>(); // map으로 사용한 경우
		map.put("page", 1);
		map.put("pageSize", 7);
	
		/***When***/
		List<MemberVO> memberlist = memberDao.getAllpage(sqlSession, map);
		//List<MemberVO> memberlist = memberDao.getAllpage(pageVo);
		
		/***Then***/
		int a= map.get("pageSize");
		assertEquals(a, memberlist.size());

	}
	
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		PageVO pageVo = new PageVO(1,7); // vo로 사용한 경우
		SqlSession sqlSession = MybatisUtil.getSqlSession();
	
		/***When***/
		//List<MemberVO> memberlist = memberDao.getAllpage(map);
		List<MemberVO> memberlist = memberDao.selectAllMemberPage(sqlSession, pageVo);
		
		/***Then***/
		//int a= map.get("pageSize");
		assertEquals(7, memberlist.size());

	}
	
	
	@Test
	public void selectMemberCountTest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
	
		/***When***/
		int cnt = memberDao.selectMemberCount(sqlSession);
		
		/***Then***/

		assertEquals(15, cnt);
	}

}
