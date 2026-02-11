package array;

import java.util.Scanner;

public class Test04점수분석기 {
	public static void main(String[] args) {
		
		//5명의 점수를 입력받기
		int[] students = new int[5];
		//students -------> [ 0 ] [ 0 ] [ 0 ] [ 0 ] [ 0 ]
		
		Scanner sc = new Scanner(System.in);
		//students = sc.nextInt();//안됨
		students[0] = sc.nextInt();
		students[1] = sc.nextInt();
		students[2] = sc.nextInt();
		students[3] = sc.nextInt();
		students[4] = sc.nextInt();
		
		//System.out.println(students);//의미없음
		System.out.println(students[0]);
		System.out.println(students[1]);
		System.out.println(students[2]);
		System.out.println(students[3]);
		System.out.println(students[4]);
	}
}









