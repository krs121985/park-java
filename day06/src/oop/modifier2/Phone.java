package oop.modifier2;

public class Phone {
	//1. 필드는 잠금 처리로 생성
	private String name;
	private String telecom;
	private int price;
	private int period;
	
	//2. 세터메소드로 데이터 설정 조건을 적용
	void setName(String name) {
		this.name = name;
	}
	void setTelecom(String telecom) {
//		문자열을 비교연산(==)으로 비교하면 향후 안될 가능성이 매우 높음(참조형 데이터의 특징 때문)
//		if(telecom == "SK" || telecom == "KT" || telecom == "LG" || telecom == "알뜰폰") {
//			this.telecom = telecom;
//		}
		
//		switch-case 구문을 이용하면 문자열의 글자가 같은 경우에 같다고 판정
		switch(telecom) {
		case "SK", "KT", "LG", "알뜰폰":
			this.telecom = telecom;
		}
	}
	void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	void setPeriod(int period) {
		switch(period) {
		case 0, 24, 30, 36:
			this.period = period;
		}
	}
	
	//3. 생성자
	Phone(String name, String telecom, int price) {//약정기간을 설정하지 않는 경우
		this.setName(name);
		this.setTelecom(telecom);
		this.setPrice(price);
		//this.setPeriod(0);
	}
	Phone(String name, String telecom, int price, int period) {//약정기간을 설정하는 경우
		this.setName(name);
		this.setTelecom(telecom);
		this.setPrice(price);
		this.setPeriod(period);
	}
	
	//4. 나머지 메소드
	void show() {
		System.out.println("<휴대폰 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("통신사 : " + this.telecom);
		
		System.out.print("가격 : " + this.price + "원");
		if(this.period > 0) {
			int money = this.price / this.period;
			System.out.print("(월 분납금 : "+money+"원");
		}
		System.out.println();
		
		
		if(this.period > 0) {
			System.out.println("약정기간 : " + this.period + "개월");
		}
	}
	
	
}







