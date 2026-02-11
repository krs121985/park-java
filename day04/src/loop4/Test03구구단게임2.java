package loop4;

import java.util.Scanner;

public class Test03구구단게임2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int dan = 9;
		int level = 2;
		
		System.out.print(dan+" X "+level+" = ");
		int user = sc.nextInt();
		
		if(user == dan*level) {
			System.out.println("정답");
		}
		else {
			System.out.println("오답");
		}
		
	}
}
