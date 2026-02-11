package condition2;

public class Test02학점계산기2 {
	public static void main(String[] args) {
		
		//입력
		int score = 75;
		
		//처리
		int ten = score / 10;
		
		//출력
		switch(ten) {
		case 10, 9:
			System.out.println("당신의 예상 학점은 A+ 입니다");
			break;
		case 8:
			System.out.println("당신의 예상 학점은 A 입니다");
			break;
		case 7:
			System.out.println("당신의 예상 학점은 B 입니다");
			break;
		case 6:
			System.out.println("당신의 예상 학점은 C 입니다");
			break;
		default:
			System.out.println("당신의 예상 학점은 F 입니다");
			break;
		}
	}
}
