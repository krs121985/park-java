package oop.keyword1;

public class Test01객체지향의불편함 {
	public static void main(String[] args) {
		Robot r = new Robot(10, 3);
		
		System.out.println(r.getPlus());
		System.out.println(r.getMinus());
		System.out.println(r.getMultiple());
		System.out.println(r.getDivide());
	}
}
