package input;

public class Test02만나이계산기 {
	public static void main(String[] args) {
		//입력
		int year = 2000;
		int month = 6;
		
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
