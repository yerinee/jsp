package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

@Repository("memberRepository")
public class MemberDao implements MemberDaoI{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public MemberVO getMember(String userId) {
		
		return sqlSession.selectOne("member.getMember", userId);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		return sqlSession.selectList("member.selectAllMember");
	}

	@Override
	public List<MemberVO> getAllpage(Map<String, Integer> map) {
		
		return sqlSession.selectList("member.getAllpage", map);
	}

	@Override
	public int selectMemberCount() {	

		return sqlSession.selectOne("member.selectMemberCount");
	}

	@Override
	public List<MemberVO> selectAllMemberPage(PageVO pagevo) {
	
		return sqlSession.selectList("member.selectAllMemberPage", pagevo);
	}

	@Override
	public int inserMember(MemberVO memberVo) {
		
		return sqlSession.insert("member.insertMember", memberVo);
	}

	
	@Override
	public int deleteMember(String userid) {

		return sqlSession.delete("member.deleteMember", userid);
	}

	@Override
	public int updateMember(MemberVO memberVo) {

		return sqlSession.update("member.updateMember", memberVo);
	}

}
