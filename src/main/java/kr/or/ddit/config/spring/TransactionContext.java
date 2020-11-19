package kr.or.ddit.config.spring;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 	1.
 	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
	 	<property name="dataSource" ref="dataSource"></property>
	</bean>

	2.
	<tx:advice id ="txAdvisor" transaction-manager="transactionManager">
		<tx:attributes>			
			<tx:method name="*" />
		</tx:attributes>
	</tx:advice>

	<aop:config>
		<aop:advisor advice-ref="txAdvisor" pointcut="within(kr.or.ddit..service.*)"/>
	</aop:config>
	
 */

// 스프링 빈중에 PlatformTransactionManager타입의 빈이 있으면 해당 빈을 트랜잭션 매니저로 등록
// DataSourceContext에 등록된 dataSource스프링 빈을 주입받기 위해 선언
@EnableTransactionManagement
@Configuration
public class TransactionContext {
	
	//1.
	@Resource(name="dataSource")
	private DataSource datasource;
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		
		DataSourceTransactionManager tansactionManager = 
				new DataSourceTransactionManager(datasource);
		
		
		
		return tansactionManager;
	}
	
	//2.
	// <tx:advice id ="txAdvisor" 
	// <aop:config>
	// 위 두부분에 해당하는 java 설정은 없음
	// @Transactional 어노테이션을 트랜잭션으로 삼을 메소드나, 클래스 단위로 붙여준다.
	// 스프링 빈을 <bean> 엘레멘트를 통해 일일이 등록 ==> @Controller, @Service
}
