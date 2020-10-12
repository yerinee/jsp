package kr.or.ddit.jobs.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.job.dao.JobsDao;
import kr.or.ddit.job.model.JobsVO;

public class JobsDaoTest {

	@Test
	public void getAlljobsTest() {
		/***Given***/
		JobsDao jobdao = new JobsDao();
		
		/***When***/
		List<JobsVO> joblist = jobdao.getAlljobs();
		
		/***Then***/
		assertEquals(19, joblist.size());
	}

}
