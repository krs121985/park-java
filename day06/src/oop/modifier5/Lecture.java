package oop.modifier5;

//강좌 1개에 대한 정보를 저장하기 위한 구조 구현
public class Lecture {
	//멤버 필드(private)
	private String subject;
	private String category;
	private int time;
	private int price;
	private String type;
	
	//세터+게터메소드(public)
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setCategory(String category){
		switch(category) {
		case "이론", "실습", "시험":
			this.category = category;
		}
	}
	public void setTime(int time) {
		if(time <= 0) return;
		if(time % 30 != 0) return;
		this.time = time;
	}
	public void setPrice(int price) {
		if(price < 0) return;
		if(price % 1000 != 0) return;
		this.price = price;
	}
	public void setType(String type) {
		switch(type) {
		case "온라인", "오프라인", "혼합":
			this.type = type;
		}
	}
	
	public String getSubject() {
		return this.subject;
	}
	public String getCategory() {
		return this.category;
	}
	public int getTime() {
		return this.time;
	}
	public int getPrice() {
		return this.price;
	}
	public String getType() {
		return this.type;
	}
	//추가 : 한 시간당 가격을 구하는 가상의 게터메소드
	public int getPricePerHour() {
		return this.price / this.time;
	}
	
	//생성자(public)
	public Lecture(String subject, String category, int time, int price) {
		this.setSubject(subject);
		this.setCategory(category);
		this.setTime(time);
		this.setPrice(price);
		this.setType("오프라인");
	}
	public Lecture(String subject, String category, int time, int price, String type) {
		this.setSubject(subject);
		this.setCategory(category);
		this.setTime(time);
		this.setPrice(price);
		this.setType(type);
	}
	
	//기타메소드(public)
	public void show() {
		System.out.println("<강좌 정보>");
		System.out.println("강좌명 : " + this.getSubject());
		System.out.println("카테고리 : " + this.getCategory());
		System.out.println("강의시간 : " + this.getTime() + "H");
		System.out.println("수강료 : " +  this.getPrice()+"원 (1시간당 "+this.getPricePerHour()+"원)");
		System.out.println("훈련유형 : " + this.getType());
	}
}












