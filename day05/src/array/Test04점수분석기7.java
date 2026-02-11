package array;

import java.util.Scanner;

public class Test04점수분석기7 {
	public static void main(String[] args) {
		
		//5명의 점수를 입력받기
		int[] students = new int[5];
		//students -------> [ 0 ] [ 0 ] [ 0 ] [ 0 ] [ 0 ]
		
		Scanner sc = new Scanner(System.in);

		for(int i=0; i < students.length; i++) {
			System.out.print("점수 입력 : ");
			students[i] = sc.nextInt();
		}
		
		System.out.println("1. 전체 학생 성적 출력");
		for(int i=0; i < students.length; i++) {
			System.out.println(students[i]+"점");
		}
		
		System.out.println("2. 90점 이상인 학생의 인원수");
		int goodCount = 0;
		for(int i=0; i < students.length; i++) {
			if(students[i] >= 90) {//90점 이상이면
				//System.out.println(students[i]+"점");
				goodCount++;
			}
		}
		System.out.println(goodCount+"명");
		
		System.out.println("3. 60점 미만인 학생의 인원수");
		int badCount = 0;
		for(int i=0; i < students.length; i++) {
			if(students[i] < 60) {//60점 미만
				badCount++;
			}
		}
		System.out.println(badCount+"명");
		
		System.out.println("4. 평균 점수");
		//int total = students[0] + students[1] + students[2] + ... ;//의미없음
		int total = 0;
		for(int i=0; i < students.length; i++) {
			//total += students;//리모컨은 더할 수 없음
			total += students[i];
		}
		//System.out.println("총점 = " + total);
		
		float avg = (float)total / students.length;
		System.out.println(avg+"점");
	}
}













