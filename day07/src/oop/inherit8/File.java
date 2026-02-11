package oop.inherit8;

public abstract class File {
	protected String filename;//확장자가 파일마다 다르기 때문에 검사로직이 다를 수 있으므로 여유롭게 설정
	private long filesize;//파일 크기는 음수가 불가능하며 이는 모든 파일에 적용되어야 하므로 강력하게 설정
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		if(filesize < 0L) return;
		this.filesize = filesize;
	}
	
	//생성자 - 파일명을 필수로 설정하도록 구현
	public File(String filename) {
		this.setFilename(filename);
		this.setFilesize(0L);
	}
	public File(String filename, long filesize) {
		this.setFilename(filename);
		this.setFilesize(filesize);
	}
	
	//공통 메소드
	// - 파일 종류마다 실행과정이 달라야 하므로 무조건 재정의해야됨 → 추상메소드
	public abstract void execute();
	public final void information() {//모든 파일이 동일한 형태의 실행결과를 가져야 하므로 재정의를 금지한다
		System.out.println("[파일 정보]");
		System.out.println("이름 : " + this.filename);
		System.out.println("크기 : " + this.filesize);
	}
	
}















