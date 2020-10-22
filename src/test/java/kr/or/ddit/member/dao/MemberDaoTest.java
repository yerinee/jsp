package kr.or.ddit.member.dao;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberDaoTest {

	// 테스트 메소드 실행순서(테스트 메소드마다 실행됨) : @Before -> @Test -> @After
	// @BeforeClass  Test메소드가 실행되기전에 딱 한번만 실행된다.
	
	// @AfterClass(static) 인자가 static이어야하므로 잘 사용하지 않는다.
	
	MemberDaoI memberDao ;
	
	@Before
	public void setup() {
		memberDao = new MemberDao();
		String userid = "nyr";
		
		memberDao.deleteMember(userid);
	}
	
	// 실행하려고하는 메소드의 이름뒤에 test만 붙여준다.
	@Test
	public void getMembertest() {
		/***Given***/
		
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		
		/***When***/
		MemberVO memberVo = memberDao.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
		//assertEquals(answerMemberVo.toString(), memberVo.toString());
	}
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
	
	
		/***When***/
		List<MemberVO> memberlist = memberDao.selectAllMember();
		
		/***Then***/
		assertEquals(15, memberlist.size());

	}
	
	@Test
	public void getAllpageTest() {
		/***Given***/

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
	
		SqlSession sqlSession = MybatisUtil.getSqlSession();
	
		/***When***/
		int cnt = memberDao.selectMemberCount(sqlSession);
		
		/***Then***/

		assertEquals(15, cnt);
	}
	
	@Test
	public void insertMemberTest() {
		/***Given***/

		MemberVO membervo 
			= new MemberVO("nyr", "1234","예리니","rinee","대전 중구 중앙로 76", "영민빌딩 404호",
							"34940", "e:\\profile\\nyr.png","nyr.png");
		
		

		/***When***/
		int insertcnt = memberDao.inserMember(membervo);
		
		/***Then***/
		assertEquals(1, insertcnt);
	}
	
	@Test
	public void updateMemberTest() {
		/***Given***/
	
		MemberVO membervo 
		= new MemberVO("nyr123", "1234","예리니","rinee","대전 중구 중앙로 76", "영민빌딩 404호",
						"34940", "e:\\profile\\nyr.png","nyr.png");
		
//		MemberVO membervo = new MemberVO();
//		membervo.setUserid("nyr123");
//		membervo.setUsernm("예리닝");
//		membervo.setAddr1("대전시");
//		membervo.setAddr2("123");
//		membervo.setAlias("예링");
//		membervo.setPass("12354");
//		membervo.setZipcode("85421");
//		
	
		/***When***/
		int updateCnt = memberDao.updateMember(membervo);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}

}
