package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01예외처리3 {
	public static void main(String[] args) {
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
		catch(Exception e) {//통합 예외 처리 클래스
			//System.err.println("입력값이 잘못되었습니다");//사용자를 위한 메세지
			e.printStackTrace();//개발자를 위한 메세지
		}
		
	}
}









