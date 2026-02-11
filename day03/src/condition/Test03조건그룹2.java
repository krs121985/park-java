package condition;

public class Test03조건그룹2 {
	public static void main(String[] args) {
		//한 번 물어봐서 두 가지 경우를 처리하는 방법
		int number = 7;
		
		if(number % 2 == 0) {
			System.out.println("짝수입니다");
		}
		else {//if 뒤에 else를 쓰면 if가 거짓말일 때 else가 자동으로 실행된다!
			System.out.println("홀수입니다");
		}
		
		//한 번 물어봐서 여러 가지 경우를 처리하는 방법? (ex : 계절 판정)
		int month = 3;
		
		if(month >= 3 && month <= 5) {
			System.out.println("봄");
		}
		else if(month >= 6 && month <= 8) {
			System.out.println("여름");
		}
		else if(month >= 9 && month <= 11) {
			System.out.println("가을");
		}
		else {
			System.out.println("겨울");
		}
	}
}







