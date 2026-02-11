package condition;

public class Test02지각판정기 {
	public static void main(String[] args) {
		//입력
		int time = 1005;
		
		//처리
		
		//출력
		if(time <= 940){
			System.out.println("정상 출석입니다");
		}
		if(time > 940){
			System.out.println("지각입니다");
		}
		
	}
}
