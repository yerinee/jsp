package kr.or.ddit.config.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardServiceI;

@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"})
public class JavaSpringScanConfig {
	
	@Resource(name ="boardRepository")
	private BoardRepositoryI boardRepository;
	
	@Resource(name ="boardService")
	private BoardServiceI boardService;
	
	
	// boardRepository, boardService 스프링 빈이 정상적으로 등록 되었는지 확인
	@Test
	public void beanTest() {
		/***Given***/
		

		/***When***/
		BoardVo boardVo = boardService.getBoard(1);
		
		/***Then***/
		assertNotNull(boardRepository);
		assertNotNull(boardService);
		assertEquals("첫번째 글", boardVo.getTitle());
	}
}
