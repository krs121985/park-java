package oop.keyword4;

public class Test01정적메소드 {
	public static void main(String[] args) {
		int a = Calculator.multiple(3, 5);
		System.out.println("a = " + a);
		
		double b = Calculator.multiple(1.5, 2.2);
		System.out.println("b = " + b);
		
		int c = Calculator.square(11);
		System.out.println("c = " + c);
		
		double d = Calculator.triangle(5, 7);
		System.out.println("d = " + d);
		
		double e = Calculator.circle(5);
		System.out.println("e = " + e);
		
		double bmi = Calculator.bmi(180, 80);
		System.out.println("bmi = " + bmi);
		
		int price = Calculator.subway(2000);
		System.out.println("요금 = " + price);
	}
}
















