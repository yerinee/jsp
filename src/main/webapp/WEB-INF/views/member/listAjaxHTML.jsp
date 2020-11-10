<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>


<c:forEach items="${memberList }" var="member">
	<tr data-userid="${member.userid }">	<!-- data는 userId의 값을 잠깐 저장을 해둘수 있다. -->
	
		<td>${member.userid }</td> 
		<td>${member.usernm }</td>
		<td>${member.alias }</td>
		
		<td><fmt:formatDate value="${member.reg_dt }" pattern="yyyy-MM-dd"/></td>
	</tr>
</c:forEach>
		

$$$$$SEPERATOR$$$$$

<c:forEach var="i" begin="1" end ="${pages }">
	<c:choose>
		<c:when test="${i == pageVO.page}">
			<li class="active"><span>${i }</span></li>
		</c:when>
		<c:otherwise>                                                                                                                                                                                                                                                                                                                                   
			<li><a href="javascript:memberListAjaxHTML(${i});">${i}</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>	


