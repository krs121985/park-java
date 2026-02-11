package array;

import java.util.Random;
import java.util.Scanner;

public class Test06점심메뉴추천기6 {
	public static void main(String[] args) {
		
		//쉽게 가려면?
		//- 문자열 배열에 메뉴를 넣어놓고 위치만 랜덤으로 뽑게 구현
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("메뉴 개수 입력하세요");
		int size = sc.nextInt();
		
		String[] menuList = new String[size];
		
		for(int i=0; i < menuList.length; i++) {
			System.out.print("메뉴 이름 입력 : ");
			menuList[i] = sc.next();
		}
		
		Random r = new Random();
		int location = r.nextInt(menuList.length);//0부터 menuList.length 개 
		//System.out.println("location = " + location);//확인용
		
		System.out.println("오늘의 추천메뉴 : " + menuList[location]);
		
	}
}












