package loop4;

import java.util.Random;

public class Test04랜덤만들기 {
	public static void main(String[] args) {
		//랜덤(Random)
		//- 범위는 알지만 정확한 값을 예측할 수 없는 형태의 데이터
		//- (ex) 주사위, 로또, ...
		//- 사용자의 흥미 혹은 변칙을 만들어낼 수 있는 가장 기초적이고 유용한 방법
		
		//랜덤을 만드는 방법
		//1. 도구 없이 명령만으로 생성해서 계산하는 방법
		//2. 도구를 생성해서 만드는 방법
		
		//1
		double a = Math.random();
		System.out.println("a = " + a);//0이상 1미만 double
		
		//a의 형태에 계산 더해서 원하는 형태의 정수로 개조
		//(중요) 반드시 알아야 하는것 (1)시작값 (2)범위의 숫자개수
		//주사위 		= (사람)1부터 6까지 	= (자바)1부터 6개
		//두자리정수 	= (사람)10부터 99까지 	= (자바)10부터 90개
		
		int dice = (int)(Math.random() * 6) + 1;
		System.out.println("dice = " + dice);
		
		int lotto = (int)(Math.random() * 45) + 1;
		System.out.println("lotto = " + lotto);
		
		//2
		//Scanner처럼 랜덤 생성을 위한 도구를 하나 생성 (Random)
		Random r = new Random();
		
		int dice2 = r.nextInt(6) + 1;
		System.out.println("dice2 = " + dice2);
		
		int lotto2 = r.nextInt(45) + 1;
		System.out.println("lotto2 = " + lotto2);
		
		//(Q) OTP번호 8자리 숫자 1개를 생성하여 출력해보세요
		int otp = r.nextInt(90000000) + 10000000;
		System.out.println("otp = " + otp);
	}
}

















