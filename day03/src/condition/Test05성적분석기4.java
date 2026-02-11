package condition;

import java.util.Scanner;

public class Test05성적분석기4 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 영어 수학점수를 순서대로 입력하세요");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int mat = sc.nextInt();
		
		//처리
		int tot = kor + eng + mat;//총점
		double avg = (double)tot / 3;//평균
		System.out.println("avg = " + avg);
		
		//char grade = 'A' or 'B' or 'C';
		//String grade = "A" or "B" or "C";
		String grade;
		if(avg >= 90) {
			grade = "A";
		}
		else if(avg >= 80) {
			grade = "B";
		}
		else {
			grade = "C";
		}
		
		//출력
		System.out.println("당신의 내신등급은 "+grade+"등급입니다");
	}
}



