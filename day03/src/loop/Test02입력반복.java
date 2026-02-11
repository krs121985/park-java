package loop;

import java.util.Scanner;

public class Test02입력반복 {
	public static void main(String[] args) {
		
		//1회의 홀짝 판정
		Scanner sc = new Scanner(System.in);
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
