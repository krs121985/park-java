package loop4;

import java.util.Scanner;

public class Test03구구단게임4 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int dan = 9;
		int level = 1;
		
		while(true) {
			System.out.print(dan+" X "+level+" = ");
			int user = sc.nextInt();
			
			if(user == dan*level) {
				System.out.println("정답");
				//level++;//맞췄을 때만 다음 문제로 이동
			}
			else {
				System.out.println("오답");
			}
			
			//종료조건1 : x9까지 풀었다면 탈출
			if(level == 9) {
				break;
			}
			
			level++;//맞든 틀리든 다음 문제로 이동
		}
		
	}
}
