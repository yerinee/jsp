package kr.or.ddit.board.model;

public class BoardVo {
	private int boardNo;
	private String title;
	private String content;
	
	// 인자가 있는 생성자만 만들게 되면 프레임워크에서 기본생성자를 어떻게 생성해야할지 모르기때문에
	// 기본생성자를 만들어주어야한다.
	public BoardVo() {
		
	}
	
	public BoardVo(int boardNo, String title, String content) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BoardVo [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	}
	
	
}
