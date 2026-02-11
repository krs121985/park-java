package oop.inherit8;

public class HWP extends DocumentFile {

	public HWP() {
		super("새 한글 문서.hwp");
	}
	public HWP(String filename) {
		super(filename);
	}
	public HWP(String filename, long filesize) {
		super(filename, filesize);
	}
	
	//추가 기능
	public void preview() {
		System.out.println("한글 문서를 미리보기하는 기능");
	}
	
	@Override
	public void execute() {
		
	}
	
}
