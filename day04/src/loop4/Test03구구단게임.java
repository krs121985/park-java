package loop4;

import java.util.Scanner;

public class Test03구구단게임 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("9 X 1 = ");
		int user = sc.nextInt();
		
		if(user == 9) {
			System.out.println("정답");
		}
		else {
			System.out.println("오답");
		}
		
	}
}
