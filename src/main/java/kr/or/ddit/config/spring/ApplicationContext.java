package kr.or.ddit.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.or.ddit.mvc.view.ExcelDownloadView;
import kr.or.ddit.mvc.view.ProfileDownloadView;
import kr.or.ddit.mvc.view.ProfileImgView;

/*
 application-context.xml 의 내용을 java코드로 변경
 
 	1.
	<context:component-scan base-package="kr.or.ddit" use-default-filters="false" >
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>	
		<context:include-filter type="annotation" expression="org.springframework.web.bind.annotation.ControllerAdvice"/>
	</context:component-scan>
 
 	2.
 	<bean id ="profileImgView" class="kr.or.ddit.mvc.view.ProfileImgView"/>
	<bean id ="profileDownloadView" class="kr.or.ddit.mvc.view.ProfileDownloadView"/>
	<bean id ="excelView" class="kr.or.ddit.mvc.view.ExcelDownloadView"/>
	<bean id ="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
	
	3.	
	<bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
		<property name="order" value="1"/>
	</bean
	
	4.
	<bean id="tilesConfigurer" class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>classpath:kr/or/ddit/config/tiles/tiles-definition.xml</value>
			</list>
		</property>
	</bean>
	
	5.
	<bean class="org.springframework.web.servlet.view.tiles3.TilesViewResolver">
		<property name="viewClass" value="org.springframework.web.servlet.view.tiles3.TilesView"/>
	 	 <!-- 우선순위가 높은 것먼저 실행하기때문에 value가 0인 것 먼저실행한다. -->
		<property name="order" value="0"/>
	</bean>
	
	6.
	<bean class ="org.springframework.web.servlet.view.InternalResourceViewResolver">	
		<property name="order" value="2"/>
		<property name="prefix" value="/WEB-INF/views/"></property>
		<property name="suffix" value=".jsp"></property>
	</bean>
	
	7.
	<mvc:annotation-driven/>
	
	8.
	<mvc:default-servlet-handler/>
	
	9.
	<bean id ="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>


	10.
	<bean id="localeResolver" class="org.springframework.web.servlet.i18n.SessionLocaleResolver"/>

	
	11.
	<mvc:resources mapping="/resources/**" location="/WEB-INF/views/error/"></mvc:resources>
	
	12.
	<mvc:interceptors>
		<mvc:interceptor>
			<mvc:mapping path="/**"/>
			<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
				<property name="paramName" value="lang"></property>
			</bean>
		</mvc:interceptor>
	</mvc:interceptors>
 */

// 7.
@EnableWebMvc
// 1.
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false,
				includeFilters = {@Filter(type=FilterType.ANNOTATION, 
									classes= {Controller.class, ControllerAdvice.class})})
@Configuration
public class ApplicationContext extends WebMvcConfigurerAdapter {
	
	//8.
	//<mvc:default-servlet-handler/> ==> interface 구현(WebMvcConfigurerAdapter)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		
		configurer.enable();
	}
	
	
	
	//2.
	@Bean
	public ProfileImgView profileImgView() {

		return  new ProfileImgView();
	}	
	@Bean
	public ProfileDownloadView profileDownloadView() {
		
		return new ProfileDownloadView();
		
	}	
	@Bean
	public ExcelDownloadView excelDownloadView() {
		
		return new ExcelDownloadView();
	}
	
	@Bean
	public MappingJackson2JsonView mappingJackson2JsonView() {
		
		return new MappingJackson2JsonView();
	}	
	
	//3.
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		
		beanNameViewResolver.setOrder(1);
		
		return beanNameViewResolver;
	}
	
	//4.
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("kr/or/ddit/config/tiles/tiles-definition.xml");
		
		return tilesConfigurer;
	}
	
	//5.
	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setOrder(0);
		tilesViewResolver.setViewClass(TilesView.class);
		
		return tilesViewResolver;
	}
	
	//6.
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
	}
	
	//9.
	@Bean
	public CommonsMultipartResolver commonsMultipartResolver() {
		
		return new CommonsMultipartResolver();
	}
	
	//10.
	@Bean 
	public SessionLocaleResolver sessionLocaleResolver() {
		
		return sessionLocaleResolver();
	}
	
	//11.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/views/error/");
	}
	
	
	//12.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
		
	}
}
