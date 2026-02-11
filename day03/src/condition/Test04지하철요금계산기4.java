package condition;

import java.time.LocalDate;

public class Test04지하철요금계산기4 {
	public static void main(String[] args) {
		//입력
		int birth = 2000;
		
		//처리
		//int year = 2025;
		int year = LocalDate.now().getYear();
		int age = year - birth + 1;
		
		//출력
		if(age >= 65 || age <= 7) {
			System.out.println("보증금 포함 500원입니다");
		}
		//else if(age >= 20 && age <= 64) {
		else if(age >= 20) {
			System.out.println("보증금 포함 2050원입니다");
		}
		//else if(age >= 14 && age <= 19) {
		else if(age >= 14) {
			System.out.println("보증금 포함 1400원입니다");
		}
		else {
			System.out.println("보증금 포함 1050원입니다");
		}
	}
}


