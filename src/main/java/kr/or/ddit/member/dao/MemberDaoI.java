package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public interface MemberDaoI {
	
	MemberVO getMember(String userId);
	
	List<MemberVO> selectAllMember();
	
	List<MemberVO> getAllpage(SqlSession sqlSession, Map<String, Integer> map);
	
	List<MemberVO> selectAllMemberPage(SqlSession sqlSession, PageVO pagevo);
	
	int selectMemberCount(SqlSession sqlSession);
}
