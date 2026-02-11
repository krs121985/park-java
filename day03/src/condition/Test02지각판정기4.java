package condition;

import java.util.Scanner;

public class Test02지각판정기4 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("입실 시각을 입력하세요 (ex : 1005)");
		int time = sc.nextInt();
		
		//처리
		int hour = time / 100;
		int minute = time % 100;
		
		int tag = hour * 60 + minute;//분으로 환산
		int judge = 9 * 60 + 40;//지각 판정 시간을 분으로 환산
		
		//출력
		if(tag <= judge) {
			System.out.println("정상 출석입니다");
		}
		if(tag > judge) {
			System.out.println("지각입니다");
		}
		
	}
}
