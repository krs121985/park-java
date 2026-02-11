package oop.inherit1;

//갤럭시 25s 클래스
public class Galaxy25s {
	//필드
	private String number;//전화번호
	private int memory;//메모리크기(256, 512)
	
	//생성자 생략
	//메소드 (setter/getter 생략)
	public void call() {
		System.out.println("전화 기능");
	}
	public void sms() {
		System.out.println("문자 기능");
	}
	public void camera() {
		System.out.println("카메라 기능");
	}
	
	//25에만 있는 기능
	public void visualAI() {
		System.out.println("실시간 비주얼 AI기능");
	}
}










