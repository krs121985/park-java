package condition;

import java.time.LocalDate;
import java.util.Scanner;

public class Test04지하철요금계산기6 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도 4자리를 입력하세요");
		int birth = sc.nextInt();
		
		//처리
		//int year = 2025;
		int year = LocalDate.now().getYear();
		int age = year - birth + 1;
		
		//출력을 여러번 하는것이 아니라 금액만 조건에 따라 다르게 구하고 출력은 한 번에 할 수 없을까?
		//int price = 0 or 1550 or 900 or 550;
		int price;//변수를 만들기만 하고
		if(age >= 65 || age <= 7) {//어르신 또는 영유아라면
			price = 0;//무료 요금을 설정
		}
		else if(age >= 20) {//성인이라면
			price = 1550;//성인 요금을 설정
		}
		else if(age >= 14) {//청소년이라면
			price = 900;//청소년 요금을 설정
		}
		else {//나머지 = 어린이
			price = 500;//어린이 요금을 설정
		}
		int card = 500;
		
		int total = price + card;
		
		//출력
		System.out.println("보증금 포함 "+total+"원입니다");
	}
}


