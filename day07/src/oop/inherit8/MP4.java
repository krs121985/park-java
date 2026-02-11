package oop.inherit8;

public class MP4 extends MediaFile {
	
	private float speed;//더이상의 상속이 없기 때문에 private으로 기존처럼 설정
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		//switch(speed) {//float는 스위치 구문 사용이 불가 (경우가 너무 많은 형태는 불가)
		if(speed == 0.5f || speed == 1f || speed == 1.2f || speed == 1.5f || speed == 2f) {
			this.speed = speed;
		}
		else {
			this.speed = 1f;
		}
	}
	
	
	//	생성 방법이 총 3가지
//	[1] 이름을 설정하지 않고 만드는 경우 → "새 동영상 파일.mp4"로 생성
	public MP4() {
		super("새 동영상 파일.mp4");
		this.setSpeed(1f);
	}
//	[2] 이름만 설정하는 경우 → 전달받은 이름을 그대로 설정
	public MP4(String filename) {
		super(filename);
		this.setSpeed(1f);
	}
//	[3] 이름과 크기를 설정하는 경우 → 전달받은 데이터를 그대로 설정
	public MP4(String filename, long filesize) {
		super(filename, filesize);
		this.setSpeed(1f);
	}
	
	@Override
	public void execute() {
		System.out.println("동영상을 재생하는 기능");
	}
	
}






