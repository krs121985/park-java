package oop.keyword2;

public class Test01객체지향의불편함 {
	public static void main(String[] args) {
		Robot r = new Robot();//객체가 굳이 필요한가?
		
		System.out.println(r.plus(10, 3));
		System.out.println(r.minus(10, 3));
		System.out.println(r.multiple(10, 3));
		System.out.println(r.divide(10, 3));
	}
}
