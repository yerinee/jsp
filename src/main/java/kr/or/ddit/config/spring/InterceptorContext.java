package kr.or.ddit.config.spring;



import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import kr.or.ddit.mvc.interceptor.PerformanceCheckInterceptor;
import kr.or.ddit.mvc.interceptor.SessionCheckInterceptor;

/*
 interceptor-context.xml 의 내용을 java코드로 변경
 
		1.
		<mvc:interceptor>
			mvc:mapping 의 어떤 인터셉터로 요청이 왔을때 아래 bean으로 등록하겠다.
			<mvc:mapping path="/**"/>
			<bean class="kr.or.ddit.mvc.interceptor.PerformanceCheckInterceptor"></bean>
		</mvc:interceptor>
		
		2.
		<mvc:interceptor>
			<mvc:mapping path="/**"/>
 			제외시킬 대상  
			<mvc:exclude-mapping path="/login/**"/>
			<mvc:exclude-mapping path="/js/**"/>
			<mvc:exclude-mapping path="/css/**"/>
			<mvc:exclude-mapping path="/resources/**"/>
			<bean class="kr.or.ddit.mvc.interceptor.SessionCheckInterceptor"></bean>
		</mvc:interceptor>

 */


// 사용하고 있지 않아서 주석처리
//@Configuration
public class InterceptorContext extends WebMvcConfigurerAdapter {
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//1.
		registry.addInterceptor(new PerformanceCheckInterceptor()).addPathPatterns("/**");
		
		//2.
		registry.addInterceptor(new SessionCheckInterceptor())
									.addPathPatterns("/**")
										.excludePathPatterns("login/**")
										.excludePathPatterns("js/**")
										.excludePathPatterns("css/**")
										.excludePathPatterns("resources/**");
		
		
	}
}
