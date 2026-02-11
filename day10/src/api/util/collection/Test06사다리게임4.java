package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test06사다리게임4 {
	public static void main(String[] args) {
		
		int people = 5;
		Scanner sc = new Scanner(System.in);		
		
		List<String> names = new ArrayList<>();
		List<String> actions = new ArrayList<>();
		
		//이름 입력
		for(int i=0 ; i < people; i++) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			names.add(name);
		}
		
		//항목 입력
		for(int i=0 ; i < people ; i++) {
			System.out.print("항목 : ");
			String action = sc.nextLine();
			actions.add(action);
		}
		
		Collections.shuffle(actions);//당첨항목 랜덤 섞기
		
		for(int i=0; i < people; i++) {
			System.out.println(names.get(i) + " → " + actions.get(i));
		}
		
	}
}









