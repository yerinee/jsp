package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberService implements MemberServiceI {
	
	private MemberDaoI memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	@Override
	public MemberVO getMember(String userId) {
		
		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVO> selectAllMember() {

		return memberDao.selectAllMember();
	}
	
	
}
