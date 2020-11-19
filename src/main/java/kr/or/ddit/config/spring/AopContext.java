package kr.or.ddit.config.spring;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
 aop.xml 의 내용을 java코드로 변경
 	
 	1.
	<aop:aspectj-autoproxy/> 
 
 	2.
	<!-- @ControllerAdvice -->
	<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
		<context:include-filter type="annotation" expression="org.aspectj.lang.annotation.Aspect"/>
	</context:component-scan>
 
 */

// 1.
@EnableAspectJAutoProxy


//2.
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false,
				includeFilters = {@Filter(type=FilterType.ANNOTATION, classes= {Aspect.class})})
@Configuration
public class AopContext {

	
}
