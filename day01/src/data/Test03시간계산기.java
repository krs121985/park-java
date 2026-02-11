package data;

public class Test03시간계산기 {//클래스
	public static void main(String[] args) {//main메소드
		//입력
		int saturdayHour = 3, saturdayMinute = 50;
		int sundayHour = 4, sundayMinute = 20;
		
		//처리
		//- 60이라는 숫자는 변수 처리할 필요가 없다 (절대불변의 진리 = 상수)
		int saturday = saturdayHour * 60 + saturdayMinute;
		int sunday = sundayHour * 60 + sundayMinute;
		int total = saturday + sunday;
		
		//(+추가) 계산된 시간을 원래 형태인 ?시간 ?분으로 되돌리고 싶을 경우
		int hour = total / 60;//몫
		int minute = total % 60;//나머지
		
		//출력
		System.out.println(total);
		System.out.println(hour);
		System.out.println(minute);
		
		

	}
}
