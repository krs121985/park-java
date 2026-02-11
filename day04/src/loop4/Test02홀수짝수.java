package loop4;

import java.util.Scanner;

public class Test02홀수짝수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			//사용자로부터 숫자 입력받는 코드
			System.out.print("숫자 입력(0 입력 시 종료) : ");
			int user = sc.nextInt();
			
			if(user == 0) {
				break;
			}
		}
		
		System.out.println("프로그램이 종료되었습니다");
		
	}
}
