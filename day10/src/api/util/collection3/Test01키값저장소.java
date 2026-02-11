package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test01키값저장소 {
	public static void main(String[] args) {
		
		//Map
		//- 키(key)와 값(value)을 세트로 저장하는 저장소 (= 값에 이름을 붙여서 저장한다)
		//- 개별 관리에 특화된 저장소
		//- 비선형 구조이며 트리와 해시방식이 존재
		//- 중복은 key만 불가능
		
		Map<String, String> monsters = new HashMap<>();//해시 방식을 사용
		//Map<String, String> monsters = new TreeMap<>();//트리 방식을 사용 (key를 정렬함)
		
		//데이터 추가 - put(k, v)
		monsters.put("이상해씨", "풀");//key=이상해씨, value=풀
		monsters.put("피카츄", "전기");//key=피카츄, value=전기
		monsters.put("라이츄", "전기");//key=라이츄, value=전기 (중복된 value는 문제가 없음)
		monsters.put("이상해씨", "독");//key=이상해씨, value=독 (중복된 key는 value를 덮어쓰기함)
		
		//개수 확인
		System.out.println("등록된 몬스터 수 : " + monsters.size());
		
		//추출
		System.out.println("이상해씨의 속성 : " + monsters.get("이상해씨"));
		System.out.println("또가스의 속성 : " + monsters.get("또가스"));
		
		//검색
		System.out.println(monsters.containsKey("피카츄"));//key 검사
		System.out.println(monsters.containsValue("전기"));//value 검사
		
		//삭제
		monsters.remove("피카츄");
		
		//출력
		System.out.println(monsters);
	}
}










