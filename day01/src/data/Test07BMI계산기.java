package data;

public class Test07BMI계산기 {
	public static void main(String[] args) {
		//입력 - 키, 체중
		float cm = 180;
		float kg = 80;
		
		//처리
		float m = cm / 100;//m로 변환
		float m2 = m * m;//m² (자바에는 제곱기호가 없음... m^2같은건 안됨)
		float bmi = kg / m2;
		
		//출력 - BMI 수치
		System.out.println("BMI = " + bmi);
		
	}
}
