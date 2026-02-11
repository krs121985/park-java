package oop.inherit9;

public abstract class Phone {
	//필드 - 번호(필수), 색상(필수)
	protected String number;
	protected String color;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	//생성자
	public Phone(String number, String color) {
		this.setNumber(number);
		this.setColor(color);
	}
	
	//공통 메소드
	public final void show() {
		System.out.println("[휴대폰 정보]");
		System.out.println("번호 : " + this.number);
		System.out.println("색상 : " + this.color);
	}
	public abstract void call();
	public abstract void sms();
	
}













