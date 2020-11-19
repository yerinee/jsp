package kr.or.ddit.config.spring;



import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

/*
  	1.
  	<context:property-placeholder location="classpath:kr/or/ddit/config/db/db.properties"/>
	
	2.
	<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
		<property name="url" value="${jdbc.url}"/>
		<property name="driverClassName" value="${jdbc.driver}"/>
		<property name="username" value="${jdbc.username}"/>
		<property name="password" value="${jdbc.password}"/>
	</bean>
	
	3.
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="configLocation" value="classpath:kr/or/ddit/config/db/mybatis-config.xml"/>
		<!-- 다른 스프링빈을 참조하는것이기 때문에 value가 아닌 레퍼런스를 이용한다. -->
		<property name="dataSource" ref="dataSource"/>
	</bean>
	
	4.
	<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
		<!-- 기본생성자가 존재하지 않아 에러가 남으로 기본생성자를 만들어준다. -->
		<constructor-arg ref="sqlSessionFactory"/>
	</bean>
 
 */

//1.
@PropertySource("classpath:kr/or/ddit/config/db/db.properties")
@Configuration
public class DataSourceContext {

	// 프로퍼티스에 접근가능 하게 선언
	@Autowired
	private Environment env;
	
	
	// <bean> --> @Bean이 붙은 method
	//2.
	@Bean
	public DataSource dataSource() {
		
		BasicDataSource datasource = new BasicDataSource();
		
		datasource.setUrl(env.getProperty("jdbc.url"));
		datasource.setDriverClassName(env.getProperty("jdbc.driver"));
		datasource.setUsername(env.getProperty("jdbc.username"));
		datasource.setPassword(env.getProperty("jdbc.password"));
		
			
			
		return datasource;
	}
	
	//3.
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		
		factoryBean.setConfigLocation(new ClassPathResource("kr/or/ddit/config/db/mybatis-config.xml"));
		// 다른 스프링빈 호출하는 방법 => 해당 메소드를 호출한다.
		factoryBean.setDataSource(dataSource());
		
		return factoryBean.getObject();
	}
	
	//4.
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate =
				new SqlSessionTemplate(sqlSessionFactoryBean());
		
		return sqlSessionTemplate;
	}
	
	
	
}
