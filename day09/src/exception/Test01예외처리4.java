package exception;

import java.util.Scanner;

public class Test01예외처리4 {
	public static void main(String[] args) {
		try {//Plan A를 작성하는 곳
			//(ex) n분의 1 계산기
			Scanner sc = new Scanner(System.in);
			
			System.out.print("금액 입력 : ");
			int price = sc.nextInt();
			if(price <= 0) {
				Exception e = new Exception("금액은 0보다 커야합니다");
				throw e;//e 들고 catch로 가세요!
			}
			
			System.out.print("인원 수 입력 : ");
			int people = sc.nextInt();
			if(people <= 0) {
				throw new Exception("인원수는 0보다 커야합니다");
			}
	
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









