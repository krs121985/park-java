package condition;

public class Test02지각판정기3 {
	public static void main(String[] args) {
		//입력
		int time = 1005;
		
		//처리
		int hour = time / 100;
		int minute = time % 100;
		
		int tag = hour * 60 + minute;//분으로 환산
		int judge = 9 * 60 + 40;//지각 판정 시간을 분으로 환산
		
		//출력
		if(tag <= judge) {
			System.out.println("정상 출석입니다");
		}
		if(tag > judge) {
			System.out.println("지각입니다");
		}
		
	}
}
