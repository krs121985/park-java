package oop.inherit9;

public class IPhone16 extends IPhone {
	public IPhone16(String number, String color) {
		super(number, color);
	}
	@Override
	public void siri() {
		System.out.println("아이폰16의 인공지능 기능 실행");
	}
	@Override
	public void call() {
		System.out.println("아이폰16의 전화 기능 실행");
	}
	@Override
	public void sms() {
		System.out.println("아이폰16의 문자 기능 실행");
	}
	public void itunes() {
		System.out.println("아이폰16의 아이튠즈 기능 실행");
	}
}
