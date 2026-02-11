package oop.constructor2;

public class Menu {
	//멤버 필드
	String name;
	String category;
	int price;
	boolean event;
	
	//멤버 메소드
	void show() {
		System.out.println("<메뉴 정보>");
		if(this.event) {//행사중
			System.out.println("이름 : " + this.name + "(행사중)");
		}
		else {//행사아님
			System.out.println("이름 : " + this.name);
		}
		System.out.println("종류 : " + this.category);
		if(this.event) {//행사중
			int discount = this.price * 80 / 100;
			System.out.println("가격 : " + discount + "원");
		}
		else {//행사아님
			System.out.println("가격 : " + this.price + "원");
		}
		
	}
	//질문답변 - 출력을 가로로
	void customHeader() {
		System.out.print("이름");
		for(int i="이름".length(); i < 20; i++) {
			System.out.print("  ");
		}
		System.out.print("구분");
		for(int i="구분".length(); i < 10; i++) {
			System.out.print("  ");
		}
		System.out.print("가격");
		for(int i=0; i < 8; i++) {
			System.out.print(" ");
		}
		System.out.println();
	}
	void customShow() {
		System.out.print(this.name);
		for(int i=this.name.length(); i < 20; i++) {
			System.out.print("  ");
		}
		System.out.print(this.category);
		for(int i=this.category.length(); i < 10; i++) {
			System.out.print("  ");
		}
		System.out.print(this.price);
		for(int i=0, tmp=price; tmp > 0 || i < 10;  i++, tmp/=10) {
			System.out.print(" ");
		}
		if(this.event) {
			System.out.println("행사중");
		}
		else {
			System.out.println();
		}
	}
	
	//생성자
	Menu(String name, String category, int price) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.event = false;
	}
	Menu(String name, String category, int price, boolean event) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.event = event;
	}
}






