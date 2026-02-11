package condition;

import java.util.Scanner;

public class Test06요금계산기2 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("결제 금액을 입력하세요");
		int price = sc.nextInt();
		System.out.println("<결제방법 선택>");
		System.out.println("1.현금결제 (10%할인)");
		System.out.println("2.포인트결제 (5%할인)");
		System.out.println("3.카드결제 (할인없음)");
		int choice = sc.nextInt();//1=현금, 2=포인트, 3=카드
		
		//처리
		//int rate = 10% or 5% or 0%;//할인율
		int rate;
		if(choice == 1) {//현금
			rate = 10;
		}
		else if(choice == 2) {//포인트
			rate = 5;
		}
		else {//카드
			rate = 0;
		}
		
		int discount = price * rate / 100;//할인금액
		int result = price - discount;//결제금액
		
		//출력
		System.out.println("결제하실 금액은 "+result+"원 입니다 (할인된 금액 : "+discount+"원)");
		
	}
}
