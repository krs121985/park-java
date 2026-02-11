package loop3;

public class Test02런닝시간계산기5 {
	public static void main(String[] args) {

		int total = 0;//누적 시간
		int time = 10;//초기값(첫날 시간)
		
		for(int day=1; day <= 30; day++) {
			System.out.println(day+"일차 : "+ time +"분");
			total += time;//누적 합계 계산
			
			if(day % 7 == 0) {
				time += 5;//시간 증가
			}
		}
		
		//System.out.println("총 누적시간 = " + total);
		System.out.println("총 누적시간 = " + total/60 +"시간 "+total%60+"분");
		
	}
}
