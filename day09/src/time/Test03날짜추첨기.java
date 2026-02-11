package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test03날짜추첨기 {
	public static void main(String[] args) {
		
		//랜덤으로 2026년 중 하루를 추첨하여 출력하세요!
		//- choice라는 이름으로 1~365를 추첨한 뒤 2026년 1월 choice일 이라고 설정하면 되지 않을까?
		
		Random r = new Random();
		
		int choice = r.nextInt(365) + 1;//1부터 365개
		
		Calendar c = Calendar.getInstance();
		
		//설정
		//c.set(Calendar.YEAR, 2026);//2026년
		//c.set(Calendar.MONTH, 0);//1월
		//c.set(Calendar.DATE, choice);//choice일
		c.set(2026, 0, choice);
		
		//출력
		Date d = c.getTime();//date로 변환
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(fmt.format(d));
		
		
	}
}




