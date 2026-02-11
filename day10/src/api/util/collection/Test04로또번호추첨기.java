package api.util.collection;

import java.util.Random;
import java.util.TreeSet;

public class Test04로또번호추첨기 {
	public static void main(String[] args) {
		
		//저장소 생성 및 랜덤 추첨 도구 생성
		TreeSet<Integer> numbers = new TreeSet<>();
		Random r = new Random();
		
//		for(int i=0; i < 6; i++) {
		while(numbers.size() < 6) {
			int number = r.nextInt(45) + 1;//1부터 45개 (1~45)
//			if(numbers.contains(number) == false) {//저장소에 존재하지 않는 숫자라면
			if(!numbers.contains(number)) {//저장소에 존재하지 않는 숫자라면
				numbers.add(number);//추가하세요!
			}
		}
		
		System.out.println(numbers);
		
	}
}
