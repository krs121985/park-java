package oop.inherit2;

//실제로 사용하기 위해 만드는 클래스
//= 하위클래스, 서브클래스, 자식클래스 등으로 부름
//= 무에서 시작하는 것이 아니라 상위클래스를 상속받아서 시작
//= extends 키워드 뒤에 대상 클래스명을 적어서 상속을 받는다
public class Galaxy24s extends Galaxy {
	//24에만 있는 기능
	public void bluetoothPen() {
		System.out.println("블루투스 펜 기능");
	}
}
