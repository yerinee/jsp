package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;

public class SessionAttributeListener implements HttpSessionAttributeListener{
	
	private static final Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	
	// 			userId , MemberVO
	private Map<String, MemberVO> userMap = new HashMap<String, MemberVO>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if("S_MEMBER".equals(event.getName())) {
			
			
			// HttpSession session = event.getSession(); 
			// MemberVO memberVo = (MemberVO) session.getAttribute("S_MEMBER");
			
			// 위의 두줄을 아래 한줄로 표현할 수 있다.
			MemberVO memberVo = (MemberVO)event.getValue();
			logger.debug("사용자 로그인 : {} " , memberVo.getUserId());
			
			userMap.put(memberVo.getUserId(), memberVo);
			
			ServletContext sc = event.getSession().getServletContext();
			
			sc.setAttribute("userMap", userMap);
			
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
		if("S_MEMBER".equals(event.getName())) {
			
			MemberVO memberVo = (MemberVO)event.getValue();
			userMap.remove(memberVo.getUserId());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}
	
}
