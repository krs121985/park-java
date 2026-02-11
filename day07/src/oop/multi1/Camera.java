package oop.multi1;

//인터페이스(interface)
//- 다중상속을 위한 전용 클래스
//- 다중상속에서 문제가 될 수 있는 부분을 모두 제거한 형태를 가지고 있음
//- 객체 생성이 안되고 super의 대상이 될 수 없음
public interface Camera {
	//필드 : 사실상 사용 불가 (객체 생성이 안됨)
	//생성자 : 만들 수 없음 (객체 생성이 안됨)
	//메소드 : 추상 메소드만 가능 (public abstract 생략 가능) 
	//public abstract void capture();
	void capture();
}
