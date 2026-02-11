package data;

public class Test06성적계산기 {
	public static void main(String[] args) {
		//입력
		int korean = 85;
		int math = 88;
		int english = 83;
		
		//처리
		int total = korean + math + english;
		//int average = total / 3;
		//float average = total / 3f;
		float average = (float)total / 3;//변환 연산(cast-operator)
		
		//출력
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + average);
	}
}
