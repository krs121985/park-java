package condition2;

public class Test02학점계산기 {
	public static void main(String[] args) {
		
		//입력
		int score = 75;
		
		//처리
		
		//출력
		switch(score) {
		case 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90:
			System.out.println("당신의 예상 학점은 A+ 입니다");
			break;
		case 89, 88, 87, 86, 85, 84, 83, 82, 81, 80:
			System.out.println("당신의 예상 학점은 A 입니다");
			break;
		case 79, 78, 77, 76, 75, 74, 73, 72, 71, 70:
			System.out.println("당신의 예상 학점은 B 입니다");
			break;
		case 69, 68, 67, 66, 65, 64, 63, 62, 61, 60:
			System.out.println("당신의 예상 학점은 C 입니다");
			break;
		default:
			System.out.println("당신의 예상 학점은 F 입니다");
			break;
		}
	}
}
