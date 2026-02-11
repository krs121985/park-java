package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test02캘린더다루기 {
	public static void main(String[] args) {
		//Date의 문제점을 해결한 Calendar 클래스 등장
		//1. 1900년을 기준으로 연도 설정
		//2. 시간 변경이 어려움 (1번과 같은 이유로)
		//3. 월이 0부터 11로 관리됨 -------------------> 해결안됨
		//4. Date와도 호환이 가능하게 구현해둠
		//5. 달력의 종류를 설정할 수 있도록 클래스 체계가 구성되어 있음
		
		//직접 생성
		//Calendar c = new Calendar();//추상클래스
		//Calendar c = new GregorianCalendar();//업캐스팅으로 직접 생성
		Calendar c = Calendar.getInstance();//자체 생성 명령
		//System.out.println("c = " + c);//시간 정보 파악이 어려움
		
		//설정
		//c.setYear(2025);//우리가 배운대로라면...
		c.set(Calendar.YEAR, 2025);//199x 스타일 (항목과 값을 같이 넣어서 변경)
		c.set(Calendar.MONTH, 4);//월이 0~11이라는 것에 주의
		//c.set(Calendar.DAY_OF_MONTH, 20);
		c.set(Calendar.DATE, 20);
		
		
		//계산
		c.add(Calendar.YEAR, 2);//2년뒤로 변경
		c.add(Calendar.DATE, 100);//100일뒤로 변경
		
		//출력
		Date d = c.getTime();//date로 변환
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(fmt.format(d));
	}
}











