package loop3;

public class Test03현명한노인4 {
	public static void main(String[] args) {
		
		long total = 0L;
		long gold = 1L;
		
		for(int day=1 ; day <= 40 ; day++) {
			System.out.println(day+"일차에 받을 금화 : "+gold+"개");
			total += gold;//누적 금화 개수 구하기
			gold *= 2;//2배 증가
		}
		
		System.out.println("총 받게되는 금화 : "+total+"개");
		
	}
}
