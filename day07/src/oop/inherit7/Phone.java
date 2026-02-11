package oop.inherit7;

//추상 클래스
//- 상속에서 상위클래스들을 빠르고 효과적으로 만들기 위한 클래스
//- 추상적인 개념을 포함한 클래스
public abstract class Phone {
	
	private String number;//전화번호
	
	//세터, 게터, 생성자 생략
	
	//전화 기능 : 있긴 해야되지만 뭐라 설명할 수는 없는 추상적인 기능 (코드 작성은 불가)
	public abstract void call();
	//메세지 기능 : 있긴 해야하지만 구체적인 진행과정을 작성할 수 없다
	public abstract void sms();
	//정보 기능 : 내용을 작성할 수 있는 일반적인 기능
	public void show() {
		System.out.println("번호 : " + this.number);
	}
	
}
