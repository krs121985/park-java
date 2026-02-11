package loop4;

import java.util.Scanner;

public class Test02홀수짝수4 {
	public static void main(String[] args) {
		
		int total = 0;
		int oddCounter = 0;//홀수 카운터
		int evenCounter = 0;//짝수 카운터
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			//사용자로부터 숫자 입력받는 코드
			System.out.print("숫자 입력(0 입력 시 종료) : ");
			int user = sc.nextInt();
			
			if(user == 0) {
				break;
			}
				
			total += user;//total에 입력값을 더하는 코드
			if(user % 2 == 0) {//짝수
				evenCounter++;
			}
			else {//홀수
				oddCounter++;
			}
		}
		
		System.out.println("프로그램이 종료되었습니다");
		System.out.println("(1) 입력한 숫자의 합계 = " + total);
		System.out.println("(2) 입력한 홀수의 개수 = " + oddCounter);
		System.out.println("(3) 입력한 짝수의 개수 = " + evenCounter);
		
	}
}
