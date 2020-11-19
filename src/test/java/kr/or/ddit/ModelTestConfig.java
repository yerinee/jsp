package kr.or.ddit;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//repository + service : root-context.xml
//sqlSessionTemplate : datasource-context.xml
//transaction : transaction-context.xml 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml",
									"classpath:kr/or/ddit/config/spring/datasource-context_dev.xml",
									"classpath:kr/or/ddit/config/spring/transaction-context.xml"})
public class ModelTestConfig {
		
	@Resource(name ="dataSource")
	private DataSource dataSource;
	
	@Ignore
	@Test
	public void dummy() {
	}
	
	@Before
	public void setup() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		
		// 테스트 코드를 실행전에 insert, delete 시에도 에러가 발생하지 않도록 원래 db테이블에 있는 정보로 되돌려주는 것
		populator.addScripts(new ClassPathResource("kr/or/ddit/config/spring/db/initData.sql"));
		
		// 옵션__스크립트 실행중 에러가 발생하면 멈춰라
		populator.setContinueOnError(false);
		
		DatabasePopulatorUtils.execute(populator, dataSource);
	}
}


