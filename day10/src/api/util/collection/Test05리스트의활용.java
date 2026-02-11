package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test05리스트의활용 {
	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<>();
		List<Integer> list = new ArrayList<>();//업캐스팅
		
		for(int i=1; i <= 10; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		System.out.println(list.size());//데이터 개수
		
		//원하는 위치의 데이터 추출
		//System.out.println(list.get(0));
		
		for(int i=0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		//보조 도구 : Collections 클래스
		Collections.shuffle(list);//무작위 섞기
		System.out.println(list);
		
		Collections.sort(list);//정렬
		System.out.println(list);
		
		Collections.reverse(list);//뒤집기
		System.out.println(list);
	}
}












