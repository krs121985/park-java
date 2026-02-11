package home.beans;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

public class BoardDto {
	private int boardNo;
	private String boardHead;
	private String boardTitle;
	private String boardContent;//비정상적으로 긴 항목 (주의해서 다뤄야 한다)
	private String boardWriter;
	private Date boardWtime;
	private Date boardEtime;
	private int boardRead;
	private int boardLike;
	private int boardReply;
	//답변형 게시판을 위해 추가된 항목
	private int boardGroup;
	private Integer boardParent;//null 가능
	private int boardDepth;
	
	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo + ", boardHead=" + boardHead + ", boardTitle=" + boardTitle
				+ ", boardWriter=" + boardWriter + ", boardWtime=" + boardWtime + ", boardEtime=" + boardEtime
				+ ", boardRead=" + boardRead + ", boardLike=" + boardLike + ", boardReply=" + boardReply
				+ ", boardGroup=" + boardGroup + ", boardParent=" + boardParent + ", boardDepth=" + boardDepth + "]";
	}
	public int getBoardGroup() {
		return boardGroup;
	}
	public void setBoardGroup(int boardGroup) {
		this.boardGroup = boardGroup;
	}
	public Integer getBoardParent() {
		return boardParent;
	}
	public void setBoardParent(Integer boardParent) {
		this.boardParent = boardParent;
	}
	public int getBoardDepth() {
		return boardDepth;
	}
	public void setBoardDepth(int boardDepth) {
		this.boardDepth = boardDepth;
	}
	public BoardDto() {
		super();
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardHead() {
		return boardHead;
	}
	public void setBoardHead(String boardHead) {
		this.boardHead = boardHead;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public Date getBoardWtime() {
		return boardWtime;
	}
	//오늘 날짜와 비교하여 시간 또는 날짜를 반환하는 메소드
	public String getBoardWtimeProcess() {
		java.util.Date current = new java.util.Date();//현재시각
		java.util.Date wtime = new java.util.Date(boardWtime.getTime());//작성시점
		
		Format dateFormat = new SimpleDateFormat("yyyy-MM-dd");//날짜 형식
		Format timeFormat = new SimpleDateFormat("HH:mm");//시간 형식
		
		String currentDate = dateFormat.format(current);//오늘 날짜
		String writeDate = dateFormat.format(wtime);//작성한 날짜 
		
		if(currentDate.equals(writeDate)) {//오늘이면
			return timeFormat.format(wtime);//시간만 반환
		}
		else {//이전 글이면
			return writeDate;//날짜만 반환
		}
	}
	public void setBoardWtime(Date boardWtime) {
		this.boardWtime = boardWtime;
	}
	public Date getBoardEtime() {
		return boardEtime;
	}
	public void setBoardEtime(Date boardEtime) {
		this.boardEtime = boardEtime;
	}
	public int getBoardRead() {
		return boardRead;
	}
	public void setBoardRead(int boardRead) {
		this.boardRead = boardRead;
	}
	public int getBoardLike() {
		return boardLike;
	}
	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}
	public int getBoardReply() {
		return boardReply;
	}
	public void setBoardReply(int boardReply) {
		this.boardReply = boardReply;
	}
}
