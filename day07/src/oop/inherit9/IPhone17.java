package oop.inherit9;

public class IPhone17 extends IPhone {
	public IPhone17(String number, String color) {
		super(number, color);
	}
	@Override
	public void siri() {
		System.out.println("아이폰17의 인공지능 기능 실행");
	}
	@Override
	public void call() {
		System.out.println("아이폰17의 통화 기능 실행");	
	}
	@Override
	public void sms() {
		System.out.println("아이폰17의 문자 기능 실행");
	}
	public void facetime() {
		System.out.println("아이폰17의 영상통화 기능 실행");
	}
}
