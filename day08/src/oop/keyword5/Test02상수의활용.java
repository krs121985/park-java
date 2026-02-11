package oop.keyword5;

public class Test02상수의활용 {
	public static void main(String[] args) {
		
		int input = 1;
		
		switch(input) { 
		//case 1:
		case Month.JANUARY:
			System.out.println("1월");
			break;
		case Month.FEBRUARY:
			System.out.println("2월");
			break;
		//나머지는 생략
		}
		
	}
}
