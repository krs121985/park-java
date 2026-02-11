package loop4;

import java.util.Scanner;

public class Test01무한반복 {
	public static void main(String[] args) {
//		무한반복?
//		- 영원히 반복하는걸 의미하는것이 아님
//		- 횟수나 범위는 모르지만 실행되야 하는 상황이나 종료되어야 하는 상황을 아는 경우에 사용
		
//		for(int i=1; i <= 10; i--) {
//		while(true) {
//			System.out.println("무한반복");
//		}
		
//		(ex) 사용자가 0을 입력할 때까지 숫자를 입력받는 프로그램 구현
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int number = sc.nextInt();
			
			//탈출 조건 설정
			if(number == 0) {
				break;
			}
		}
	}
}










