package oop.modifier2;

public class Test01휴대폰판매정보 {
	public static void main(String[] args) {
		Phone p1 = new Phone("갤럭시 Fold 6", "SK", 2200000);
		Phone p2 = new Phone("갤럭시 Fold 6", "KT", 2150000, 24);
		Phone p3 = new Phone("아이폰16", "LG", 2100000, 36);
		Phone p4 = new Phone("아이폰16", "SK", 2150000);
		
//		p1.price = -500000;//시스템적으로 불가능 (잠김처리되어있음)
		p1.setPrice(-500000);//시스템적으로 차단당함 (안전장치... 세터메소드)
		
		p1.show();
		p2.show();
		p3.show();
		p4.show();
	}
}
