package kr.or.ddit.job.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.job.model.JobsVO;

public class JobsDao implements JobsDaoI{

	@Override
	public List<JobsVO> getAlljobs() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<JobsVO> joblist = sqlSession.selectList("jobs.getAlljobs");
		return joblist;
	}
	
}
