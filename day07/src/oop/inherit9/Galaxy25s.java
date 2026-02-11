package oop.inherit9;

public class Galaxy25s extends Galaxy {
	public Galaxy25s(String number, String color) {
		super(number, color);
	}

	@Override//애노테이션(annotation) : 바로 우측 또는 하단의 대상에게 강제로 역할을 부여 (= 해시태그)
	public void samsungPay() {
		System.out.println("갤럭시25s의 삼성페이 기능 실행");
	}
	@Override
	public void call() {
		System.out.println("갤럭시25s의 전화 기능 실행");
	}
	@Override
	public void sms() {
		System.out.println("갤럭시25s의 문자 기능 실행");
	}
	
	public void bixby() {//추가되는 기능
		System.out.println("갤럭시25s의 인공지능 기능 실행");
	}
}
