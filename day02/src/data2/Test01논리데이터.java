package data2;

public class Test01논리데이터 {
	public static void main(String[] args) {
		//논리
		//- 참(true)과 거짓(false) 두 가지만 설정 가능한 데이터 형태
		//- 이름은 boolean
		//- 논리는 숫자처럼 연산이 불가능하고 독자적인 연산 방법이 있음
		//- 프로그램이 무언가를 판정하도록 만드는 데이터
		
		boolean a = false;
		System.out.println("a = " + a);
		
		//(ex) 논리를 만드는 과정
		int money = 30000;
		int pizza = 27000;
		
		boolean order = money >= pizza;//order에 true가 들어가면 주문이 가능하단 뜻
		System.out.println("order = " + order);
		
		//비교 연산 : >=(이상) , <=(이하) , >(초과) , <(미만) , ==(같다) , !=(다르다)
	}
}








