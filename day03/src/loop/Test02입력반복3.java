package loop;

import java.util.Scanner;

public class Test02입력반복3 {
	public static void main(String[] args) {
		
		//(주의) 도구는 반복문 밖에서 1회만 생성
		Scanner sc = new Scanner(System.in);
		
		//5회의 홀짝 판정
		//for(5번) {
		for(int i=1; i <= 5; i++) {
			//print는 엔터를 치지 않으므로 우측에 입력이 가능
			System.out.print("숫자 입력 : ");
			int number = sc.nextInt(); 
			
			if(number % 2 == 0) {
				System.out.println("짝수");
			}
			else {
				System.out.println("홀수");
			}
		}
		
		
	}
}
