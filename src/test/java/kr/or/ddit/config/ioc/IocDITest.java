package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.person.model.Person;

// -- jUnit을 main메소드 없이 실행시키는 방법 -- //

// 1. runner설정을한다.
@RunWith(SpringJUnit4ClassRunner.class)
// 2. 설정파일 설정
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/ioc.xml"})
public class IocDITest {
	
	// ioc.xml을 바탕으로 스프링 빈이 잘 생성되었는지 확인
	// setter-boardService, constructor-boardServiceC 주입 확인
	
	
	// 스프링 컨네이너에있는 스프링빈을 @Autowired를 통해 주입 받을수있다.
	// DI : 컨테이너를 얻어올수 있다.
	@Autowired // 스프링 빈중에 호환되는 타입의 빈이 있을 때 주입
	ApplicationContext context;
	
	// 스프링 빈을 직접 주입을 받을 수도있다.
	// 내가 주입을 받고싶은 리소스 이름을 쓰면된다. ==> 스프링 컨테이너안에 등록이 되어있을때 사용할 수 있다.
	// 스프링 컨테이너가 관리해야 사용할수 있다.
	// 서블릿은 톰캣이 관리하기때문에 서블릿내에서 사용할 수 없다.
	@Resource(name = "boardService")
	BoardService boardService;
	
	
	@Resource(name = "boardServiceC")
	BoardService boardServiceC;
	
	@Resource(name = "person")
	Person person;
	
	// person 스프링빈의 age(value), boardRepository(ref) 두 속성에 주입이 잘 되었는지 확인
	@Test
	public void valueRefTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertEquals(30, person.getAge());
		assertEquals("내용", person.getBoardRepository().getBoard(1).getContent());
		
	}
	
	
	// boardService, boardServiceC 스프링빈에 주입한 boardRepository 스프링빈은 
	// 동일한 빈이므로 두 객체의 getter 메소드를 통해 얻어온 boardRepository 객체는 동일해야 한다.
	
	@Test
	public void repositorySameTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertEquals(boardService.getBoardRepository(), boardServiceC.getBoardRepository());
	}
	
	@Test
	public void DIAutowiredTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotNull(boardService);
	}
	
	
	// 스프링 컨테이너를 주입받아 DL을 통해 boardService 스프링 빈이 제대로 생성되었는지 확인
	@Test
	public void DItest() {
		/***Given***/
		

		/***When***/
		BoardServiceI boardService = context.getBean("boardService", BoardServiceI.class);
		
		BoardVo boardVo = boardService.getBoard(1);

		/***Then***/
		assertEquals("첫번째 글", boardVo.getTitle());
	}
	


}
