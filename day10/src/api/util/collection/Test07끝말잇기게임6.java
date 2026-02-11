package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test07끝말잇기게임6 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<String> history = new ArrayList<>();//제시어 이력을 저장할 저장소
		history.add("자바");//제시어를 미리 추가
		
		while(true) {
//			System.out.println("제시어 : " + history.get(history.size()-1));
			System.out.println("제시어 : " + history.getLast());//최신버전 코드
			System.out.print("입력 : ");
			String input = sc.nextLine();
			
			//형식검사
			String regex = "^[가-힣]{2,}$";
			if(input.matches(regex) == false) break;
			
			//입력한 기록이 있는지 검사
			if(history.contains(input)) break;
			
			//연결되는지 검사
			char last = history.getLast().charAt(history.getLast().length()-1);//given의 마지막 글자
			char first = input.charAt(0);//input의 첫 글자
			boolean connect = last == first;//연결되는지 확인
			if(connect == false) break;//연결이 안되었다면 나가도록 처리
			
			//제시어를 바꾼다는건 history에 input을 추가하는 것
			history.add(input);
		}
		
		sc.close();
		
		System.out.println("GAME OVER!");
		
	}
}








