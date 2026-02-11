package oop.inherit9;

public class GalaxyFold7 extends Galaxy {
	public GalaxyFold7(String number, String color) {
		super(number, color);
	}
	@Override
	public void samsungPay() {
		System.out.println("갤럭시 폴드7의 삼성페이 기능 실행");
	}
	@Override
	public void call() {
		System.out.println("갤럭시 폴드7의 전화 기능 실행");
	}
	@Override
	public void sms() {
		System.out.println("갤럭시 폴드7의 문자 기능 실행");
	}
	public void iris() {
		System.out.println("갤럭시 폴드7의 홍채인식 기능 실행");
	}
}
