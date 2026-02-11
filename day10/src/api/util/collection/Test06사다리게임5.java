package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test06사다리게임5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//인원수 입력받도록 처리
		System.out.print("인원 수 입력 : ");
		int people = sc.nextInt();
		sc.nextLine();//의미없는 청소코드 추가
		
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
		
		sc.close();//입력 종료 후 닫기
		
		Collections.shuffle(actions);//당첨항목 랜덤 섞기
		
		for(int i=0; i < people; i++) {
			System.out.println(names.get(i) + " → " + actions.get(i));
		}
		
	}
}









