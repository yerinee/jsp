package kr.or.ddit.config.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.repository.BoardRepository;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardService;

// 1. class @Configuration : spring 컨테이너에게 해당 java 파일이 스프링 설정파일임을 암시
@Configuration
public class JavaSpringConfig {

	// boardRepository, boardService
	
// 2. method @Bean : 해당 메소드에서 리턴하는 객체가 스프링 빈으로 등록
	// 메소드이름 --> 스프링 빈이름
	
	// xml : <bean id ="boardRepository(메소드이름)" class="BoardRepository"/> 와 동일하다.
	// 한번만 실행, 최초에 리턴한 값을 반복해서 출력
	
	@Bean
	public BoardRepositoryI boardRepository() {
		
		return new BoardRepository();
	}
	
	// xml : <bean id ="boardService(메소드이름)" class="BoardService"/> 와 동일하다.
	// 이 코드는 주입을 시켜줘야한다.
	@Bean
	public BoardService boardService() {
		BoardService boardService = new BoardService();
		boardService.setBoardRepository(boardRepository());
		
		// 아래와 같이 직접 new 연산자를 통해 생성한 객체는 스프링 빈이 아니다.
		// @Bean 어노테이션이 붙은 메소드를 호출해야 스프링 컨테이너에서 관리되는 스프링빈을 얻을 수 있다.
//		boardService.setBoardRepository(new BoardRepository());
		return boardService;
	}
	
}
