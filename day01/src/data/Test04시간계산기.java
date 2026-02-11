package data;

public class Test04시간계산기 {
	public static void main(String[] args) {//main 메소드
		//입력
		int hour = 3 , minute = 40;
		int days = 14;
		
		//처리
		int time = hour * 60 + minute;
		//System.out.println(time);//중간 확인용
		int total = time * days;
		//System.out.println(total);//중간 확인용
		
		int hour2 = total / 60;
		int minute2 = total % 60;
		
		//출력
		System.out.println(hour2);
		System.out.println(minute2);
		System.out.println(hour2 + "시간 "+minute2 +"분");
	}
}
