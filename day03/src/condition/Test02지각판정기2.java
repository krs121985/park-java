package condition;

public class Test02지각판정기2 {
	public static void main(String[] args) {
		//입력
		int time = 1005;
		
		//처리
		int hour = time / 100;
		int minute = time % 100;
		
		//출력
		//if(8시 이전이거나 9시라면 40분 이전인 경우){
		//if(8시 이전 || 9시 40분 이전) {
		if(hour <= 8 || (hour == 9 && minute <= 40)) {
			System.out.println("정상 출석입니다");
		}
		//if(9시라면 41분 이후거나 10시이후인 경우){
		//if(9시 41분 이후 || 10시 이후) {
		if((hour == 9 && minute >= 41) || hour >= 10) {
			System.out.println("지각입니다");
		}
		
	}
}
