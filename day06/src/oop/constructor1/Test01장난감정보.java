package oop.constructor1;

public class Test01장난감정보 {
	public static void main(String[] args) {
		//Toy t1 = new Toy();//기존엔 됐지만 생성자 만들고 안되는 코드
		Toy t1 = new Toy("티니핑", 25000);//데이터 전달하며 생성
		Toy t2 = new Toy("번개맨", 12000);
		Toy t3 = new Toy("피카츄");
				
		t1.show();
		t2.show();
		t3.show();
	}
}
