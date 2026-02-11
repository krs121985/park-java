package array;

import java.util.Random;

public class Test06점심메뉴추천기2 {
	public static void main(String[] args) {
		
		//쉽게 가려면?
		//- 문자열 배열에 메뉴를 넣어놓고 위치만 랜덤으로 뽑게 구현
		
		String[] menuList = new String[] {
			"자장면", "짬뽕", "볶음밥", "떡볶이", "감자탕"
		};
		
		Random r = new Random();
		int location = r.nextInt(5);//0부터 5개 (0, 1, 2, 3, 4)
		
		System.out.println("오늘의 추천메뉴 : " + menuList[location]);
		
	}
}












