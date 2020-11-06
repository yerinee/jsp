package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public interface MemberDaoI {
	
	// 해당 멤버정보
	MemberVO getMember(String userId);
	
	// 등록된 모든 멤버리스트
	List<MemberVO> selectAllMember();
	
	// map을 이용한 페이징 처리
	List<MemberVO> getAllpage(SqlSession sqlSession, Map<String, Integer> map);
	
	// vo를 이용한 페이징 처리
	List<MemberVO> selectAllMemberPage(SqlSession sqlSession, PageVO pagevo);
	
	// 멤버테이블에 담긴 멤버수
	int selectMemberCount(SqlSession sqlSession);
	
	// 새로운 멤버 등록
	int inserMember(MemberVO memberVo);
	
	// 등록된 멤버 삭제
	int deleteMember(String userid);
	
	// 멤버 정보 수정
	int updateMember(MemberVO memberVo);
}
