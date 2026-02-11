package oop.constructor1;

//장난감 정보를 보관할 클래스
public class Toy {
	String name;//장난감 이름
	int price;//판매가
	
//	현재의 문제점 : init 메소드가 편하긴 하지만 객체 생성 후에 이 메소드를 불러야 데이터가 설정된다
//	해결 방법 : 생성과 동시에 데이터 설정되게 만들어서 이름이 `null`인 경우가 없도록 만들겠다 (생성자로 해결, constructor)
//	void init(String name, int price) {//메소드(method)
	
	//생성자(constructor)
	//- 생성할 때만 부를 수 있는 전용 메소드
	//- 클래스 이름과 반드시 같아야 하며 메소드처럼 void 키워드 사용 불가
	//- 상황에 따라 여러 개 만들 수 있다(구분만 된다면)
	//- 편리성을 위해 여러 개 만드는 행위를 overloading이라 부름
	Toy(String name) {
		this.name = name;
	}
	Toy(String name, int price) {
		this.name = name;
		this.price = price;
	}
	void show() {
		System.out.println("장난감 이름 : " + this.name);
		System.out.println("장난감 가격 : " + this.price + "원");
	}
}
