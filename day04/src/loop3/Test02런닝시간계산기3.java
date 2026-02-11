package loop3;

public class Test02런닝시간계산기3 {
	public static void main(String[] args) {

		int time = 10;//초기값(첫날 시간)
		
		for(int day=1; day <= 30; day++) {
			System.out.println(day+"일차 : "+ time +"분");
			time += 5;//시간 증가
		}
		
	}
}
