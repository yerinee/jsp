package kr.or.ddit.jobs.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.job.model.JobsVO;
import kr.or.ddit.job.service.JobsService;
import kr.or.ddit.job.service.JobsServiceI;

public class JobsServiceTest {

	@Test
	public void getAlljobsTest() {
		/***Given***/
		JobsServiceI jobservice = new JobsService();
		
		/***When***/
		List<JobsVO> joblist = jobservice.getAlljobs();
		
		/***Then***/
		assertEquals(19, joblist.size());
	}
}
