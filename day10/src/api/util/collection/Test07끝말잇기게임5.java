package api.util.collection;

import java.util.Scanner;

public class Test07끝말잇기게임5 {
	public static void main(String[] args) {
		
		//제시어를 계속 바꿀 수 있는가?
		String given = "자바";
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("제시어 : " + given);
			System.out.print("입력 : ");
			String input = sc.nextLine();
			
			//형식검사
			String regex = "^[가-힣]{2,}$";
			if(input.matches(regex) == false) break;
			
			//연결되는지 검사
			char last = given.charAt(given.length()-1);//given의 마지막 글자
			char first = input.charAt(0);//input의 첫 글자
			boolean connect = last == first;//연결되는지 확인
			if(connect == false) break;//연결이 안되었다면 나가도록 처리
			
			//제시어를 바꾼다는건 input을 given에 넣는다는 것
			given = input;
		}
		
		sc.close();
		
		System.out.println("GAME OVER!");
		
	}
}








