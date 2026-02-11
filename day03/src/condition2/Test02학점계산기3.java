package condition2;

public class Test02학점계산기3 {
	public static void main(String[] args) {
		
		//입력
		int score = 75;
		
		//처리
		int ten = score / 10;
		
		//String grade = "A+" or "A" or "B" or "C" or "F";
		String grade;
		switch(ten) {
		case 10, 9:
			grade = "A+";
			break;
		case 8:
			grade = "A";
			break;
		case 7:
			grade = "B";
			break;
		case 6:
			grade = "C";
			break;
		//case 5, 4, 3, 2, 1, 0://안됨... 모든 경우에 변수에 값이 들어가지 않음
		default: //모든 경우에 변수가 초기화됨
			grade = "F";
			break;
		}
		
		//출력
		System.out.println("당신의 예상 학점은 "+grade+" 입니다");
	}
}








