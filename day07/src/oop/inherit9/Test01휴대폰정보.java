package oop.inherit9;

public class Test01휴대폰정보 {
	public static void main(String[] args) {
		//객체(인스턴스) 생성
		//Phone phone = new Phone("010-1234-5678", "화이트");//추상(생성x)
		//Galaxy galaxy = new Galaxy("010-1234-5678", "실버");//추상(생성x)
		//IPhone iphone = new IPhone("010-1234-5678", "실버");//추상(생성x)
		
		Galaxy25s p1 = new Galaxy25s("010-1234-5678", "티타늄그레이");
		GalaxyFold7 p2 = new GalaxyFold7("010-1234-5678", "티타늄그레이");
		IPhone16 p3 = new IPhone16("010-1234-5678", "티타늄그레이");
		IPhone17 p4 = new IPhone17("010-1234-5678", "티타늄그레이");
		
		p1.show();
		p1.call();
		p1.sms();
		p1.samsungPay();
		p1.bixby();
		
		p2.show();
		p2.call();
		p2.sms();
		p2.samsungPay();
		p2.iris();
		
		p3.show();
		p3.call();
		p3.sms();
		p3.siri();
		p3.itunes();
		
		p4.show();
		p4.call();
		p4.sms();
		p4.siri();
		p4.facetime();
	}
}
