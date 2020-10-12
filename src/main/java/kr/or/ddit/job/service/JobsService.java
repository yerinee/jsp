package kr.or.ddit.job.service;

import java.util.List;

import kr.or.ddit.job.dao.JobsDao;
import kr.or.ddit.job.dao.JobsDaoI;
import kr.or.ddit.job.model.JobsVO;


public class JobsService implements JobsServiceI {

	@Override
	public List<JobsVO> getAlljobs() {

		JobsDaoI jobdao = new JobsDao();
		
		return jobdao.getAlljobs();
	}
	
}
