package loop3;

public class Test03현명한노인2 {
	public static void main(String[] args) {
		
		int gold = 1;
		
		for(int day=1 ; day <= 30 ; day++) {
			System.out.println(day+"일차에 받을 금화 : "+gold+"개");
			gold *= 2;//2배 증가
		}
		
	}
}
