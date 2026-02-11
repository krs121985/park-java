package loop;

import java.util.Scanner;

public class Test02입력반복2 {
	public static void main(String[] args) {
		
		//(주의) 도구는 반복문 밖에서 1회만 생성
		Scanner sc = new Scanner(System.in);
		
		//5회의 홀짝 판정
		//for(5번) {
		for(int i=1; i <= 5; i++) {
			System.out.println("숫자를 입력하세요");
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
