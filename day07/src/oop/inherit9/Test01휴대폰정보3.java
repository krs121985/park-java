package oop.inherit9;

public class Test01휴대폰정보3 {
	public static void main(String[] args) {
		//객체(인스턴스) 생성
		
		Phone p1 = new Galaxy25s("010-1234-5678", "티타늄그레이");//Galaxy25s → Phone (업캐스팅, up-casting)
		Phone p2 = new GalaxyFold7("010-1234-5678", "티타늄그레이");//GalaxyFold7 → Phone (업캐스팅, up-casting)
		Phone p3 = new IPhone16("010-1234-5678", "티타늄그레이");//IPhone16 → Phone (업캐스팅, up-casting)
		Phone p4 = new IPhone17("010-1234-5678", "티타늄그레이");//IPhone17 → Phone (업캐스팅, up-casting)
		
		p1.show();
		p1.call();
		p1.sms();
		//p1.samsungPay();
		//p1.bixby();
		
		p2.show();
		p2.call();
		p2.sms();
		//p2.samsungPay();
		//p2.iris();
		
		p3.show();
		p3.call();
		p3.sms();
		//p3.siri();
		//p3.itunes();
		
		p4.show();
		p4.call();
		p4.sms();
		//p4.siri();
		//p4.facetime();
	}
}
