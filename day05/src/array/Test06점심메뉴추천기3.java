package array;

import java.util.Random;

public class Test06점심메뉴추천기3 {
	public static void main(String[] args) {
		
		//쉽게 가려면?
		//- 문자열 배열에 메뉴를 넣어놓고 위치만 랜덤으로 뽑게 구현
		
		String[] menuList = new String[] {
			"자장면", "짬뽕", "볶음밥", "떡볶이", "감자탕", "피자", "수육", "족발", "보쌈"
		};
		
		Random r = new Random();
		int location = r.nextInt(menuList.length);//0부터 menuList.length 개 
		//System.out.println("location = " + location);//확인용
		
		System.out.println("오늘의 추천메뉴 : " + menuList[location]);
		
	}
}












