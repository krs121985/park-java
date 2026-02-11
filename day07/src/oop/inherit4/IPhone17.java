package oop.inherit4;

public class IPhone17 extends IPhone {

	public IPhone17(String number) {
		super(number);//전달받은 number를 상위클래스로 전달하는 코드
	}
	
	//원하는 메소드를 추가하거나 재정의할 수 있음
	public void camera() {//재정의된 메소드 (원본과 동일하게 구현)
		System.out.println("새로운 카메라 기능");
	}
	
}
