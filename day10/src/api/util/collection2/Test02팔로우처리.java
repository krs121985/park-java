package api.util.collection2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test02팔로우처리 {
	public static void main(String[] args) {
		
		//샘플 프로그램
		//- 어느 정도의 더미 데이터를 넣어두고 입력을 받았을 때 팔로우 또는 해지 처리를 하도록 구현
		//- 반복적으로 구현하는 것이 아니라 1회 구현에 초점을 맞춤
		
		//Set<String> followList = new TreeSet<>();//팔로우 목록까지 같이 보여줘야 할 경우
		Set<String> followList = new HashSet<>();//팔로우 여부만 알면 되는 경우
		followList.add("피카츄");
		followList.add("라이츄");
		followList.add("파이리");
		
		String input = "피카츄";
		
		if(followList.contains(input) == false) {//팔로우 상태가 아니면
			followList.add(input);
			System.out.println("[시스템] 팔로우 처리 되었습니다");
		}
		else {//팔로우 상태라면
			followList.remove(input);
			System.out.println("[시스템] 팔로우 해제 되었습니다");
		}
		
	}
}







