package loop;

public class Test05타이머3 {
	public static void main(String[] args) {
		
		//(ex) 2분 25초 = 145초 이므로 145부터 0까지 줄어드는 반복문을 만들어보자!
		
		int min = 2;
		int sec = 25;
		
		int time = min * 60 + sec;
		
		for(int i=time ; i >= 0; i--) {
			int minute = i / 60;
			int second = i % 60;
			System.out.println(minute+"분 "+second+"초 남았습니다");
		}
		
	}
}
