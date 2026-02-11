package oop.inherit1;

public class Test01 {
	public static void main(String[] args) {
		//Galaxy24s 생성
		Galaxy24s p1 = new Galaxy24s();
		p1.call();//공통기능
		p1.sms();//공통기능
		p1.camera();//공통기능
		p1.bluetoothPen();//고유기능
		
		//Galaxy25s 생성
		Galaxy25s p2 = new Galaxy25s();
		p2.call();//공통기능
		p2.sms();//공통기능
		p2.camera();//공통기능
		p2.visualAI();//고유기능
	}
}
