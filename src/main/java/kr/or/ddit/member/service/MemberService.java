package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

@Transactional
@Service("memberService")
public class MemberService implements MemberServiceI {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Resource(name="memberRepository")
	private MemberDaoI memberDao;
	
	// 생성자를 사용해서 생성하는대시 memberRepository의 빈을 입력받아 사용하도록한다.
	public MemberService() {
//		memberDao = new MemberDao();
	}
	
	@Override
	public MemberVO getMember(String userId) {
		
		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVO> selectAllMember() {

		return memberDao.selectAllMember();
	}
	
	// Map 새로 만들어서 pageSize와 pages를 정의할 경우
	@Override
	public Map<String , Object> getAllpage(Map<String, Integer> map) {
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		
		map2.put("memberList", memberDao.getAllpage(map));
		
		int totalCnt = memberDao.selectMemberCount();
		int pages = (int)Math.ceil((double)totalCnt/ map.get("pageSize"));
		map2.put("pages", pages);
		
		return map2;
	}

	
	// PageVO를 새로 만들어서 pageSize와 pages를 정의할 경우
	@Override
	public Map<String, Object> selectMemberPageList(PageVO pagevo) {
		
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("memberList", memberDao.selectAllMemberPage(pagevo));
		int totalCnt = memberDao.selectMemberCount();
		int pages = (int)Math.ceil((double)totalCnt/ pagevo.getPageSize());
		map.put("pages", pages);
		
//		sqlSession.close();
		return map;
	}

	@Override
	public int inserMember(MemberVO memberVo) {
		
		// 첫번째 쿼리는 정상적으로 실행되지만 
		// 두번째 쿼리에서는 동일한 데이터를 입력하여 PRIMARY KEY 제약조건에 의해
		// SQL 실행 실패
		// 첫번쨰 쿼리는 성공했지만 트랜잭션 설정을 service 레벨에 설정을 하였기 때문에
		// 서비스 메소드에서 실행된 모든 쿼리를 rollback 처리한다.
		// 실패하면 자동으로 롤백을 해주기때문에 DB에는 저장되지 않는다.
		
//		logger.debug("첫번째 insert 시작전");
//		memberDao.inserMember(memberVo);
//		logger.debug("첫번째 insert 종료후");
//		
//		logger.debug("두번째 insert 시작전");
//		memberDao.inserMember(memberVo);
//		logger.debug("두번째 insert 종료후");
//		
//		return 1;
		
		return memberDao.inserMember(memberVo);
	}

	@Override
	public int deleteMember(String userid) {
		return memberDao.deleteMember(userid);
	}

	@Override
	public int updateMember(MemberVO memberVo) {
		
		return memberDao.updateMember(memberVo);
	}

	
	
	
}
