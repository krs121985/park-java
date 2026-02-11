package oop.basic3;

public class Test01학생정보 {
	public static void main(String[] args) {
		//학생(Student) 클래스의 객체(인스턴스) 생성하기
		Student a = new Student();
		Student b = new Student();
		
		//a에 있는 init이란 메소드에 "피카츄", 70을 전달하고 실행하겠다!
		a.init("피카츄", 70);
		//b에 있는 init이란 메소드에 "라이츄", 80을 전달하고 실행하겠다!
		b.init("라이츄", 80);
		
		//a에 있는 show라는 메소드를 준비물 없이 실행하겠다!
		a.show();
		//b에 있는 show라는 메소드를 준비물 없이 실행하겠다!
		b.show();
	}
}
