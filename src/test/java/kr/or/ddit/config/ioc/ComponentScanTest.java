package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/component-scan.xml"})
public class ComponentScanTest {

	@Resource(name ="boardRepository")
	private BoardRepositoryI boardRepository;
	
	@Resource(name ="boardService")
	private BoardServiceI boardService;
	
	
	@Test
	public void componentScanTest() {
		/***Given***/
		

		/***When***/
		BoardVo boardVo = boardService.getBoard(1);
		
		/***Then***/
		assertNotNull(boardRepository);
		assertNotNull(boardService);
		assertEquals("첫번째 글", boardVo.getTitle());
		
	}
	
	

}
