package oop.keyword3;

public class Test01객체지향의불편함 {
	public static void main(String[] args) {
		//Robot r = new Robot();//생성자가 잠겨있으므로 생성은 불가
		System.out.println(Robot.plus(10, 3));
		System.out.println(Robot.minus(10, 3));
		System.out.println(Robot.multiple(10, 3));
		System.out.println(Robot.divide(10, 3));
	}
}
