package array;

import java.util.Random;

public class Test06점심메뉴추천기 {
	public static void main(String[] args) {
		
		//쉽게 가려면?
		//- 랜덤으로 짜장, 떡볶이, 국밥 중 하나 출력
		
		Random r = new Random();
		//1부터 3까지 뽑아서 1이 나오면 짜장인걸로 치고, 2가 나오면 떡볶이로 치고, 3이 나오면 국밥으로 치자!

		int choice = r.nextInt(3) + 1;//1부터 3개
		
		if(choice == 1) {
			System.out.println("오늘은 자장면이다!");
		}
		else if(choice == 2) {
			System.out.println("오늘은 떡볶이다!");
		}
		else {
			System.out.println("오늘은 따듯한 국밥입니다!");
		}
		
	}
}












