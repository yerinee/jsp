package kr.or.ddit.person.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import kr.or.ddit.board.repository.BoardRepositoryI;

public class Person {
	private int age;
	private BoardRepositoryI boardRepository;
	
	// 개발을 할때 포맷이 달라져야한다고 해도 상관없다. -> 자유도 증가
	// 주입하려는 필드마다 선언을 해줘야하는 단점
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public BoardRepositoryI getBoardRepository() {
		return boardRepository;
	}
	public void setBoardRepository(BoardRepositoryI boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", boardRepository=" + boardRepository + ", birthdate=" + birthdate + "]";
	}
	public Person() {

	}
	public Person(int age, BoardRepositoryI boardRepository) {
		super();
		this.age = age;
		this.boardRepository = boardRepository;
	}
	
	
}
