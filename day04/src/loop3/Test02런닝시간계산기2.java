package loop3;

public class Test02런닝시간계산기2 {
	public static void main(String[] args) {
		
		for(int day=1; day <= 30; day++) {
			int time = 10 + (day-1) * 5;//권장하지 않음
			System.out.println(day+"일차 : "+ time +"분");
		}
		
	}
}
