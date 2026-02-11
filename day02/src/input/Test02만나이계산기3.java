package input;

//자동 import 방법
//1. 오류나는 부분에 마우스를 올려 도움말을 클릭
//2. 단축키 (ctrl + shift + o) 입력
import java.util.Scanner;

public class Test02만나이계산기3 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("태어난 연도를 입력하세요");
		int year = sc.nextInt();
		System.out.println("태어난 월을 입력하세요");
		int month = sc.nextInt();
		
		//처리
		int currentYear = 2025;
		int currentMonth = 12;
		
		int user = year * 12 + month;
		int current = currentYear * 12 + currentMonth;
		
		int gap = current - user;//차이 구하기 (개월)
		//System.out.println("gap = " + gap);
		
		int globalAge = gap / 12;
		boolean idCard = globalAge >= 18;
		
		//출력
		System.out.println("만 나이 : "+globalAge+"세");
		System.out.println("주민등록증 발급 가능 여부 : " + idCard);
	}
}
