package oop.inherit8;

public abstract class MediaFile extends File {

	//생성자는 상위클래스의 형태를 온전히 맞춰준다
	public MediaFile(String filename, long filesize) {
		super(filename, filesize);
	}
	public MediaFile(String filename) {
		super(filename);
	}
	
	//미디어 파일일 경우의 추가기능
	public void forward() {
		System.out.println("빨리감기 기능");
	}
	public void rewind() {
		System.out.println("되감기 기능");
	}

}
