package kr.or.ddit.db;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisUtilTest {

	@Test
	public void test() {
		/***Given***/
		

		/***When***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		
		/***Then***/
		assertNotNull(sqlSession);
		
	}

}
