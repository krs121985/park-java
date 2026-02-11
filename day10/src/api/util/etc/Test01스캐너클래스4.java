package api.util.etc;

import java.util.Scanner;

public class Test01스캐너클래스4 {
	public static void main(String[] args) {
		//스캐너는 원래 입력도구라기보다 패턴 분석기이다 (입력 기능도 있을 뿐)
		
		String song = "100 200 55 7000 30000";
		
		Scanner sc = new Scanner(song);
		
		while(sc.hasNextInt()) {
			int number = sc.nextInt();//다음 줄을 가져오세요
			System.out.println("number = " + number);
		}
		
		//역할을 다 하고 나면 사용 중지를 해줘야 함 (안하면 메모리를 계속 점
		sc.close();
	}
}












