package input;

import java.util.Scanner;

public class Test03술값계산기2 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("총 요금을 입력하세요");
		int total = sc.nextInt();
		System.out.println("인원수를 입력하세요");
		int people = sc.nextInt();
		
		//처리
		int price = total / people;//몫
		int mod = total % people;//나머지
		
		//출력
		System.out.println("1인당 "+price+"원 계산하셔야 합니다");
		System.out.println("자투리 금액은 "+mod+"원 입니다");
	}
}
