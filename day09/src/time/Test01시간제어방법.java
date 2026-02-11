package time;

import java.text.SimpleDateFormat;
//java.lang을 제외한 모든 패키지는 import를 해야한다 (필수패키지)
import java.util.Date;

public class Test01시간제어방법 {
	public static void main(String[] args) {
		//시스템의 시간을 조회하거나 원하는 시간을 만들어서 프로그래밍 방법
		//- 시간은 2000년을 기준으로 중대한 변화가 있었음(Y2K, 밀레니엄 버그)
		//- 20세기(19xx년대)에 컴퓨터가 만들어졌고, 이 당시에는 메모리 가격이 제일 비쌌음
		//- 이 당시에는 메모리 아껴쓰는 사람이 프로그램 잘하는 사람이었음
		//- 날짜도 좀 적은 글자로 표현하면 잘하는거였고, 연도를 2자리로 표현해서 사용했었음
		//- (ex) 990101이라고 하면 누구나 1999년 1월 1일을 생각했었음
		//- 2000년이 지나면 6자리로는 구분이 안되는 상황이 발생 (ex : 020101은 1902년인가? 2002년인가?)
		
		//자바도 마찬가지 상황을 겪었다...
		//[1] java.util.Date가 6자리 날짜를 기반으로 나왔다 (199x)
		//[2] Y2K로 이슈가 되니까 문제점을 해결해서 java.util.Calendar를 만들었다
		//[3] java 8버전에서 시간 전용 클래스들만 모아서 java.time 패키지를 만들었다(2014년 3월)
		
		
		Date a = new Date();//일반적인 생성자를 이용하는 경우
		Date b = new Date(2026, 1, 9);//비추천 생성자를 이용하는 경우
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
//		형식을 내 마음대로 변경할 수 있음
//		SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(fmt.format(a));
		
//		API 문서를 참고해서 다음 형태의 시간을 출력해보세요
//		[1] 2026년 1월 9일 금 오후 3시 7분 20초
		SimpleDateFormat fmt2 = new SimpleDateFormat("y년 M월 d일 E a h시 m분 s초");
		System.out.println(fmt2.format(a));
//		[2] 2026-01-09 15:07:20
		SimpleDateFormat fmt3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(fmt3.format(a));
	}
}
















