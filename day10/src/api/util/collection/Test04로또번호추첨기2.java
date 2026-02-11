package api.util.collection;

import java.util.Random;
import java.util.TreeSet;

public class Test04로또번호추첨기2 {
	public static void main(String[] args) {
		
//		(+추가) Set 저장소는 중복이 자동으로 제거되는 특징이 있다
		
		TreeSet<Integer> numbers = new TreeSet<>();
		Random r = new Random();
		
		while(numbers.size() < 6) {
			int number = r.nextInt(45) + 1;//1부터 45개 (1~45)
			numbers.add(number);//추가하세요! (자동 중복 제거)
		}
		
		System.out.println(numbers);
		
	}
}
