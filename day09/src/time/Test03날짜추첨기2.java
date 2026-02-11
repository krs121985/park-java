package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test03날짜추첨기2 {
	public static void main(String[] args) {
		
		//랜덤으로 2026년 중 하루를 추첨하여 출력하세요!
		//- choice라는 이름으로 1~365를 추첨한 뒤 2026년 1월 choice일 이라고 설정하면 되지 않을까?
		//- (+추가) 주말이 나올 때까지 추첨
		
		Random r = new Random();
		Calendar c = Calendar.getInstance();
		
		while(true) {
			int choice = r.nextInt(365) + 1;//1부터 365개
			
			//설정
			c.set(2026, 0, choice);
			
			//토요일 또는 일요일이면 나가라
			int week = c.get(Calendar.DAY_OF_WEEK);
			if(week == Calendar.SATURDAY || week == Calendar.SUNDAY) {
				break;
			}
		}
		
		//출력
		Date d = c.getTime();//date로 변환
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(fmt.format(d));
		
		
	}
}




