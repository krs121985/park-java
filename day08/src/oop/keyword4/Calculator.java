package oop.keyword4;

public class Calculator {
	private Calculator() {}//생성자 잠금 처리
	
	//static이 포함된 메소드는 객체가 아닌 클래스 전체에 소속됨 (정적 메소드)
	public static int multiple(int a, int b) {
		return a * b;
	}
	public static double multiple(double a, double b) {
		return a * b;
	}
	
	public static int square(int n) {
		//return n * n;//n ^ 2 안됨
		return multiple(n, n);
	}
	public static double square(double n) {
		return multiple(n, n);
	}
	
	//삼각형 넓이 구하기
	public static double triangle(double w, double h) {
		//return w * h / 2;
		return multiple(w, h) / 2;
	}
	
	//원의 넓이 구하기 = 원주율 * 반지름²
	public static double circle(int r) {
		//return 3.141592 * r * r;
		//return 3.141592 * multiple(r, r);
		//return 3.141592 * square(r);
		return Math.PI * square(r);
		//return multiple(3.141592, square(r));
	}
	
	//과거에 풀었던 문제들도 메소드로 만들 수 있음
	//= 모듈화 한다고 표현
	public static double bmi(double height, double weight) {
		double m = height / 100;//m로 변환
		double bmi = weight / square(m);
		return bmi;
	}
	
	public static int subway(int birthYear) {
		 int year = 2026;
		 int age = year - birthYear + 1;
		 
		 if(age < 8) return 0;
		 else if(age >= 65) return 0;
		 else if(age >= 20) return 1550; 
		 else if(age >= 14) return 900;
		 else return 500;
	}
	
}












