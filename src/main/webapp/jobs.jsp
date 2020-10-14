<%@page import="kr.or.ddit.job.model.JobsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jsp</title>
<%@include file ="/layout/commonLib.jsp" %>
</head>
<body>

<%@ include file="/layout/header.jsp" %>	
<div class="container-fluid">
	<div class="row">
			
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="/layout/left.jsp" %>	
		</div>

		

		<%
			if(request.getAttribute("joblist")!= null){	
				List<JobsVO> joblist = (List<JobsVO>)request.getAttribute("joblist");
		%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 jobs">
				<h2 class="sub-header">JOBS</h2>
				<table class="table table-striped">
				<tr><th>Job_Id</th><th>Job_Title</th></tr>
			<% 
					for(int i =0; i<joblist.size();i++){
			%>
	
				<tr>
					<td class ="jid"><%=joblist.get(i).getJob_id() %></td>
					<td><%=joblist.get(i).getJob_title() %></td>
				</tr>
		
				
				<%	}}%>
				</table>
			</div>
	</div>
		
</div>

</body>
</html>