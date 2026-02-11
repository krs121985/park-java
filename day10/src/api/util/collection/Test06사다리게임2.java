package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test06사다리게임2 {
	public static void main(String[] args) {
		
		//입력이 되어 있다 치고 결과만 표시
		List<String> names = new ArrayList<>();
		names.add("피카츄");
		names.add("라이츄");
		names.add("파이리");
		
		List<String> actions = new ArrayList<>();
		actions.add("저녁사기");
		actions.add("술사기");
		actions.add("얻어먹기");
		
		Collections.shuffle(actions);//당첨항목 랜덤 섞기
		
		System.out.println(names.get(0) + " → " + actions.get(0));
		System.out.println(names.get(1) + " → " + actions.get(1));
		System.out.println(names.get(2) + " → " + actions.get(2));
		
	}
}









