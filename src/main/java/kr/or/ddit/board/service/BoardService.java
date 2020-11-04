
package kr.or.ddit.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.repository.BoardRepositoryI;

// <bean id="boardService"/> 와 동일
@Service("boardService")
public class BoardService implements BoardServiceI {
	
	
	@Resource(name="boardRepository")
	
	private BoardRepositoryI boardRepository;
	
	// get
	public BoardRepositoryI getBoardRepository() {
		return boardRepository;
	}
	
	// set
	public void setBoardRepository(BoardRepositoryI boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	// 기본생성자
	public BoardService() {
		
	}
	
	// 인자값 하나 받는 생성자
	public BoardService(BoardRepositoryI boardRepository) {
		this.boardRepository = boardRepository;
	}

	
	@Override
	public BoardVo getBoard(int boardNo) {
		
		return boardRepository.getBoard(boardNo);
	}
}
