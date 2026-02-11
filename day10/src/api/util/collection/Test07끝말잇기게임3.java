package api.util.collection;

import java.util.Scanner;

public class Test07끝말잇기게임3 {
	public static void main(String[] args) {
		
		//제시어를 계속 바꿀 수 있는가?
		String given = "자바";
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("제시어 : " + given);
			String input = sc.nextLine();
			
			//제시어를 바꾼다는건 input을 given에 넣는다는 것
			given = input;
		}
		
	}
}








