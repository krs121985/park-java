package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01예외처리 {
	public static void main(String[] args) {
		//프로그램을 구현할 때 발생할 수 있는 돌발상황까지 대비한 코드 구현
		//- Plan B에 대한 코드 작성 (= 예외 처리)
		
		try {//Plan A를 작성하는 곳
			//(ex) n분의 1 계산기
			Scanner sc = new Scanner(System.in);
			
			System.out.print("금액 입력 : ");
			int price = sc.nextInt();
			
			System.out.print("인원 수 입력 : ");
			int people = sc.nextInt();
	
			int money = price / people;
			int remain = price % people;
			
			System.out.println("1인당 금액 = " + money + "원");
			System.out.println("자투리 금액 = " + remain + "원");
		}
		catch(ArithmeticException e) {//Plan B
			System.err.println("인원수는 0일 수 없습니다");
		}
		catch(InputMismatchException e) {//Plan B
			System.err.println("입력값이 잘못되었습니다");
		}
		
	}
}









