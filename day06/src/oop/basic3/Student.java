package oop.basic3;

//객체지향에서는 클래스를 잘 만드는게 핵심
//- 멤버 필드를 만들어서 데이터를 보관
//- 멤버 메소드를 만들어서 데이터에 관련된 코드들을 보관
public class Student {
	//멤버 필드
	String name;//이름
	int score;//점수
	
	//멤버 메소드
	//- 형태 : void 이름(준비물) {코드}
	void init(String n, int s) {//외부에서 전달된 데이터를 내 데이터로 설정해야 되므로 준비물이 필요하다
		name = n;
		score = s;
	}
	void show() {//내가 가지고 있는 데이터(필드)만 보여주면 되므로 준비물이 없다
		System.out.println("이름 : " + name);
		System.out.println("점수 : " + score);
	}
}
