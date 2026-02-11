package oop.inherit8;

public class PPT extends DocumentFile {

	public PPT(String filename, long filesize) {
		super(filename, filesize);
	}
	public PPT(String filename) {
		super(filename);
	}
	
	//추가되는 기능
	public void slideShow() {
		System.out.println("슬라이드쇼 재생 기능");
		System.out.println("총 "+super.getPagesize()+"장 재생 시작");
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
}
