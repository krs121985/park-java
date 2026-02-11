package loop3;

public class Test03현명한노인3 {
	public static void main(String[] args) {
		
		int total = 0;
		int gold = 1;
		
		for(int day=1 ; day <= 30 ; day++) {
			System.out.println(day+"일차에 받을 금화 : "+gold+"개");
			total += gold;//누적 금화 개수 구하기
			gold *= 2;//2배 증가
		}
		
		System.out.println("총 받게되는 금화 : "+total+"개");
		
	}
}
