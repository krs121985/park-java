package data;

public class Test05실수다루기 {
	public static void main(String[] args) {
		//실수
		//- 소수점이 있는 숫자
		//- 정수와는 다른 원리로 저장된다 (부동소수점 방식)
		//- float와 double이라는 형태가 있으며, double이 기본
		
		float a = 10.5f;
		//double b = 10.5d;
		double b = 10.5;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		//- 실수에서의 크기는 "표현 가능한 자리수"를 의미함 (정확하지 않음)
		//- 엄청 정밀한 계산으로 사용하기는 구조적으로 문제가 있다
		float c = 1123.234183758173587138457128738127381723f;
		double d = 1123.234183758173587138457128738127381723;
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		
		//- (중요) 실수가 한 번이라도 포함되면 계산 결과가 실수이다
		//ex) 1 + 1 + 1 + 1 + 1.5 => 5.5
		System.out.println(1.5 + 2.5);//실수 + 실수
		System.out.println(10 / 3);//정수 / 정수
		System.out.println(10 / 3.0);//정수 / 실수
		System.out.println(10 / 3d);//정수 / 실수
		System.out.println(10 / 3f);//정수 / 실수
		
	}
}









