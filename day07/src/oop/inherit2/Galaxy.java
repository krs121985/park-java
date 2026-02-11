package oop.inherit2;

//쓸려고 만든것이 아니라 공통점만 보관시키려고 만든 클래스
//= 상위클래스, 슈퍼클래스, 부모클래스 등으로 부름
public class Galaxy {
	//필드 : 실제로 쓸 걸 만드는 것이 아니라 공통된 필드를 보관 (= 갤럭시 시리즈라면 있어야 할 필드)
	private String number;
	private int memory;
	
	//생성자, setter&getter 생략
	
	//메소드 : 실제로 쓸 걸 만드는게 아니라 공통된 메소드를 보관 (= 갤럭시 시리즈라면 있어야 할 메소드)
	public void call() {
		System.out.println("전화 기능");
	}
	public void sms() {
		System.out.println("문자 기능");
	}
	public void camera() {
		System.out.println("카메라 기능");
	}
	
}
