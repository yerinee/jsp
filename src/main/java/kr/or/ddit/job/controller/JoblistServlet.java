package kr.or.ddit.job.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.job.model.JobsVO;
import kr.or.ddit.job.service.JobsService;
import kr.or.ddit.job.service.JobsServiceI;

/**
 * Servlet implementation class JoblistServlet
 */
@WebServlet("/JoblistServlet")
public class JoblistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JobsServiceI service = new JobsService();
		List<JobsVO> joblist = service.getAlljobs();
		
		request.setAttribute("joblist", joblist);
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}



}
