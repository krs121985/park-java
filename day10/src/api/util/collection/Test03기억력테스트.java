package api.util.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Test03기억력테스트 {
	public static void main(String[] args) {
		//순서대로 저장해야 하므로 ArrayList를 사용하여 문제를 푼다!
		
		ArrayList<String> history = new ArrayList<>();//문자열을 순서대로 저장할 저장소
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("단어 입력 : ");
			String word = sc.nextLine();
			
			//이미 입력한 적이 있다면 반복 종료
			if(history.contains(word)) break;
			
			history.add(word);//단어 추가
		}
		
	}
}









