package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test06구구단게임 {
	public static void main(String[] args) {
		//과제는 제공되는 코드 확인하시고 개별 질문해주세요
		Random r = new Random();//랜덤 생성 도구
		Scanner sc = new Scanner(System.in);//입력 도구
		
		int easyCount = 0, hardCount = 0, wrongCount = 0;
		int score = 0;
		int size = 10;//10회 반복
		
		for(int i=0; i < size; i++) {
			int left = r.nextInt(8) + 2;//2부터 8개
			//int right = r.nextInt(1, 10);// <-- 이 명령은 자바 17부터 사용가능
			int right = r.nextInt(9) + 1;//1부터 9개
			
			System.out.print(left + " X " + right + " = ");
			int user = sc.nextInt();
			
			if(left * right == user) {//정답이라고 판정될 경우
				boolean easy = left <= 11 || right <= 2;
				if(easy) {//쉬운문제인 경우
					easyCount++;//쉬운 문제 카운트 증가
					score += 10;//10점 추가
				}
				else {//어려운문제인 경우
					hardCount++;//어려운 문제 카운트 증가
					score += 25;//25점 추가
				}
			}
			else {//오답이라고 판정될 경우
				wrongCount++;//틀린 개수 카운트 증가
				score -= 5;//5점 감점
				
				if(score < 0) {//문제에는 없지만 점수가 음수가 되는 것을 방지
					score = 0;
				}
			}
		}
		
		System.out.println("<게임 결과>");
		System.out.println("총 문제 수 : " + size);
		System.out.println("정답 : " + (easyCount + hardCount));
		System.out.println(" - 쉬운 문제 : " + easyCount);
		System.out.println(" - 어려운 문제 : " + hardCount);
		System.out.println("오답 : " + wrongCount);
		System.out.println("점수 : " + score);
		
		
	}
}
