package array;

import java.util.Random;
import java.util.Scanner;

public class Test06점심메뉴추천기4 {
	public static void main(String[] args) {
		
		//쉽게 가려면?
		//- 문자열 배열에 메뉴를 넣어놓고 위치만 랜덤으로 뽑게 구현
		
		String[] menuList = new String[5];
		
		Scanner sc = new Scanner(System.in);
		//menuList[0] = sc.nextInt();//int를 String에 넣을 수 없다
		menuList[0] = sc.next();
		menuList[1] = sc.next();
		menuList[2] = sc.next();
		menuList[3] = sc.next();
		menuList[4] = sc.next();
		
		Random r = new Random();
		int location = r.nextInt(menuList.length);//0부터 menuList.length 개 
		//System.out.println("location = " + location);//확인용
		
		System.out.println("오늘의 추천메뉴 : " + menuList[location]);
		
	}
}












