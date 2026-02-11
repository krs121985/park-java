package array;

import java.util.Scanner;

public class Test04점수분석기3 {
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
		
	}
}









