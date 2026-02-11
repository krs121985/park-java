package array;

import java.util.Scanner;

public class Test04점수분석기2 {
	public static void main(String[] args) {
		
		//5명의 점수를 입력받기
		int[] students = new int[5];
		//students -------> [ 0 ] [ 0 ] [ 0 ] [ 0 ] [ 0 ]
		
		Scanner sc = new Scanner(System.in);

		for(int i=0; i < students.length; i++) {
			students[i] = sc.nextInt();
		}
		
		for(int i=0; i < students.length; i++) {
			System.out.println(students[i]);
		}
	}
}









