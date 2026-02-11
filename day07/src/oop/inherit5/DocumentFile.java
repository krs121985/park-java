package oop.inherit5;

//한글이나 파워포인트처럼 문서 형태를 가지는 파일들을 의미하는 클래스
public class DocumentFile extends File {
	
	private int pagesize;//장 수는 모든 파일이 1 이상이어야 하므로 강력하게 잠금처리하여 규칙을 구현
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		if(pagesize < 1) return;
		this.pagesize = pagesize;
	}
	
	//생성자는 상위클래스의 형태를 온전히 맞춰준다
	public DocumentFile(String filename, long filesize) {
		super(filename, filesize);
		this.setPagesize(1);//1페이지로 설정
	}
	public DocumentFile(String filename) {
		super(filename);
		this.setPagesize(1);//1페이지로 설정
	}

}
