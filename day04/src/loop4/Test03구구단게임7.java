package loop4;

import java.util.Scanner;

public class Test03구구단게임7 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int dan = 9;
		int level = 1;
		
		int correctCounter = 0, wrongCounter = 0;
		int life = 3;
		
		while(true) {
			System.out.print(dan+" X "+level+" = ");
			int user = sc.nextInt();
			
			if(user == dan*level) {
				//System.out.println("정답");
				//level++;//맞췄을 때만 다음 문제로 이동
				correctCounter++;//맞춘 개수 증가
			}
			else {
				wrongCounter++;//틀린 개수 증가
				System.out.println("오답.. 남은 기회 : "+(life-wrongCounter)+"번");
				//종료조건2 : 틀린 개수가 3개라면 탈출
				if(wrongCounter == life) {
					System.out.println("게임 오버!");
					break;
				}
			}
			
			//종료조건1 : x9까지 풀었다면 탈출
			if(level == 9) {
				System.out.println("게임 클리어!");
				break;
			}
			
			level++;//맞든 틀리든 다음 문제로 이동
		}
		
		System.out.println("정답 개수 : " + correctCounter);
		System.out.println("오답 개수 : " + wrongCounter);
		
	}
}









